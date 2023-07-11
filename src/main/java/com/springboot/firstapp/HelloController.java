package com.springboot.firstapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    //HTTP GET Request
    //Para acceder a esta API usar http:localhost:8080/hello-world
    @GetMapping("/hello-world")
    public String helloWOrld(){
        return "Hola mundo";
    }

}
