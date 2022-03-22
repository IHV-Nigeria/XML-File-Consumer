package com.centradatabase.consumerapp.controller;

import com.centradatabase.consumerapp.model.Container;
import com.centradatabase.consumerapp.service.ContainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContainerController {

    @Autowired
    ContainerService containerService;

    @PostMapping("/createdocument")
    public ResponseEntity createDocument(@RequestBody Container container) {
        try {
            return new ResponseEntity<Container>(container, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getStackTrace(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
