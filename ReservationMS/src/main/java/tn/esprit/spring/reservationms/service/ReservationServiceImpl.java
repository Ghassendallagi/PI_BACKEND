package tn.esprit.spring.reservationms.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import tn.esprit.spring.reservationms.entity.Reservation;
import tn.esprit.spring.reservationms.repository.ReservationRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements IReservationService {

    private final ReservationRepository repository;
    @Override
    public Reservation createReservation(Reservation reservation) {
        Optional<Reservation> existing = repository.findByClientIdAndServiceOfferId(
                reservation.getClientId(),
                reservation.getServiceOfferId()
        );

        if (existing.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Ce client a déjà réservé ce service.");
        }

        reservation.setStatus("en cours");
        reservation.setReservationDate(LocalDateTime.now());
        return repository.save(reservation);
    }

    @Override
    public List<Reservation> getAllReservations() {
        return repository.findAll();
    }

    @Override
    public Reservation getReservationById(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Reservation updateReservation(String id, Reservation updated) {
        Reservation existing = repository.findById(id).orElseThrow(() -> new RuntimeException("Reservation not found"));
        existing.setServiceOfferId(updated.getServiceOfferId());
        existing.setClientId(updated.getClientId());
        existing.setReservationDate(updated.getReservationDate());
        existing.setStatus(updated.getStatus());
        return repository.save(existing);
    }

    @Override
    public void deleteReservation(String id) {
        repository.deleteById(id);
    }

    @Override
    public List<Reservation> getReservationsByClientId(Long clientId) {
        return repository.findByClientId(clientId);
    }

    @Override
    public List<Reservation> getReservationsByServiceOfferId(Long serviceOfferId) {
        return repository.findByServiceOfferId(serviceOfferId);
    }

    public Reservation cancelReservation(String id) {
        Reservation reservation = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Réservation non trouvée"));

        if (!"en cours".equals(reservation.getStatus())) {
            throw new RuntimeException("Seules les réservations en cours peuvent être annulées");
        }

        reservation.setStatus("Annulé");
        return repository.save(reservation);
    }

    public Reservation validateReservation(String id) {
        Reservation reservation = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Réservation non trouvée"));

        reservation.setStatus("Validé");
        return repository.save(reservation);
    }

}