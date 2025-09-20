package com.jylab.controller;

import com.jylab.dto.TodoCreateRequest;
import com.jylab.dto.TodoResponse;
import com.jylab.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/todos")
public class TodoWebController {

    private final TodoService todoService;

    @Autowired
    public TodoWebController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public String list(Model model) {
        List<TodoResponse> todos = todoService.getAllTodos();
        model.addAttribute("todos", todos);
        return "list";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("todo", new TodoCreateRequest());
        return "create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute TodoCreateRequest request) {
        todoService.createTodo(request);
        return "redirect:/todos";
    }

    @PostMapping("/{id}/toggle")
    public String toggleComplete(@PathVariable Long id) {
        TodoResponse todo = todoService.getTodoById(id);
        com.jylab.dto.TodoUpdateRequest updateRequest = new com.jylab.dto.TodoUpdateRequest();
        updateRequest.setIsDone(!todo.getIsDone());
        todoService.updateTodo(id, updateRequest);
        return "redirect:/todos";
    }
}