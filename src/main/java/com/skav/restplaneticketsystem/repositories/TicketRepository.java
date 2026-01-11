package com.skav.restplaneticketsystem.repositories;

import com.skav.restplaneticketsystem.models.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<TicketEntity, Long> {

    // Pobiera wszystkie bilety powiązane z ID pasażera
    List<TicketEntity> findByPassengerId(Long passengerId);
}
