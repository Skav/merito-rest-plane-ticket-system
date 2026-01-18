package com.skav.restplaneticketsystem.controllers;

import com.skav.restplaneticketsystem.models.AirlineEntity;
import com.skav.restplaneticketsystem.models.FlightEntity;
import com.skav.restplaneticketsystem.services.AirlineService;
import com.skav.restplaneticketsystem.services.AirlineServiceInterface;
import com.skav.restplaneticketsystem.services.FlightService;
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

@RestController
@RequestMapping("/api/airlines")
@RequiredArgsConstructor
public class AirlineController {

    private final Logger logger = LogManager.getLogger(AirlineController.class);
    private final AirlineServiceInterface airlineService;
    private final FlightServiceInterface flightService;

    @GetMapping
    public ResponseEntity<List<AirlineEntity>> getAllAirlines() {
        try {
            logger.info("Getting airlines...");
            return airlineService.getAllAirlines();
        } catch (Exception e) {
            logger.error("There was an error while getting airlines: ", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<AirlineEntity> getAirlineById(@PathVariable Long id) {
        try {
            logger.info("Getting airline by id {}", id);
            return airlineService.getAirlineById(id);
        }  catch (Exception e) {
            logger.error("There was an error while getting airline: ", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}/flights")
    public ResponseEntity<List<FlightEntity>> getFlightsByAirline(@PathVariable Long id) {
        try {
            logger.info("Getting flights by airline {}", id);
            return flightService.getFlightsByAirline(id);
        }  catch (Exception e) {
            logger.error("There was an error while getting flights: ", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/create")
    public ResponseEntity<String> addAirline(@RequestBody AirlineEntity airline) {
        try {
            logger.info("Adding airline {}", airline);
            airlineService.createAirline(airline);

            return ResponseEntity.ok("Created");
        }  catch (Exception e) {
            logger.error("There was an error while adding airline: ", e.getMessage());
            return ResponseEntity.internalServerError().body("Wystąpił błąd: " + e.getMessage());
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<String> patchAirline(@PathVariable Long id, @RequestBody Map<String, Object> updates) {
        try {
            logger.info("Updating airline {}", id);
            return airlineService.updateAirlinePatch(id, updates);
        } catch (Exception e) {
            logger.error("There was an error while updating airline: ", e.getMessage());
            return ResponseEntity.internalServerError().body("Wystąpił błąd: " + e.getMessage());
        }

    }


}