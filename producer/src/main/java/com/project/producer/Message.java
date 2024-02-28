package com.project.producer;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
@AllArgsConstructor

public class Message {

    Producer producer;

    @Bean
    public String messagesToSend() {

        Scanner scanner = new Scanner(System.in);

        String text = "";

        while (!text.equalsIgnoreCase("Y")){
            System.out.println("Send message: ");
            text = scanner.nextLine();
            if(!text.equalsIgnoreCase("Y")){
                producer.sendTo(text);
            }
//


        }

        scanner.close();
        return "Success";


    }


}
