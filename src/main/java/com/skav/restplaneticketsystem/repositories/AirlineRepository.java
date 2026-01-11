package com.skav.restplaneticketsystem.repositories;

import com.skav.restplaneticketsystem.models.AirlineEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirlineRepository extends JpaRepository<AirlineEntity, Long> {
}