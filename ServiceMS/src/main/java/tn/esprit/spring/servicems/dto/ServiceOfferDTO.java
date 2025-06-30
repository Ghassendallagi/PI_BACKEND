package tn.esprit.spring.servicems.dto;

import lombok.Data;

@Data
public class ServiceOfferDTO {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private Integer duration;
    private Long clientId;
}