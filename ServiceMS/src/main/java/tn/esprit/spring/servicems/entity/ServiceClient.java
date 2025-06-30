package tn.esprit.spring.servicems.entity;

import lombok.Data;

@Data
public class ServiceClient {
    private Long id;
    private String firstName;
    private String lastName;
    private Integer age;
}