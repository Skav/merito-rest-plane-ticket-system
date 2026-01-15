package com.skav.restplaneticketsystem.repositories;

import com.skav.restplaneticketsystem.models.FlightEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<FlightEntity, Long> {

    List<FlightEntity> findByAirlineId(Long airlineId);
}