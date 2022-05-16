package com.centradatabase.consumerapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan({"com.centradatabase.consumerapp","com.centradatabase.consumerapp.repository"})
public class ConsumerappApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerappApplication.class, args);
    }

}
