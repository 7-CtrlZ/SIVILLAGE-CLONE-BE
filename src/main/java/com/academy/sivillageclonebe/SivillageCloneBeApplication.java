package com.academy.sivillageclonebe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SivillageCloneBeApplication {

    public static void main(String[] args) {
        SpringApplication.run(SivillageCloneBeApplication.class, args);
    }

}
