package com.techja.truyencuoi.data.network;

import com.techja.truyencuoi.data.model.StoryEntity;
import com.techja.truyencuoi.data.model.StoryTopic;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {

    @GET("topics")
    Call<List<StoryTopic>> getTopics();

    @GET("topics/{id}")
    Call<StoryTopic> getTopicById(@Path("id") String id);

    @GET("stories/{id}")
    Call<StoryEntity> getStoryById(@Path("id") int id);
}

