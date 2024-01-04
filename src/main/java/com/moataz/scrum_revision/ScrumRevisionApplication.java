package com.moataz.scrum_revision;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ScrumRevisionApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScrumRevisionApplication.class, args);
    }

}
