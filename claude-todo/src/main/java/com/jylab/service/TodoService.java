package com.jylab.service;

import com.jylab.dto.TodoCreateRequest;
import com.jylab.dto.TodoResponse;
import com.jylab.dto.TodoUpdateRequest;
import com.jylab.entity.Todo;
import com.jylab.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    @Autowired
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public TodoResponse createTodo(TodoCreateRequest request) {
        Todo todo = new Todo(request.getTitle(), request.getDescription());
        Todo savedTodo = todoRepository.save(todo);
        return TodoResponse.from(savedTodo);
    }

    public List<TodoResponse> getAllTodos() {
        return todoRepository.findAll()
                .stream()
                .map(TodoResponse::from)
                .collect(Collectors.toList());
    }

    public TodoResponse getTodoById(Long id) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Todo not found with id: " + id));
        return TodoResponse.from(todo);
    }

    public TodoResponse updateTodo(Long id, TodoUpdateRequest request) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Todo not found with id: " + id));

        if (request.getTitle() != null) {
            todo.setTitle(request.getTitle());
        }
        if (request.getDescription() != null) {
            todo.setDescription(request.getDescription());
        }
        if (request.getIsDone() != null) {
            todo.setIsDone(request.getIsDone());
        }

        Todo updatedTodo = todoRepository.save(todo);
        return TodoResponse.from(updatedTodo);
    }

    public void deleteTodo(Long id) {
        if (!todoRepository.existsById(id)) {
            throw new RuntimeException("Todo not found with id: " + id);
        }
        todoRepository.deleteById(id);
    }
}