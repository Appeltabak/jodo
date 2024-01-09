package com.appeltabak.jodo;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoController {

    private final TodoRepository repository;

    TodoController(TodoRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/todos")
    public List<TodoResource> GetTodos() {
        return repository.findAll();
    }

    @GetMapping("/todos/{id}")
    public TodoResource GetTodo(@RequestParam long id) {
        return repository.getReferenceById(id);
    }

    @PostMapping("/todos")
    TodoResource PostTodo(@RequestBody TodoResource todo) {
        return repository.save(todo);
    }

    @PutMapping("/todos")
    TodoResource PutTodo(@RequestParam long id, @RequestBody TodoResource newTodo) {
        return repository.findById(id).map(todo -> {
            todo.setContent(newTodo.getContent());
            return repository.save(todo);
        }).orElseGet(() -> {
            // newTodo.setId(id);
            return repository.save(newTodo);
        });
    }
}
