package com.skav.restplaneticketsystem.services;

import com.skav.restplaneticketsystem.models.AirlineEntity;
import com.skav.restplaneticketsystem.models.FlightEntity;
import com.skav.restplaneticketsystem.models.PassengerEntity;
import com.skav.restplaneticketsystem.models.TicketEntity;
import com.skav.restplaneticketsystem.repositories.AirlineRepository;
import com.skav.restplaneticketsystem.repositories.FlightRepository;
import com.skav.restplaneticketsystem.repositories.PassengerRepository;
import com.skav.restplaneticketsystem.repositories.TicketRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookingService implements BookingServiceInterface {

    private final AirlineRepository airlineRepository;
    private final FlightRepository flightRepository;
    private final PassengerRepository passengerRepository;
    private final TicketRepository ticketRepository;

    @Override
    public List<AirlineEntity> getAllAirlines() {
        return airlineRepository.findAll();
    }

    @Override
    public Optional<AirlineEntity> getAirlineById(Long id) {
        return airlineRepository.findById(id);
    }

    @Override
    public List<FlightEntity> getAllFlights() {
        return flightRepository.findAll();
    }

    @Override
    public Optional<FlightEntity> getFlightById(Long id) {
        return flightRepository.findById(id);
    }

    @Override
    public List<FlightEntity> getFlightsByAirline(Long airlineId) {
        return flightRepository.findByAirlineId(airlineId);
    }

    @Override
    public Optional<PassengerEntity> getPassengerById(Long id) {
        return passengerRepository.findById(id);
    }

    @Override
    public List<TicketEntity> getAllTickets() {
        return ticketRepository.findAll();
    }

    @Override
    public Optional<TicketEntity> getTicketById(Long id) {
        return ticketRepository.findById(id);
    }

    @Override
    @Transactional
    public TicketEntity buyTicket(Long flightId, Long passengerId) {
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

        return ticketRepository.save(ticket);
    }

    @Override
    public List<TicketEntity> getPassengerHistory(Long passengerId) {
        return ticketRepository.findByPassengerId(passengerId);
    }

    @Override
    public PassengerEntity savePassenger(PassengerEntity passenger) {
        return passengerRepository.save(passenger);
    }

    @Override
    public List<PassengerEntity> getAllPassengers() {
        return passengerRepository.findAll();
    }

    @Override
    public FlightEntity createFlight(FlightEntity flight) {
        return flightRepository.save(flight);
    }

    @Override
    public FlightEntity updateFlight(Long id, Map<String, Object> updates) {
        FlightEntity flight = flightRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Lot nie znaleziony"));

        updates.forEach((key, value) -> {
            switch (key) {
                case "price" -> flight.setPrice(BigDecimal.valueOf(((Number) value).doubleValue()));
                case "availableSeats" -> flight.setAvailableSeats((Integer) value);
                case "destination" -> flight.setDestination((String) value);
                case "origin" -> flight.setOrigin((String) value);
            }
        });

        return flightRepository.save(flight);
    }

    @Override
    public AirlineEntity createAirline(AirlineEntity airline) {
        return airlineRepository.save(airline);
    }

    @Override
    public AirlineEntity updateAirlinePatch(Long id, Map<String, Object> updates) {
        AirlineEntity airline = airlineRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Linia lotnicza o ID " + id + " nie istnieje"));

        updates.forEach((key, value) -> {
            if ("name".equals(key)) {
                airline.setName((String) value);
            }
        });

        return airlineRepository.save(airline);
    }
}
