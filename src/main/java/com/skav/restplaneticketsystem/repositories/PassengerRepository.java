package com.skav.restplaneticketsystem.repositories;

import com.skav.restplaneticketsystem.models.PassengerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengerRepository extends JpaRepository<PassengerEntity, Long> {
}