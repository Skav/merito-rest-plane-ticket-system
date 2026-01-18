package com.skav.restplaneticketsystem.controllers;

import com.skav.restplaneticketsystem.models.TicketEntity;
import com.skav.restplaneticketsystem.services.BookingServiceInterface;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/bookings")
@RequiredArgsConstructor
public class BookingController {

    private final Logger logger = LogManager.getLogger(BookingController.class);
    private final BookingServiceInterface bookingService;

    // POST /api/bookings/buy?flightId=X&passengerId=Y
    @PostMapping("/buy")
    public ResponseEntity<?> buyTicket(@RequestParam Long flightId, @RequestParam Long passengerId) {
        try {
            logger.info("Buying ticker...");
            TicketEntity ticket = bookingService.buyTicket(flightId, passengerId).getBody();
            logger.info("Ticket bought: " + ticket);
            return ResponseEntity.ok(ticket);
        } catch (IllegalStateException e) {
            logger.error("There was an error trying to buy ticket.", e);
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            logger.error("There was an error trying to buy ticket.", e);
            return ResponseEntity.internalServerError().body("Wystąpił błąd: " + e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<TicketEntity>> getAllTickets() {
        try {
            logger.info("Getting all tickets...");
            return bookingService.getAllTickets();
        } catch (Exception e) {
            logger.error("There was an error trying to get tickets.", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<TicketEntity>> getTicketById(@PathVariable Long id) {
        try {
            logger.info("Getting ticket by id: " + id);
            return bookingService.getTicketById(id);
        } catch (Exception e) {
            logger.error("There was an error trying to get ticket by id.", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}