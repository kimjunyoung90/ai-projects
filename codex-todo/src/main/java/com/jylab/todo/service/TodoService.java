package com.jylab.todo.service;

import com.jylab.todo.domain.Todo;
import com.jylab.todo.dto.TodoCreateRequest;
import com.jylab.todo.dto.TodoResponse;
import com.jylab.todo.dto.TodoUpdateRequest;
import com.jylab.todo.exception.TodoNotFoundException;
import com.jylab.todo.repository.TodoRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Transactional
    public TodoResponse createTodo(TodoCreateRequest request) {
        Todo todo = new Todo(request.getTitle(), request.getDescription());
        Todo savedTodo = todoRepository.save(todo);
        return TodoResponse.from(savedTodo);
    }

    public List<TodoResponse> getTodos() {
        return todoRepository.findAll()
                .stream()
                .map(TodoResponse::from)
                .collect(Collectors.toList());
    }

    public TodoResponse getTodo(Long id) {
        Todo todo = findTodo(id);
        return TodoResponse.from(todo);
    }

    @Transactional
    public TodoResponse updateTodo(Long id, TodoUpdateRequest request) {
        Todo todo = findTodo(id);
        todo.update(request.getTitle(), request.getDescription(), request.getIsDone());
        return TodoResponse.from(todo);
    }

    @Transactional
    public void deleteTodo(Long id) {
        Todo todo = findTodo(id);
        todoRepository.delete(todo);
    }

    @Transactional
    public TodoResponse updateTodoStatus(Long id, boolean isDone) {
        Todo todo = findTodo(id);
        todo.setDone(isDone);
        return TodoResponse.from(todo);
    }

    private Todo findTodo(Long id) {
        return todoRepository.findById(id)
                .orElseThrow(() -> new TodoNotFoundException(id));
    }
}
