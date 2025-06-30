package tn.esprit.spring.reservationms.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import tn.esprit.spring.reservationms.entity.Reservation;

import java.util.List;
import java.util.Optional;

public interface ReservationRepository extends MongoRepository<Reservation, String> {
    List<Reservation> findByClientId(Long clientId);
    List<Reservation> findByServiceOfferId(Long serviceOfferId);
    Optional<Reservation> findByClientIdAndServiceOfferId(Long clientId, Long serviceOfferId);
}