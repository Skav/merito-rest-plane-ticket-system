package com.skav.restplaneticketsystem.services;

import com.skav.restplaneticketsystem.models.PassengerEntity;
import com.skav.restplaneticketsystem.repositories.PassengerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PassengerService implements PassengerServiceInterface {

    private final PassengerRepository passengerRepository;

    @Override
    public ResponseEntity<Optional<PassengerEntity>> getPassengerById(Long id) {
        return ResponseEntity.ok(passengerRepository.findById(id));
    }

    @Override
    public ResponseEntity<PassengerEntity> savePassenger(PassengerEntity passenger) {
        return ResponseEntity.ok(passengerRepository.save(passenger));
    }

    @Override
    public ResponseEntity<List<PassengerEntity>> getAllPassengers() {
        return ResponseEntity.ok(passengerRepository.findAll());
    }
}
