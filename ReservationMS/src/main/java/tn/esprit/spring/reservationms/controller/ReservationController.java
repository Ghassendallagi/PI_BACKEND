package tn.esprit.spring.reservationms.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.reservationms.entity.Reservation;
import tn.esprit.spring.reservationms.service.IReservationService;

import java.util.List;

@RestController
@RequestMapping("/api/reservations")
@RequiredArgsConstructor
public class ReservationController {

    private final IReservationService service;

    @PostMapping
    public Reservation create(@RequestBody Reservation reservation) {
        return service.createReservation(reservation);
    }

    @GetMapping
    public List<Reservation> getAll() {
        return service.getAllReservations();
    }

    @GetMapping("/{id}")
    public Reservation getById(@PathVariable String id) {
        return service.getReservationById(id);
    }

    @PutMapping("/{id}")
    public Reservation update(@PathVariable String id, @RequestBody Reservation reservation) {
        return service.updateReservation(id, reservation);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.deleteReservation(id);
    }

    @GetMapping("/client/{clientId}")
    public List<Reservation> getByClientId(@PathVariable Long clientId) {
        return service.getReservationsByClientId(clientId);
    }

    @GetMapping("/service/{serviceOfferId}")
    public List<Reservation> getByServiceOfferId(@PathVariable Long serviceOfferId) {
        return service.getReservationsByServiceOfferId(serviceOfferId);
    }
    @PutMapping("/{id}/cancel")
    public ResponseEntity<Reservation> cancelReservation(@PathVariable String id) {
        Reservation updated = service.cancelReservation(id);
        return ResponseEntity.ok(updated);
    }

    @PutMapping("/{id}/validate")
    public ResponseEntity<Reservation> validateReservation(@PathVariable String id) {
        Reservation updated = service.validateReservation(id);
        return ResponseEntity.ok(updated);
    }

}
