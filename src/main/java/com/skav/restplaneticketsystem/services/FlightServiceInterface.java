package com.skav.restplaneticketsystem.services;

import com.skav.restplaneticketsystem.models.FlightEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface FlightServiceInterface {
    ResponseEntity<List<FlightEntity>> getAllFlights();
    ResponseEntity<List<FlightEntity>> getFlightsByAirline(Long airlineId);
    ResponseEntity<Optional<FlightEntity>> getFlightById(Long id);
    ResponseEntity<FlightEntity> createFlight(FlightEntity flight);
    ResponseEntity<FlightEntity> updateFlight(Long id, Map<String, Object> updates);


}
