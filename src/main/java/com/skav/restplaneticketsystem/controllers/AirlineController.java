package com.skav.restplaneticketsystem.controllers;

import com.skav.restplaneticketsystem.models.AirlineEntity;
import com.skav.restplaneticketsystem.models.FlightEntity;
import com.skav.restplaneticketsystem.services.BookingServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/airlines")
@RequiredArgsConstructor
public class AirlineController {

    private final BookingServiceInterface bookingService;

    @GetMapping
    public List<AirlineEntity> getAllAirlines() {
        return bookingService.getAllAirlines();
    }

    @GetMapping("/{id}")
    public Optional<AirlineEntity> getAirlineById(@PathVariable Long id) {
        return bookingService.getAirlineById(id);
    }

    @GetMapping("/{id}/flights")
    public List<FlightEntity> getFlightsByAirline(@PathVariable Long id) {
        return bookingService.getFlightsByAirline(id);
    }

    @PostMapping("/create")
    public AirlineEntity addAirline(@RequestBody AirlineEntity airline) {
        return bookingService.createAirline(airline);
    }

    @PatchMapping("/{id}")
    public AirlineEntity patchAirline(@PathVariable Long id, @RequestBody Map<String, Object> updates) {
        return bookingService.updateAirlinePatch(id, updates);
    }


}