package com.hoangdp.heodat.dev.controller;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hoangdp.heodat.dev.Todo;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/api/v1")
public class RestApiController {
    private List<Todo> todoList = new CopyOnWriteArrayList<>();

    @PostConstruct
    public void init() {
        todoList = IntStream.range(0, 10).mapToObj(i -> new Todo(i, "title-" + i, "detail-" + i))
                .collect(Collectors.toList());
    }

    @GetMapping("/todo")
    public List<Todo> getTodoList() {
        return todoList;
    }

    @GetMapping("/todo/{todoId}")
    public Todo getTodo(@PathVariable(name = "todoId") Integer todoId) {
        return todoList.get(todoId);
    }

    @PutMapping("/todo/{todoId}")
    public Todo editTodo(@PathVariable(name = "todoId") Integer todoId, @RequestBody Todo todo) {
        todoList.set(todoId, todo);
        return todo;
    }

    @DeleteMapping("/todo/{todoId}")
    public ResponseEntity<Void> deleteTodo(@PathVariable(name = "todoId") Integer todoId) {
        todoList.remove(todoId.intValue());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/todo")
    public ResponseEntity<Todo> addTodo(@RequestBody Todo todo) {
        todoList.add(todo);
        return ResponseEntity.ok().body(todo);
    }
}
