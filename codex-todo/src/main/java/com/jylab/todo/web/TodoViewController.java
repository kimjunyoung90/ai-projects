package com.jylab.todo.web;

import com.jylab.todo.dto.TodoCreateRequest;
import com.jylab.todo.service.TodoService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/todos")
public class TodoViewController {

    private final TodoService todoService;

    public TodoViewController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("todos", todoService.getTodos());
        return "list";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        if (!model.containsAttribute("todoCreateRequest")) {
            model.addAttribute("todoCreateRequest", new TodoCreateRequest());
        }
        return "create";
    }

    @PostMapping
    public String create(@Valid @ModelAttribute("todoCreateRequest") TodoCreateRequest request,
                         BindingResult bindingResult,
                         Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("todoCreateRequest", request);
            return "create";
        }
        todoService.createTodo(request);
        return "redirect:/todos";
    }

    @PostMapping("/{id}/status")
    public String updateStatus(@PathVariable Long id,
                               @RequestParam(name = "isDone", defaultValue = "false") boolean isDone) {
        todoService.updateTodoStatus(id, isDone);
        return "redirect:/todos";
    }
}
