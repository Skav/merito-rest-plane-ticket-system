package com.skav.restplaneticketsystem.services;

import com.skav.restplaneticketsystem.models.FlightEntity;
import com.skav.restplaneticketsystem.models.PassengerEntity;
import com.skav.restplaneticketsystem.models.TicketEntity;
import com.skav.restplaneticketsystem.repositories.AirlineRepository;
import com.skav.restplaneticketsystem.repositories.FlightRepository;
import com.skav.restplaneticketsystem.repositories.PassengerRepository;
import com.skav.restplaneticketsystem.repositories.TicketRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookingService implements BookingServiceInterface {

    private final AirlineRepository airlineRepository;
    private final FlightRepository flightRepository;
    private final PassengerRepository passengerRepository;
    private final TicketRepository ticketRepository;

    @Override
    public ResponseEntity<List<TicketEntity>> getAllTickets() {
        return ResponseEntity.ok(ticketRepository.findAll());
    }

    @Override
    public ResponseEntity<Optional<TicketEntity>> getTicketById(Long id) {
        return ResponseEntity.ok(ticketRepository.findById(id));
    }

    @Override
    @Transactional
    public ResponseEntity<TicketEntity> buyTicket(Long flightId, Long passengerId) {
        FlightEntity flight = flightRepository.findById(flightId)
                .orElseThrow(() -> new RuntimeException("Nie znaleziono lotu o ID: " + flightId));

        PassengerEntity passenger = passengerRepository.findById(passengerId)
                .orElseThrow(() -> new RuntimeException("Nie znaleziono pasażera o ID: " + passengerId));

        flight.bookSeat();
        flightRepository.save(flight);

        TicketEntity ticket = new TicketEntity();
        ticket.setFlight(flight);
        ticket.setPassenger(passenger);
        ticket.setPurchaseDate(LocalDateTime.now());

        return ResponseEntity.ok(ticketRepository.save(ticket));
    }

    @Override
    public ResponseEntity<List<TicketEntity>> getPassengerHistory(Long passengerId) {
        return ResponseEntity.ok(ticketRepository.findByPassengerId(passengerId));
    }
}
