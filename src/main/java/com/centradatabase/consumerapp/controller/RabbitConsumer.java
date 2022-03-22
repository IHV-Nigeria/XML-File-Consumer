package com.centradatabase.consumerapp.controller;

import com.centradatabase.consumerapp.model.Container;
import com.centradatabase.consumerapp.service.ContainerService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RabbitConsumer {
    @Autowired
    ContainerService containerService;


    @RabbitListener(queues = "Queue-1")
    public void getName(List<Container> containerList) {
        containerService.createPatient(containerList);
    }


}
