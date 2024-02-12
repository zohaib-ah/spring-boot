package com.example.springcore.coreconcepts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class EmailSender {

    private DataSourse dataSourse;

    @Autowired
    EmailSender(@Qualifier("mysql") DataSourse dataSourse){
        this.dataSourse = dataSourse;
    }

    public void sendEmail(){
        String[] emails = dataSourse.getEmail();
        for(String email : emails){
            System.out.println(email);
        }

    }
}
