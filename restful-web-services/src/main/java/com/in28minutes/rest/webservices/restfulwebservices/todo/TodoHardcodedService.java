package com.in28minutes.rest.webservices.restfulwebservices.todo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
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

    public Todo deleteTodoById(long id) {
        Todo todo = findById(id);
        if(todo == null) return null;
        // if remove operation successful
        if(todos.remove(todo)) {
            return todo;
        }
        return null;
    }

    public Todo findById(long id) {
        for(Todo todo : todos) {
            if(id == todo.getId()) {
                return todo;
            }
        }
        return null;
    }

    public Todo saveTodo(Todo todo) {
        //insert new todo with new incremented ID
        if(todo.getId() == -1 || todo.getId() == 0) { todo.setId(++idCounter); }
        // modify existing todo by deleting current todo, and add another one -- CHANGE LATER
        else { deleteTodoById(todo.getId()); }
        todos.add(todo);
        return todo;
    }
}
