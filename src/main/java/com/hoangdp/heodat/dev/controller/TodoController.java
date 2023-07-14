package com.hoangdp.heodat.dev.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hoangdp.heodat.dev.Todo;
import com.hoangdp.heodat.dev.service.TodoService;

@Controller
public class TodoController {
    @Autowired
    private TodoService todoService;

    @GetMapping("/listTodo")
    public String index(Model model, @RequestParam(value = "limit", required = false) Integer limit) {
        model.addAttribute("todoList", todoService.findAll(limit));
        return "listTodo";
    }

    @GetMapping("/addTodo")
    public String addTodo(Model model){
        model.addAttribute("todo", new Todo());
        return "addTodo";
    }

    @PostMapping("/addTodo")
    public String addTodo(@ModelAttribute Todo todo) {
        return Optional.ofNullable(todoService.add(todo))
                .map(t -> "success")
                .orElse("failed");
    }
}
