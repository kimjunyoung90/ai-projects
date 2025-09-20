package com.jylab.todo.dto;

import com.jylab.todo.entity.Todo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TodoCreateRequest {
    private String title;
    private String description;

    public Todo toEntity() {
        return Todo.builder()
                .title(title)
                .description(description)
                .isDone(false)
                .build();
    }
}
