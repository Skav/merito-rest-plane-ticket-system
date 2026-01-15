package com.skav.restplaneticketsystem.services;

import com.skav.restplaneticketsystem.models.AirlineEntity;
import com.skav.restplaneticketsystem.models.FlightEntity;
import com.skav.restplaneticketsystem.models.PassengerEntity;
import com.skav.restplaneticketsystem.models.TicketEntity;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface BookingServiceInterface {
    List<AirlineEntity> getAllAirlines();
    List<PassengerEntity> getAllPassengers();
    List<FlightEntity> getAllFlights();
    List<TicketEntity> getAllTickets();
    Optional<FlightEntity> getFlightById(Long id);
    Optional<AirlineEntity> getAirlineById(Long id);
    Optional<PassengerEntity> getPassengerById(Long id);
    Optional<TicketEntity> getTicketById(Long id);
    List<FlightEntity> getFlightsByAirline(Long airlineId);

    FlightEntity createFlight(FlightEntity flight);
    FlightEntity updateFlight(Long id, Map<String, Object> updates);

    AirlineEntity createAirline(AirlineEntity airline);
    AirlineEntity updateAirlinePatch(Long id, Map<String, Object> updates);


    TicketEntity buyTicket(Long flightId, Long passengerId);

    List<TicketEntity> getPassengerHistory(Long passengerId);

    PassengerEntity savePassenger(PassengerEntity passenger);
}
