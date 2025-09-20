package com.jylab.todo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class TodoUpdateRequest {

    @NotBlank(message = "제목은 필수입니다.")
    private String title;
    private String description;

    @NotNull(message = "isDone 값은 필수입니다.")
    private Boolean isDone;

    public TodoUpdateRequest() {
    }

    public TodoUpdateRequest(String title, String description, Boolean isDone) {
        this.title = title;
        this.description = description;
        this.isDone = isDone;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Boolean getIsDone() {
        return isDone;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setIsDone(Boolean isDone) {
        this.isDone = isDone;
    }
}
