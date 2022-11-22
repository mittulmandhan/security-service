package com.liquorstore.client.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public interface MailSenderService {

    public boolean send(String to, String subject, String body);

}
