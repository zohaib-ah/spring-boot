package com.example.springcore;

import org.springframework.stereotype.Component;

@Component("truck")
public class Truck implements Vehicle {
    @Override
    public void move(){
        System.out.println("truck is moving ...");
    }
}
