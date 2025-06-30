package tn.esprit.spring.reservationms.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReservationDto {
    private Long id;
    private Long serviceOfferId;
    private Long clientId;
    private LocalDateTime reservationDate;
    private Integer numberOfPersons;
    private String status;
}
