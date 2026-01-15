package com.skav.restplaneticketsystem.controllers;

import com.skav.restplaneticketsystem.models.TicketEntity;
import com.skav.restplaneticketsystem.services.BookingServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/bookings")
@RequiredArgsConstructor
public class BookingController {

    private final BookingServiceInterface bookingService;

    // POST /api/bookings/buy?flightId=X&passengerId=Y
    @PostMapping("/buy")
    public ResponseEntity<?> buyTicket(@RequestParam Long flightId, @RequestParam Long passengerId) {
        try {
            TicketEntity ticket = bookingService.buyTicket(flightId, passengerId);
            return ResponseEntity.ok(ticket);
        } catch (IllegalStateException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Wystąpił błąd: " + e.getMessage());
        }
    }

    @GetMapping
    public List<TicketEntity> getAllTickets() {
        return bookingService.getAllTickets();
    }

    @GetMapping("/{id}")
    public Optional<TicketEntity> getTicketById(@PathVariable Long id) {
        return bookingService.getTicketById(id);
    }
}