package com.skav.restplaneticketsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.skav.restplaneticketsystem.repositories")
@EntityScan(basePackages = "com.skav.restplaneticketsystem.models")
public class RestPlaneTicketSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestPlaneTicketSystemApplication.class, args);
    }

}
