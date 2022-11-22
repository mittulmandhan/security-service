package com.liquorstore.client.event.listener;

import com.liquorstore.client.entity.User;
import com.liquorstore.client.event.RegistrationCompleteEvent;
import com.liquorstore.client.service.MailSenderService;
import com.liquorstore.client.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Slf4j
public class RegistrationCompleteEventListener implements ApplicationListener<RegistrationCompleteEvent> {

    @Autowired
    private UserService userService;

    @Autowired
    private MailSenderService mailSenderService;

    @Override
    public void onApplicationEvent(RegistrationCompleteEvent event) {
        // Create the verification token for the user
        User user = event.getUser();
        String token = UUID.randomUUID().toString();

        userService.saveVerificationTokenForUser(token, user);
        //Send mail to user
        String url = event.getApplicationUrl() + "/verifyRegistration?token=" + token;
        // pending: send verification email
//        log.info("Click the link to verify your account: " + url);

        mailSenderService.send(user.getEmail(), "Email Verification", "Click the link to verify your account: " + url);
     }
}
