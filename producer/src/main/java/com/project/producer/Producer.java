package com.project.producer;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;


@Component
@Slf4j
@AllArgsConstructor
public class Producer {

    ActiveMQQueue queue;


    private JmsTemplate jmsTemplate;
    public void sendTo(String message) {
        jmsTemplate.convertAndSend(queue, message);
        log.info(message);
        log.info("Producer> Message Sent");
    }
}

