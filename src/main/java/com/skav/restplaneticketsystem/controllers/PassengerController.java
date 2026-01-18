package com.skav.restplaneticketsystem.controllers;

import com.skav.restplaneticketsystem.models.PassengerEntity;
import com.skav.restplaneticketsystem.models.TicketEntity;
import com.skav.restplaneticketsystem.services.BookingService;
import com.skav.restplaneticketsystem.services.BookingServiceInterface;
import com.skav.restplaneticketsystem.services.PassengerService;
import com.skav.restplaneticketsystem.services.PassengerServiceInterface;
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
@RequestMapping("/api/passengers")
@RequiredArgsConstructor
public class PassengerController {

    private final PassengerServiceInterface passengerService;
    private final BookingServiceInterface bookingService;
    private final Logger logger = LogManager.getLogger(PassengerController.class);

    @GetMapping
    public ResponseEntity<List<PassengerEntity>> getAllPassengers() {
        try {
            logger.info("Getting all passengers");
            return passengerService.getAllPassengers();
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<PassengerEntity>> getPassengerById(@PathVariable Long id) {
        try {
            logger.info("Getting passenger by id: " + id);
            return passengerService.getPassengerById(id);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}/tickets")
    public ResponseEntity<List<TicketEntity>> getPassengerTickets(@PathVariable Long id) {
        try {
            logger.info("Getting passenger tickets by id: " + id);
            return bookingService.getPassengerHistory(id);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/create")
    public ResponseEntity<PassengerEntity> createPassenger(@RequestBody PassengerEntity passenger) {
        try {
            logger.info("Creating new passenger: " + passenger);
            return passengerService.savePassenger(passenger);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}