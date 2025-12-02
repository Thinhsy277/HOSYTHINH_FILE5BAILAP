package com.techja.truyencuoi.ui.topics;

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
import com.techja.truyencuoi.databinding.M001FrgTopicsBinding;

public class M001TopicsFrg extends Fragment {

    private M001FrgTopicsBinding binding;
    private TopicAdapter adapter;
    private RemoteStoryRepository repository;

    public static M001TopicsFrg newInstance() {
        return new M001TopicsFrg();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = M001FrgTopicsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        repository = RemoteStoryRepository.getInstance();
        setupRecyclerView();
        loadData();
    }

    private void setupRecyclerView() {
        adapter = new TopicAdapter(topic -> {
            if (isAdded()) {
                ((MainActivity) requireActivity()).gotoM002Screen(topic.getId());
            }
        });
        binding.rvTopics.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.rvTopics.setAdapter(adapter);
    }

    private void loadData() {
        binding.pbLoading.setVisibility(View.VISIBLE);
        binding.rvTopics.setVisibility(View.GONE);
        binding.tvSubtitle.setText(getString(R.string.txt_loading));

        repository.fetchTopics(new RemoteStoryRepository.TopicsCallback() {
            @Override
            public void onSuccess(java.util.List<StoryTopic> topics) {
                if (!isAdded()) {
                    return;
                }
                binding.pbLoading.setVisibility(View.GONE);
                binding.rvTopics.setVisibility(View.VISIBLE);
                binding.tvSubtitle.setText(getString(R.string.txt_topics_subtitle));
                adapter.submit(topics);
            }

            @Override
            public void onError(Throwable throwable) {
                if (!isAdded()) {
                    return;
                }
                binding.pbLoading.setVisibility(View.GONE);
                binding.tvSubtitle.setText(getString(R.string.txt_error_loading));
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

