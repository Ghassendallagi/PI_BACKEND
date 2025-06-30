package tn.esprit.spring.reservationms.service;

import tn.esprit.spring.reservationms.entity.Reservation;

import java.util.List;

public interface IReservationService {
    Reservation createReservation(Reservation reservation);

    List<Reservation> getAllReservations();

    Reservation getReservationById(String id);

    Reservation updateReservation(String id, Reservation updated);

    void deleteReservation(String id);
    Reservation cancelReservation(String id);
    Reservation validateReservation(String id);
    List<Reservation> getReservationsByClientId(Long clientId);

    List<Reservation> getReservationsByServiceOfferId(Long serviceOfferId);
}