package com.liquorstore.client.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.security.Principal;

@RestController
public class HelloController {


    @GetMapping("/hello")
    public String hello(Principal principal) {
        return "Hello! Welcome to my sample resource";
    }

}
