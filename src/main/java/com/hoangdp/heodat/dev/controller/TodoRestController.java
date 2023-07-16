package com.hoangdp.heodat.dev.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hoangdp.heodat.dev.Todo;
import com.hoangdp.heodat.dev.TodoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v2")
@RequiredArgsConstructor
public class TodoRestController {
    private final TodoService todoService;

    @GetMapping("/todo")
    public List<Todo> findAll(){
        return todoService.getAll();
    }
}
