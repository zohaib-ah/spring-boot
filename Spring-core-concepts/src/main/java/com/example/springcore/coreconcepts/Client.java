package com.example.springcore.coreconcepts;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Client {
    public static void main(String[] args){

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Appconfig.class);

        EmailSender emailSender = applicationContext.getBean(EmailSender.class);
        emailSender.sendEmail();
    }
}
