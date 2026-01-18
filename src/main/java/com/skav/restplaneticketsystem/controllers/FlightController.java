package com.skav.restplaneticketsystem.controllers;

import com.skav.restplaneticketsystem.models.FlightEntity;
import com.skav.restplaneticketsystem.services.FlightServiceInterface;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/flights")
@RequiredArgsConstructor
public class FlightController {

    private final FlightServiceInterface flightService;
    private final Logger logger = LogManager.getLogger(FlightController.class);

    @GetMapping
    public ResponseEntity<List<FlightEntity>> findAll() {
        try {
            logger.info("Getting all flights");
            return flightService.getAllFlights();
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<FlightEntity>> getFlightById(@PathVariable Long id) {
        try {
            logger.info("Getting flight by id: " + id);
            return flightService.getFlightById(id);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/create")
    public ResponseEntity<FlightEntity> addFlight(@RequestBody FlightEntity flight) {
        try {
            logger.info("Adding flight: " + flight);
            return flightService.createFlight(flight);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<FlightEntity> patchFlight(@PathVariable Long id, @RequestBody Map<String, Object> updates) {
        try {
            logger.info("Updating flight: " + id);
            return flightService.updateFlight(id, updates);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}