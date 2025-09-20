package com.jylab.todo.dto;

import jakarta.validation.constraints.NotBlank;

public class TodoCreateRequest {

    @NotBlank(message = "제목은 필수입니다.")
    private String title;
    private String description;

    public TodoCreateRequest() {
    }

    public TodoCreateRequest(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
