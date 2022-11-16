package com.liquorstore.client.service;

import com.liquorstore.client.entity.User;
import com.liquorstore.client.entity.VerificationToken;
import com.liquorstore.client.model.UserModel;

public interface UserService {
    User registerUser(UserModel userModel);

    void saveVerificationTokenForUser(String token, User user);

    String validateVerificationToken(String token);

    VerificationToken getVerificationToken(String oldToken);

    void deleteVerificationToken(VerificationToken verificationToken);
}
