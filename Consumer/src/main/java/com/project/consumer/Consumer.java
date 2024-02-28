package com.project.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;


@Component
@Slf4j
public class Consumer {


    @JmsListener(destination = "${activemq.destination}", containerFactory = "jmsFactory")
    public void processToDo(String message) {
        log.info("Consumer> " + message);
    }
}