package com.lalbr.core.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Service
public class MailSenderService {

    Logger logger = LoggerFactory.getLogger(MailSenderService.class);

    @Value("${spring.mail.username}")
    private String username;
    @Value("${spring.mail.password}")
    private String password;
    @Value("${spring.mail.target}")
    private String targetMail;
    @Value("${spring.mail.host}")
    private String host;
    @Value("${spring.mail.port}")
    private int port;

    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(host);
        mailSender.setPort(port);
        mailSender.setUsername(username);
        mailSender.setPassword(password);
        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");
        return mailSender;
    }


    public void sendMailMessage(String subject, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        JavaMailSender mailSender = this.getJavaMailSender();
        message.setFrom(username);
        message.setTo(targetMail);
        message.setSubject(subject);
        message.setText(content);
        logger.info("########## sendMailMessage() to {} ##########",targetMail);
        mailSender.send(message);
    }

}
