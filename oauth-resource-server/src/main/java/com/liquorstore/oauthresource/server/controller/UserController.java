package com.liquorstore.oauthresource.server.controller;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    public String[] getUser() {
        return new String[]{"Mittul", "Pooja", "Shivam"};
    }

}
