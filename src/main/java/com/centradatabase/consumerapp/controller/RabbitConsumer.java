package com.centradatabase.consumerapp.controller;

import com.centradatabase.consumerapp.model.Container;
import com.centradatabase.consumerapp.service.ContainerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class RabbitConsumer {
    private final ContainerService containerService;


    @RabbitListener(queues = "${consumer.queue}")
    public void consumer(List<Container> containerList) {
        log.info("CONSUMER 1 RUNNING  {}", containerList.size());
        containerService.createPatient(containerList);


    }

    @RabbitListener(queues = "${consumer.queue}")
    public void consumer2(List<Container> containerList) {
        log.info("CONSUMER 2 RUNNING  {}", containerList.size());
        containerService.createPatient(containerList);

    }

    @RabbitListener(queues = "${consumer.queue}")
    public void consumer3(List<Container> containerList) {
        log.info("CONSUMER 3 RUNNING  {}", containerList.size());
        containerService.createPatient(containerList);
    }

    @RabbitListener(queues = "${consumer.queue}")
    public void consumer4(List<Container> containerList) {
        log.info("CONSUMER 4 RUNNING  {}", containerList.size());
        containerService.createPatient(containerList);
    }


}
