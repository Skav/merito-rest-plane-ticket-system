package com.skav.restplaneticketsystem.services;

import com.skav.restplaneticketsystem.models.TicketEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface BookingServiceInterface {
    ResponseEntity<List<TicketEntity>> getAllTickets();
    ResponseEntity<Optional<TicketEntity>> getTicketById(Long id);
    ResponseEntity<TicketEntity> buyTicket(Long flightId, Long passengerId);
    ResponseEntity<List<TicketEntity>> getPassengerHistory(Long passengerId);

}
