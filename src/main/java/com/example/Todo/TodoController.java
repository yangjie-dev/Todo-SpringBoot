package com.example.Todo;

import java.util.ArrayList;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoController {
    @GetMapping("/todo")
    public ArrayList<TodoItem> GetTodos(){
        TodoItem todo = new TodoItem(1,  "todo");
           
        ArrayList<TodoItem> todos = new ArrayList<TodoItem>();
        todos.add(todo);
        return todos;
    }
}
