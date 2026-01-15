package com.skav.restplaneticketsystem.controllers;

import com.skav.restplaneticketsystem.models.PassengerEntity;
import com.skav.restplaneticketsystem.models.TicketEntity;
import com.skav.restplaneticketsystem.services.BookingServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/passengers")
@RequiredArgsConstructor
public class PassengerController {

    private final BookingServiceInterface bookingService;

    @GetMapping
    public List<PassengerEntity> getAllPassengers() {
        return bookingService.getAllPassengers();
    }

    @GetMapping("/{id}")
    public Optional<PassengerEntity> getPassengerById(@PathVariable Long id) {
        return  bookingService.getPassengerById(id);
    }

    @GetMapping("/{id}/tickets")
    public List<TicketEntity> getPassengerTickets(@PathVariable Long id) {
        return bookingService.getPassengerHistory(id);
    }

    @PostMapping("/create")
    public PassengerEntity createPassenger(@RequestBody PassengerEntity passenger) {
        return bookingService.savePassenger(passenger);
    }
}