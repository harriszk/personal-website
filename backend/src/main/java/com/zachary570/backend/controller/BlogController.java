package com.zachary570.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = { "http://localhost:3000", "http://192.168.1.107:3000" })
@RestController
public class BlogController {
    @Autowired
    public BlogController() {

    }

    @GetMapping("/hello-world")
    public String getSample() {
        return "Hello World!";
    }
}
