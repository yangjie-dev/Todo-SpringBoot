package com.example.Todo;

import org.springframework.data.annotation.Id;

public class Todo {
    @Id
    public String id;
    public String name;

    public Todo() {
    }

    public Todo(String name) {
        this.name = name;
    }
}