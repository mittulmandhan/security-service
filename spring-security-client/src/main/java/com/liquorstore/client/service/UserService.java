package com.liquorstore.client.service;

import com.liquorstore.client.entity.User;
import com.liquorstore.client.entity.VerificationToken;
import com.liquorstore.client.model.UserModel;

import java.util.Optional;

public interface UserService {
    User registerUser(UserModel userModel);

    void saveVerificationTokenForUser(String token, User user);

    String validateVerificationToken(String token);

    VerificationToken getVerificationToken(String oldToken);

    void deleteVerificationToken(VerificationToken verificationToken);

    User findUserByEmail(String email);

    void createPasswordResetTokenForUser(User user, String token);

    String validatePasswordResetToken(String token);

    Optional<User> getUserByPasswordResetToken(String token);

    void savePassword(User user, String newPassword);

    boolean isOldPasswordValid(User user, String oldPassword);
}
