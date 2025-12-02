package com.techja.truyencuoi.ui.topics;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.techja.truyencuoi.data.model.StoryTopic;
import com.techja.truyencuoi.databinding.M001ItemTopicBinding;

import java.util.ArrayList;
import java.util.List;

public class TopicAdapter extends RecyclerView.Adapter<TopicAdapter.TopicVH> {

    public interface OnTopicClickListener {
        void onTopicClick(StoryTopic topic);
    }

    private final List<StoryTopic> items = new ArrayList<>();
    private final OnTopicClickListener listener;

    public TopicAdapter(OnTopicClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public TopicVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        M001ItemTopicBinding binding = M001ItemTopicBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new TopicVH(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull TopicVH holder, int position) {
        holder.bind(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void submit(List<StoryTopic> topics) {
        items.clear();
        items.addAll(topics);
        notifyDataSetChanged();
    }

    class TopicVH extends RecyclerView.ViewHolder {

        private final M001ItemTopicBinding binding;

        TopicVH(M001ItemTopicBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(StoryTopic topic) {
            binding.tvName.setText(topic.getTitle());
            binding.tvDesc.setText(topic.getDescription());
            binding.tvEmoji.setText(topic.getEmoji());
            binding.getRoot().setOnClickListener(v -> {
                if (listener != null) {
                    listener.onTopicClick(topic);
                }
            });
        }
    }
}

