package com.example.dto;

public class RowTopicItem {
    private String Topic;

    public String getTopic() {
        return Topic;
    }

    public void setTopic(String topic) {
        Topic = topic;
    }

    public RowTopicItem(String topic) {
        super();
        Topic = topic;
    }
}
