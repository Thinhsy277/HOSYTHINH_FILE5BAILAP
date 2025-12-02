package com.techja.truyencuoi.ui.storylist;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.techja.truyencuoi.MainActivity;
import com.techja.truyencuoi.R;
import com.techja.truyencuoi.data.model.StoryTopic;
import com.techja.truyencuoi.data.repository.RemoteStoryRepository;
import com.techja.truyencuoi.databinding.M002FrgStoryListBinding;

public class M002StoryListFrg extends Fragment {

    private static final String ARG_TOPIC_ID = "arg_topic_id";
    private M002FrgStoryListBinding binding;
    private StoryTopic topic;
    private StoryListAdapter adapter;
    private RemoteStoryRepository repository;
    private String topicId;

    public static M002StoryListFrg newInstance(String topicId) {
        M002StoryListFrg fragment = new M002StoryListFrg();
        Bundle args = new Bundle();
        args.putString(ARG_TOPIC_ID, topicId);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = M002FrgStoryListBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        repository = RemoteStoryRepository.getInstance();
        topicId = requireArguments().getString(ARG_TOPIC_ID);
        setupToolbar();
        setupRecycler();
        loadTopic();
    }

    private void setupToolbar() {
        binding.toolbar.setNavigationOnClickListener(v -> ((MainActivity) requireActivity()).navigateBack());
        binding.toolbar.setTitle("");
    }

    private void setupRecycler() {
        adapter = new StoryListAdapter((position, story) -> {
            if (isAdded()) {
                ((MainActivity) requireActivity()).gotoM003Screen(topic.getId(), position);
            }
        });
        binding.rvStory.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.rvStory.setAdapter(adapter);
    }

    private void loadTopic() {
        binding.pbLoading.setVisibility(View.VISIBLE);
        binding.rvStory.setVisibility(View.GONE);
        binding.toolbar.setTitle(getString(R.string.txt_loading));

        repository.fetchTopic(topicId, new RemoteStoryRepository.TopicCallback() {
            @Override
            public void onSuccess(StoryTopic loadedTopic) {
                if (!isAdded()) {
                    return;
                }
                topic = loadedTopic;
                binding.pbLoading.setVisibility(View.GONE);
                binding.rvStory.setVisibility(View.VISIBLE);
                binding.toolbar.setTitle(topic.getTitle());
                adapter.submit(topic.getStories());
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

