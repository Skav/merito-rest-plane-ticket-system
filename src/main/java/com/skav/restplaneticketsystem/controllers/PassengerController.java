package com.skav.restplaneticketsystem.controllers;

import com.skav.restplaneticketsystem.models.PassengerEntity;
import com.skav.restplaneticketsystem.models.TicketEntity;
import com.skav.restplaneticketsystem.services.BookingServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/passengers")
@RequiredArgsConstructor
public class PassengerController {

    private final BookingServiceInterface bookingService;

    // Pobierz historię biletów pasażera
    @GetMapping("/{id}/tickets")
    public List<TicketEntity> getPassengerTickets(@PathVariable Long id) {
        return bookingService.getPassengerHistory(id);
    }

    // Opcjonalnie: Dodawanie pasażera, żeby mieć kogoś w bazie
    @PostMapping
    public PassengerEntity createPassenger(@RequestBody PassengerEntity passenger) {
        return bookingService.savePassenger(passenger);
    }
}