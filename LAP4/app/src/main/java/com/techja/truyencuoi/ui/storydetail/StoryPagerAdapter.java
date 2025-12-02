package com.techja.truyencuoi.ui.storydetail;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.techja.truyencuoi.data.model.StoryEntity;
import com.techja.truyencuoi.databinding.M003ItemPageBinding;

import java.util.ArrayList;
import java.util.List;

public class StoryPagerAdapter extends RecyclerView.Adapter<StoryPagerAdapter.StoryPagerVH> {

    private final List<StoryEntity> stories = new ArrayList<>();
    private String topicTitle = "";

    public void submit(String topicTitle, List<StoryEntity> data) {
        this.topicTitle = topicTitle;
        stories.clear();
        stories.addAll(data);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public StoryPagerVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        M003ItemPageBinding binding = M003ItemPageBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new StoryPagerVH(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull StoryPagerVH holder, int position) {
        holder.bind(stories.get(position));
    }

    @Override
    public int getItemCount() {
        return stories.size();
    }

    class StoryPagerVH extends RecyclerView.ViewHolder {

        private final M003ItemPageBinding binding;

        StoryPagerVH(M003ItemPageBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(StoryEntity story) {
            binding.tvTopic.setText(topicTitle);
            binding.tvStoryTitle.setText(story.getTitle());
            binding.tvStoryContent.setText(story.getContent());
        }
    }
}

