package com.techja.truyencuoi.ui.storydetail;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.techja.truyencuoi.MainActivity;
import com.techja.truyencuoi.R;
import com.techja.truyencuoi.data.model.StoryTopic;
import com.techja.truyencuoi.data.repository.RemoteStoryRepository;
import com.techja.truyencuoi.databinding.M003FrgStoryPagerBinding;

public class M003StoryPagerFrg extends Fragment {

    private static final String ARG_TOPIC_ID = "arg_topic_id";
    private static final String ARG_POSITION = "arg_position";

    private M003FrgStoryPagerBinding binding;
    private StoryPagerAdapter adapter;
    private StoryTopic topic;
    private int startPosition;
    private RemoteStoryRepository repository;
    private String topicId;

    public static M003StoryPagerFrg newInstance(String topicId, int position) {
        M003StoryPagerFrg fragment = new M003StoryPagerFrg();
        Bundle args = new Bundle();
        args.putString(ARG_TOPIC_ID, topicId);
        args.putInt(ARG_POSITION, position);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = M003FrgStoryPagerBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getArguments() != null) {
            startPosition = getArguments().getInt(ARG_POSITION, 0);
            topicId = getArguments().getString(ARG_TOPIC_ID);
        }
        repository = RemoteStoryRepository.getInstance();
        setupToolbar();
        setupPager();
        loadTopic();
    }

    private void setupToolbar() {
        binding.toolbar.setNavigationOnClickListener(v -> ((MainActivity) requireActivity()).navigateBack());
        binding.toolbar.setTitle(getString(R.string.txt_loading));
    }

    private void setupPager() {
        adapter = new StoryPagerAdapter();
        binding.vpStory.setAdapter(adapter);
        binding.vpStory.setVisibility(View.GONE);
    }

    private void loadTopic() {
        binding.pbLoading.setVisibility(View.VISIBLE);
        repository.fetchTopic(topicId, new RemoteStoryRepository.TopicCallback() {
            @Override
            public void onSuccess(StoryTopic loadedTopic) {
                if (!isAdded()) {
                    return;
                }
                topic = loadedTopic;
                binding.pbLoading.setVisibility(View.GONE);
                binding.vpStory.setVisibility(View.VISIBLE);
                binding.toolbar.setTitle(topic.getTitle());
                adapter.submit(topic.getTitle(), topic.getStories());
                binding.vpStory.post(() -> binding.vpStory.setCurrentItem(startPosition, false));
            }

            @Override
            public void onError(Throwable throwable) {
                if (!isAdded()) {
                    return;
                }
                binding.pbLoading.setVisibility(View.GONE);
                binding.toolbar.setTitle(getString(R.string.txt_error_loading));
                Toast.makeText(requireContext(), throwable.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}

