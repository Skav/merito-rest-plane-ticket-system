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
import java.time.LocalDateTime;
import java.util.List;

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
    public List<FlightEntity> getFlightsByAirline(Long airlineId) {
        // Metoda zdefiniowana w Twoim FlightRepository
        return flightRepository.findByAirlineId(airlineId);
    }

    @Override
    @Transactional
    public TicketEntity buyTicket(Long flightId, Long passengerId) {
        FlightEntity flight = flightRepository.findById(flightId)
                .orElseThrow(() -> new RuntimeException("Nie znaleziono lotu o ID: " + flightId));

        PassengerEntity passenger = passengerRepository.findById(passengerId)
                .orElseThrow(() -> new RuntimeException("Nie znaleziono pasażera o ID: " + passengerId));

        // Wywołanie logiki hermetyzacji z encji Flight (zmniejszenie liczby miejsc)
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
}
