package com.liquorstore.client.event.listener;

import com.liquorstore.client.entity.User;
import com.liquorstore.client.event.RegistrationCompleteEvent;
import com.liquorstore.client.service.UserService;
import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;

import java.util.UUID;

@Slf4j
public class RegistrationCompleteEventListener implements ApplicationListener<RegistrationCompleteEvent> {

    @Autowired
    private UserService userService;

    @Override
    public void onApplicationEvent(RegistrationCompleteEvent event) {
        // Create the verification token for the user
        User user = event.getUser();
        String token = UUID.randomUUID().toString();

        userService.saveVerificationTokenForUser(token, user);
        //Send mail to user
        String url = event.getApplicationUrl() + "verifyRegistration?token=" + token;
        // pending: send verification email
        log.info("Click the link to verify your account: " + url);
    }
}
