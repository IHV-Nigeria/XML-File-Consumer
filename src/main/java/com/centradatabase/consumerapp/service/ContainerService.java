package com.centradatabase.consumerapp.service;

import com.centradatabase.consumerapp.model.Container;
import com.centradatabase.consumerapp.model.FileUpload;

import com.centradatabase.consumerapp.repository.ContainerRepository;

import com.centradatabase.consumerapp.repository.FileUploadRepository;
import com.centradatabase.consumerapp.repository.MongoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ContainerService {

    @Autowired
    ContainerRepository containerRepository;


    @Autowired
    MongoRepo mongoRepo;

    @Autowired
    FileUploadRepository fileUploadRepository;

//

    private final String VALIDATINGSTATUS = "VALIDATING";
    private final String CONSUMESTATUS = "CONSUMED";

    public void createPatient(List<Container> containerList) {
        if(!containerList.isEmpty()) {
            List<Container> containers = new ArrayList<>();

            Boolean flag = null;
            for (Container container : containerList) {
                Container mongoContainer = mongoRepo.findById(container.getMessageData().getDemographics().getPatientUuid()).orElse(null);
                if (mongoContainer != null) {
                    Date mongoTouchTime = mongoContainer.getMessageHeader().getTouchTime();
                    Date countainerTouchTime = container.getMessageHeader().getTouchTime();
                    if (mongoTouchTime != null && countainerTouchTime != null) {
                        flag = mongoTouchTime.before(countainerTouchTime);
                        if (flag) {
                            containers.add(container);
                            System.out.println("Patient Existing");
                        }
                    }
                } else {
                    containers.add(container);
                    System.out.println("Patient NOt Existing");
                }
            }
            if (containers.size() > 0){
                containerRepository.saveAll(containers);
                updateFileUpload(containers,CONSUMESTATUS);
                containers.clear();
                System.out.println("Collection Saved");
            }

        }
    }

    private  void updateFileUpload(List<Container> currFileList, String status){
        List<FileUpload> fileUploadList = new ArrayList<>();
        if(currFileList.size() > 0) {
            for(Container container : currFileList) {
                try {
                    FileUpload fileUpload = fileUploadRepository.findFileUploadByFileName(container.getMessageHeader().getFileName());
                    fileUpload.setConsumerDate(new Date());
                    fileUpload.setStatus(status);
                    fileUploadList.add(fileUpload);
                    //fileUploadService.updateFileUpload(fileUpload);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            if(fileUploadList.size() > 0){
                fileUploadRepository.saveAll(fileUploadList);
                System.out.println("Upload Record saved");
            }



        }

    }


}
