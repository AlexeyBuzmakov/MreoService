package com.example.clientinsurance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
public class ClientinsuranceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientinsuranceApplication.class, args);
    }

}
