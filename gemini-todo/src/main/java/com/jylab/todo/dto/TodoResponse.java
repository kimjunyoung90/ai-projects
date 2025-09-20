package com.jylab.todo.dto;

import com.jylab.todo.entity.Todo;
import lombok.Getter;

@Getter
public class TodoResponse {
    private final Long id;
    private final String title;
    private final String description;
    private final boolean isDone;

    public TodoResponse(Todo todo) {
        this.id = todo.getId();
        this.title = todo.getTitle();
        this.description = todo.getDescription();
        this.isDone = todo.getIsDone();
    }
}
