package com.skav.restplaneticketsystem.services;

import com.skav.restplaneticketsystem.models.AirlineEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface AirlineServiceInterface {
    ResponseEntity<List<AirlineEntity>> getAllAirlines();
    ResponseEntity<AirlineEntity> getAirlineById(Long id);
    AirlineEntity createAirline(AirlineEntity airline);
    ResponseEntity<String> updateAirlinePatch(Long id, Map<String, Object> updates);


}
