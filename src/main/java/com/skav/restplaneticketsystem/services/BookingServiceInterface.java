package com.skav.restplaneticketsystem.services;

import com.skav.restplaneticketsystem.models.AirlineEntity;
import com.skav.restplaneticketsystem.models.FlightEntity;
import com.skav.restplaneticketsystem.models.PassengerEntity;
import com.skav.restplaneticketsystem.models.TicketEntity;

import java.util.List;

public interface BookingServiceInterface {
    List<AirlineEntity> getAllAirlines();
    List<FlightEntity> getFlightsByAirline(Long airlineId);

    TicketEntity buyTicket(Long flightId, Long passengerId);

    List<TicketEntity> getPassengerHistory(Long passengerId);

    PassengerEntity savePassenger(PassengerEntity passenger);
}
