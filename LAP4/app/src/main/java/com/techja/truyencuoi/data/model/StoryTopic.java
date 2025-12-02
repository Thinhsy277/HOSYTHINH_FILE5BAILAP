package com.techja.truyencuoi.data.model;

import java.util.ArrayList;
import java.util.List;

public class StoryTopic {
    private String id;
    private String title;
    private String emoji;
    private String description;
    private List<StoryEntity> stories;

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getEmoji() {
        return emoji;
    }

    public String getDescription() {
        return description;
    }

    public List<StoryEntity> getStories() {
        return stories == null ? new ArrayList<>() : stories;
    }
}

