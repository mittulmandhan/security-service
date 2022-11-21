package com.liquorstore.oauthresource.server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/api/users")
    public String[] getUser() {
        System.out.println("In resource server");
        return new String[]{"Mittul", "Pooja", "Shivam"};
    }

}
