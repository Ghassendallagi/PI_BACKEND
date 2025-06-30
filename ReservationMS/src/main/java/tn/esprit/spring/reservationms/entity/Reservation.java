package tn.esprit.spring.reservationms.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "reservations")
@Data
public class Reservation {
    @Id
    private String id;
    private Long serviceOfferId;
    private Long clientId;
    private LocalDateTime reservationDate;
    private Integer numberOfPersons;
    private String status;
}