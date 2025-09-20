package com.jylab.todo.dto;

import com.jylab.todo.domain.Todo;

public class TodoResponse {

    private final Long id;
    private final String title;
    private final String description;
    private final boolean isDone;

    public TodoResponse(Long id, String title, String description, boolean isDone) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.isDone = isDone;
    }

    public static TodoResponse from(Todo todo) {
        return new TodoResponse(todo.getId(), todo.getTitle(), todo.getDescription(), todo.isDone());
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public boolean isDone() {
        return isDone;
    }

    public boolean getDone() {
        return isDone;
    }
}
