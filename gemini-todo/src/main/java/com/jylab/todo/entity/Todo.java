package com.jylab.todo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column
    private String description;

    @Column(nullable = false)
    private Boolean isDone = false;

    @Builder
    public Todo(String title, String description, Boolean isDone) {
        this.title = title;
        this.description = description;
        this.isDone = isDone != null ? isDone : false;
    }

    public void update(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public void toggleDone() {
        this.isDone = !this.isDone;
    }
}
