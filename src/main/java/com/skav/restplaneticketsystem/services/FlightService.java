package com.skav.restplaneticketsystem.services;

import com.skav.restplaneticketsystem.models.FlightEntity;
import com.skav.restplaneticketsystem.repositories.FlightRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FlightService implements FlightServiceInterface{

    private final FlightRepository flightRepository;

    @Override
    public ResponseEntity<List<FlightEntity>> getAllFlights() {
        return ResponseEntity.ok(flightRepository.findAll());
    }

    @Override
    public ResponseEntity<Optional<FlightEntity>> getFlightById(Long id) {
        return ResponseEntity.ok(flightRepository.findById(id));
    }

    @Override
    public ResponseEntity<List<FlightEntity>> getFlightsByAirline(Long airlineId) {
        return ResponseEntity.ok(flightRepository.findByAirlineId(airlineId));
    }

    @Override
    public ResponseEntity<FlightEntity> createFlight(FlightEntity flight) {
        return ResponseEntity.ok(flightRepository.save(flight));
    }

    @Override
    public ResponseEntity<FlightEntity> updateFlight(Long id, Map<String, Object> updates) {
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

        return ResponseEntity.ok(flightRepository.save(flight));
    }

}
