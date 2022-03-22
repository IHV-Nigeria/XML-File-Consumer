package com.centradatabase.consumerapp.service;

import com.centradatabase.consumerapp.model.Container;
import com.centradatabase.consumerapp.model.Person;
import com.centradatabase.consumerapp.repository.ContainerRepository;
import com.centradatabase.consumerapp.repository.MongoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ContainerService {

    @Autowired
    ContainerRepository repository;

    @Autowired
    MongoRepo mongoRepo;


    public void createPatient(List<Container> containerList) {
        List<Container> containers = new ArrayList<>();
        Boolean flag = null;
        for(Container container : containerList){
            Container mongoContainer = mongoRepo.findById(container.getMessageData().getDemographics().getPatientUuid()).get();
            if(mongoContainer != null) {
                Date mongoTouchTime = mongoContainer.getMessageHeader().getTouchTime();
                Date countainerTouchTime = container.getMessageHeader().getTouchTime();
                if(mongoTouchTime != null && countainerTouchTime!= null) {
                    flag = mongoTouchTime.before(countainerTouchTime);
                    if (flag) {
                        containers.add(container);
                    }
                }
            }
            else{
                containers.add(container);
            }
        }
        List<Container> s = repository.saveAll(containers);
        System.out.println("Collection Saved");

    }


}
