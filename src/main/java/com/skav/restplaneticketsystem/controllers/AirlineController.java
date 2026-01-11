package com.skav.restplaneticketsystem.controllers;

import com.skav.restplaneticketsystem.models.AirlineEntity;
import com.skav.restplaneticketsystem.models.FlightEntity;
import com.skav.restplaneticketsystem.services.BookingServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/airlines")
@RequiredArgsConstructor
public class AirlineController {

    private final BookingServiceInterface bookingService;

    // Pobierz wszystkie linie
    @GetMapping
    public List<AirlineEntity> getAllAirlines() {
        return bookingService.getAllAirlines();
    }

    // Pobierz loty konkretnej linii
    @GetMapping("/{id}/flights")
    public List<FlightEntity> getFlightsByAirline(@PathVariable Long id) {
        return bookingService.getFlightsByAirline(id);
    }
}