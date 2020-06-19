package com.example.Todo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping(path = "/todos")
public class TodoController {
    @Autowired
    private TodoRepository repository;

    @GetMapping()
    public List<Todo> GetTodos() {
        // Todo todo = new Todo("todo");

        // repository.insert(todo);

        List<Todo> todos = repository.findAll();
        return todos;
    }

    @GetMapping("/{id}")
    Todo GetTodoById(@PathVariable String id) {
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping()
    Todo CreateTodo(@RequestBody Todo todo) {
        return repository.save(todo);
    }

    @PutMapping("/{id}")
    Todo UpdateTodoById(@PathVariable String id, @RequestBody Todo todo) {
        return repository.findById(id).map(t -> {
            t.name = todo.name;
            return repository.save(t);
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    void deleteEmployee(@PathVariable String id) {
        repository.deleteById(id);
    }
}
