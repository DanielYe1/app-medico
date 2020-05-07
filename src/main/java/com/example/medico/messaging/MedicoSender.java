package com.example.medico.messaging;

import com.example.medico.model.Medico;
import com.example.medico.model.MedicoWrapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MedicoSender {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private Queue queue;

    public void send(MedicoWrapper order) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            rabbitTemplate.convertAndSend(this.queue.getName(), objectMapper.writeValueAsString(order));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
