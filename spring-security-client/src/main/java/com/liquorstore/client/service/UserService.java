package com.liquorstore.client.service;

import com.liquorstore.client.entity.User;
import com.liquorstore.client.model.UserModel;

public interface UserService {
    User registerUser(UserModel userModel);
}
