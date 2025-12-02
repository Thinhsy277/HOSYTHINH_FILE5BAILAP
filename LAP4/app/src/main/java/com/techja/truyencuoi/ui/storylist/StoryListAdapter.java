package com.techja.truyencuoi.ui.storylist;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.techja.truyencuoi.data.model.StoryEntity;
import com.techja.truyencuoi.databinding.M002ItemStoryBinding;

import java.util.ArrayList;
import java.util.List;

public class StoryListAdapter extends RecyclerView.Adapter<StoryListAdapter.StoryVH> {

    public interface OnStoryClickListener {
        void onStoryClick(int position, StoryEntity story);
    }

    private final List<StoryEntity> items = new ArrayList<>();
    private final OnStoryClickListener listener;

    public StoryListAdapter(OnStoryClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public StoryVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        M002ItemStoryBinding binding = M002ItemStoryBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new StoryVH(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull StoryVH holder, int position) {
        holder.bind(items.get(position), position);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void submit(List<StoryEntity> stories) {
        items.clear();
        items.addAll(stories);
        notifyDataSetChanged();
    }

    class StoryVH extends RecyclerView.ViewHolder {

        private final M002ItemStoryBinding binding;

        StoryVH(M002ItemStoryBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(StoryEntity entity, int position) {
            binding.tvIndex.setText(String.valueOf(position + 1));
            binding.tvStoryName.setText(entity.getTitle());
            binding.tvStoryDesc.setText(entity.getContent());
            binding.getRoot().setOnClickListener(v -> {
                if (listener != null) {
                    listener.onStoryClick(position, entity);
                }
            });
        }
    }
}

