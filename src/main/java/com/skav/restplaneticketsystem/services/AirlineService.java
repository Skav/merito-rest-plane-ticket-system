package com.skav.restplaneticketsystem.services;

import com.skav.restplaneticketsystem.models.AirlineEntity;
import com.skav.restplaneticketsystem.repositories.AirlineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AirlineService implements AirlineServiceInterface {

    private final AirlineRepository airlineRepository;

    @Override
    public AirlineEntity createAirline(AirlineEntity airline) {
        return airlineRepository.save(airline);
    }

    @Override
    public ResponseEntity<String> updateAirlinePatch(Long id, Map<String, Object> updates) {
        Optional<AirlineEntity> airline = airlineRepository.findById(id);

        updates.forEach((key, value) -> {
            if ("name".equals(key)) {
                airline.get().setName((String) value);
            }
        });

        return ResponseEntity.ok(airline.toString());
    }

    @Override
    public ResponseEntity<List<AirlineEntity>> getAllAirlines() {
        return ResponseEntity.ok(airlineRepository.findAll());
    }

    @Override
    public ResponseEntity<AirlineEntity> getAirlineById(Long id) {
        return airlineRepository.findById(id)
                .map(airline -> {
                    return ResponseEntity.ok(airline);
                })
                .orElseGet(() -> {
                    return ResponseEntity.notFound().build();
                });
    }
}
