package com.liquorstore.client.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class HelloController {

    @GetMapping("/api/hello")
    public String hello() {
        return "Hello, Welcome to my sample page";
    }

}
