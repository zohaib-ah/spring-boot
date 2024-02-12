package com.example.springcore.coreconcepts;

import org.springframework.stereotype.Component;

@Component("mysql")
public class MysqlDataspourse implements DataSourse {
    @Override
    public String[] getEmail(){

         String[] email = {"email1.com", "email2.com", "email3.com"};
         return  email;
    }

}
