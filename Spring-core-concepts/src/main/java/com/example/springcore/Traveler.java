package com.example.springcore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Traveler {

    private Vehicle vehicle;

    @Autowired
    public Traveler(@Qualifier("bike") Vehicle vehicle){
        this.vehicle = vehicle;
    }

    public void Startjur(){
        this.vehicle.move();
    }

}
