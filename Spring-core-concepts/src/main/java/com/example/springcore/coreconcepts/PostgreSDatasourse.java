package com.example.springcore.coreconcepts;

import org.springframework.stereotype.Component;

@Component("postgres")
public class PostgreSDatasourse implements DataSourse{
    @Override
    public String[] getEmail(){
        String[] email = {"email4.com", "email5.com", "email6.com"};
        return email;
    }
}
