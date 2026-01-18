package com.skav.restplaneticketsystem.services;

import com.skav.restplaneticketsystem.models.PassengerEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface PassengerServiceInterface {
    ResponseEntity<List<PassengerEntity>> getAllPassengers();
    ResponseEntity<Optional<PassengerEntity>> getPassengerById(Long id);
    ResponseEntity<PassengerEntity> savePassenger(PassengerEntity passenger);

}
