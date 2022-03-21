package com.centradatabase.consumerapp.service;

import com.centradatabase.consumerapp.model.Container;
import com.centradatabase.consumerapp.model.Person;
import com.centradatabase.consumerapp.repository.ContainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContainerService {

    @Autowired
    ContainerRepository repository;


    public void createPatient(List<Container> containerList) {
        List<Container> s = repository.saveAll(containerList);
        System.out.println("Collection Saved");

    }


}
