package com.in28minutes.rest.webservices.restfulwebservices.todo;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class TodoHardcodedService {

    // act as database
    private static List<Todo> todos = new ArrayList<Todo>();
    private static int idCounter = 0;

    static {
        todos.add(new Todo(++idCounter, "Terey", "Learn Improv", new Date(), false));
        todos.add(new Todo(++idCounter, "Terey", "Learn Small Talk", new Date(), false));
        todos.add(new Todo(++idCounter, "Terey", "Learn Angular", new Date(), false));
    }

    public List<Todo> findAll() {
        return todos;
    }
}
