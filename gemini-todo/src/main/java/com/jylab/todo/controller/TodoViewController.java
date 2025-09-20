package com.jylab.todo.controller;

import com.jylab.todo.dto.TodoCreateRequest;
import com.jylab.todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/todos")
@RequiredArgsConstructor
public class TodoViewController {

    private final TodoService todoService;

    @GetMapping
    public String getAllTodos(Model model) {
        model.addAttribute("todos", todoService.getAllTodos());
        return "list";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("todoCreateRequest", new TodoCreateRequest());
        return "create";
    }

    @PostMapping
    public String createTodo(@ModelAttribute TodoCreateRequest request) {
        todoService.createTodo(request);
        return "redirect:/todos";
    }

    @PostMapping("/{id}/toggle")
    public String toggleTodoStatus(@PathVariable Long id) {
        todoService.toggleTodoStatus(id);
        return "redirect:/todos";
    }

    @PostMapping("/{id}/delete")
    public String deleteTodo(@PathVariable Long id) {
        todoService.deleteTodo(id);
        return "redirect:/todos";
    }
}
