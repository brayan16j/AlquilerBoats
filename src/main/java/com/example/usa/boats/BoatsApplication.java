package com.example.usa.boats;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages= "com.example.usa.boats")
@EntityScan("com.example.usa.boats.model")
@EnableJpaRepositories("com.example.usa.boats.repository")
public class BoatsApplication {

    public static void main(String[] args) {
        SpringApplication.run(BoatsApplication.class, args);
    }

}
