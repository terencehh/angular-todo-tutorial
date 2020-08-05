package com.in28minutes.rest.webservices.restfulwebservices.todo;
import com.in28minutes.rest.webservices.restfulwebservices.todo.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class TodoResource {

    //autowire the service into here
    @Autowired
    private TodoHardcodedService todoService;

    // GET ALL TODOS
    @GetMapping(path="/users/{username}/todos")
    public List<Todo> getAllTodos(@PathVariable String username) {
        return todoService.findAll();
    }

    // GET A SPECIFIC TODO
    @GetMapping(path="/users/{username}/todos/{id}")
    public Todo getTodo(@PathVariable String username, @PathVariable long id) {
        return todoService.findById(id);
    }

    // DELETE A TODO
    @DeleteMapping(path="/users/{username}/todos/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable String username, @PathVariable long id) {
        Todo todo = todoService.deleteTodoById(id);
        if(todo != null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    // UPDATE A TODO
    @PutMapping(path="/users/{username}/todos/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable String username,
                                           @PathVariable long id,
                                           @RequestBody Todo todo) {
        Todo todoUpdated = todoService.saveTodo(todo);
        return new ResponseEntity<Todo>(todo, HttpStatus.OK);
    }

    // CREATE A TODO - assign a new ID for new Todo
    @PostMapping(path="/users/{username}/todos")
    public ResponseEntity<Todo> updateTodo(@PathVariable String username,
                                           @RequestBody Todo todo) {

        Todo createdTodo = todoService.saveTodo(todo);

        // get current resource url
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdTodo.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }
}
