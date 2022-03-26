package com.centradatabase.consumerapp.service;

import com.centradatabase.consumerapp.model.Container;
import com.centradatabase.consumerapp.model.Tracker;
import com.centradatabase.consumerapp.repository.ContainerRepository;
import com.centradatabase.consumerapp.repository.MongoRepo;
import com.centradatabase.consumerapp.repository.TrackerRepository;
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
    TrackerRepository trackRepository;

    @Autowired
    MongoRepo mongoRepo;

    public void createPatient(List<Container> containerList) {
        if(!containerList.isEmpty()) {
            List<Container> containers = new ArrayList<>();
            Tracker tracker = new Tracker();
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
                if (!containers.get(0).getMessageHeader().getFacilityDatimCode().isEmpty()){
                    tracker.setDatimCode(containers.get(0).getMessageHeader().getFacilityDatimCode());
                    tracker.setLastUploadDate(convertDate(new Date()));
                    trackRepository.save(tracker);
                }
                containerRepository.saveAll(containers);
                containers.clear();
                System.out.println("Collection Saved");
            }

        }
    }

    public String convertDate(Date date){

        Instant instant = date.toInstant();
        ZonedDateTime zdt = instant.atZone(ZoneId.systemDefault());
        LocalDate localDate = zdt.toLocalDate();

        return localDate.toString();
    }


}
