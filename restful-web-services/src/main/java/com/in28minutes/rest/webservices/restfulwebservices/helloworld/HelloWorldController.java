package com.in28minutes.rest.webservices.restfulwebservices.helloworld;

import org.springframework.web.bind.annotation.*;

//Controller
@CrossOrigin(origins="http://localhost:4200")
@RestController
public class HelloWorldController {

    //GET
    //URI - /hello-world
    @GetMapping(path="/hello-world")
    public String helloWorld() {
        return "Hello World";
    }

    //hello-world-bean
    //bean is automatically converted into JSON
    @GetMapping(path="/hello-world-bean")
    public HelloWorldBean helloWorldBean() {
        // throw new RuntimeException("Internal Server Error!");
        return new HelloWorldBean("Hello World - Changed");
    }
    //hello-world-bean
    //bean is automatically converted into JSON
    @GetMapping(path="/hello-world/path-variable/{name}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
        return new HelloWorldBean(String.format("Hello World, %s", name));
    }
}