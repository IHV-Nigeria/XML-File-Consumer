package com.centradatabase.consumerapp.service;

import com.centradatabase.consumerapp.model.Container;
import com.centradatabase.consumerapp.entities.FileUpload;

import com.centradatabase.consumerapp.repository.ContainerRepository;

import com.centradatabase.consumerapp.repository.FileUploadRepository;
import com.centradatabase.consumerapp.repository.MongoRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Slf4j
@Service
@RequiredArgsConstructor
public class ContainerService {
    private final ContainerRepository containerRepository;
    private final RabbitTemplate rabbitTemplate;
    private final MongoRepo mongoRepo;
    private final FileUploadRepository fileUploadRepository;

    @Value("${etl.queue}")
    private String etlQueue;
    public void createPatient(List<Container> containerList) {
        if(!containerList.isEmpty()) {
            List<Container> containers = new ArrayList<>();

            boolean flag;
            for (Container container : containerList) {
                Container mongoContainer = mongoRepo.findById(container.getMessageData().getDemographics().getPatientUuid()).orElse(null);
                if (mongoContainer != null) {
                    Date mongoTouchTime = mongoContainer.getMessageHeader().getTouchTime();
                    Date containerTouchTime = container.getMessageHeader().getTouchTime();
                    if (mongoTouchTime != null && containerTouchTime != null) {
                        flag = mongoTouchTime.before(containerTouchTime);
                        if (flag) {
                            containers.add(container);
                        } else
                            log.info("Patient already existing");
                    }
                } else {
                    containers.add(container);
                }
            }
            if (containers.size() > 0){
                containerRepository.saveAll(containers);
                rabbitTemplate.convertAndSend(etlQueue, containers);
                updateFileUpload(containers);
                containers.clear();
                log.info("Collection Saved");
            }

        }
    }

    private  void updateFileUpload(List<Container> currFileList){
        List<FileUpload> fileUploadList = new ArrayList<>();
        if(currFileList.size() > 0) {
            for(Container container : currFileList) {
                try {
                    FileUpload fileUpload = fileUploadRepository.findFileUploadByFileName(container.getMessageHeader().getFileName());
                    fileUpload.setConsumerDate(new Date());
                    fileUpload.setStatus("CONSUMED");
                    fileUploadList.add(fileUpload);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            if(fileUploadList.size() > 0){
                fileUploadRepository.saveAll(fileUploadList);
                log.info("Upload Record saved");
            }
        }
    }
}
