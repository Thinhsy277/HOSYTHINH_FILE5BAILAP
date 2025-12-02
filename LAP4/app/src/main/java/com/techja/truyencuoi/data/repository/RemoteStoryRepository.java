package com.techja.truyencuoi.data.repository;

import androidx.annotation.Nullable;

import com.techja.truyencuoi.data.model.StoryTopic;
import com.techja.truyencuoi.data.network.ApiClient;
import com.techja.truyencuoi.data.network.ApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RemoteStoryRepository {

    public interface TopicsCallback {
        void onSuccess(List<StoryTopic> topics);

        void onError(Throwable throwable);
    }

    public interface TopicCallback {
        void onSuccess(StoryTopic topic);

        void onError(Throwable throwable);
    }

    private static RemoteStoryRepository instance;
    private final ApiService apiService;
    private List<StoryTopic> cachedTopics;

    private RemoteStoryRepository() {
        apiService = ApiClient.getApiService();
        cachedTopics = new ArrayList<>();
    }

    public static synchronized RemoteStoryRepository getInstance() {
        if (instance == null) {
            instance = new RemoteStoryRepository();
        }
        return instance;
    }

    public void fetchTopics(TopicsCallback callback) {
        if (cachedTopics != null && !cachedTopics.isEmpty()) {
            callback.onSuccess(cachedTopics);
            return;
        }
        apiService.getTopics().enqueue(new Callback<List<StoryTopic>>() {
            @Override
            public void onResponse(Call<List<StoryTopic>> call, Response<List<StoryTopic>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    cachedTopics = response.body();
                    callback.onSuccess(cachedTopics);
                } else {
                    callback.onError(new IllegalStateException("Không thể tải dữ liệu"));
                }
            }

            @Override
            public void onFailure(Call<List<StoryTopic>> call, Throwable t) {
                callback.onError(t);
            }
        });
    }

    public void fetchTopic(String topicId, TopicCallback callback) {
        StoryTopic cached = findTopicInCache(topicId);
        if (cached != null) {
            callback.onSuccess(cached);
            return;
        }

        apiService.getTopicById(topicId).enqueue(new Callback<StoryTopic>() {
            @Override
            public void onResponse(Call<StoryTopic> call, Response<StoryTopic> response) {
                if (response.isSuccessful() && response.body() != null) {
                    StoryTopic topic = response.body();
                    upsertCache(topic);
                    callback.onSuccess(topic);
                } else {
                    callback.onError(new IllegalStateException("Không tìm thấy chủ đề"));
                }
            }

            @Override
            public void onFailure(Call<StoryTopic> call, Throwable t) {
                callback.onError(t);
            }
        });
    }

    private void upsertCache(StoryTopic topic) {
        if (cachedTopics == null) {
            cachedTopics = new ArrayList<>();
        }
        StoryTopic existing = findTopicInCache(topic.getId());
        if (existing != null) {
            cachedTopics.remove(existing);
        }
        cachedTopics.add(topic);
    }

    @Nullable
    private StoryTopic findTopicInCache(String topicId) {
        if (cachedTopics == null) {
            return null;
        }
        for (StoryTopic topic : cachedTopics) {
            if (topic.getId().equals(topicId)) {
                return topic;
            }
        }
        return null;
    }
}

