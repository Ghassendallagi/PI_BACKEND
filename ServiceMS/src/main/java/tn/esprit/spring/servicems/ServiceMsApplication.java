package tn.esprit.spring.servicems;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// Retirez @EnableFeignClients temporairement
public class ServiceMsApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceMsApplication.class, args);
    }
}