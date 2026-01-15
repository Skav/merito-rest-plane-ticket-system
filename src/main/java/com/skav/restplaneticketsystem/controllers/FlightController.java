package com.skav.restplaneticketsystem.controllers;

import com.skav.restplaneticketsystem.models.FlightEntity;
import com.skav.restplaneticketsystem.services.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/flights")
@RequiredArgsConstructor
public class FlightController {

    private final BookingService bookingService;

    @GetMapping
    public List<FlightEntity> findAll() {
        return bookingService.getAllFlights();
    }

    @GetMapping("/{id}")
    public Optional<FlightEntity> getFlightById(@PathVariable Long id) {
        return bookingService.getFlightById(id);
    }

    @PostMapping("/create")
    public FlightEntity addFlight(@RequestBody FlightEntity flight) {
        return bookingService.createFlight(flight);
    }

    @PatchMapping("/{id}")
    public FlightEntity patchFlight(@PathVariable Long id, @RequestBody Map<String, Object> updates) {
        return bookingService.updateFlight(id, updates);
    }
}