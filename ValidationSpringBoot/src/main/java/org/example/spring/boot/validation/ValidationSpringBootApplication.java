package org.example.spring.boot.validation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
        "org.example.spring.boot.validation",
        "org.example.common.spring.boot.response",
        "org.example.common.spring.boot.exceptions"
})
public class ValidationSpringBootApplication {
    public static void main(String[] args){
        SpringApplication.run(ValidationSpringBootApplication.class, args);
    }
}
