package com.skav.restplaneticketsystem.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Table(name = "tickets")
@Getter
@Setter
public class TicketEntity extends BaseEntity {
    private LocalDateTime purchaseDate;

    @ManyToOne
    @JoinColumn(name = "passenger_id")
    private PassengerEntity passenger;

    @ManyToOne
    @JoinColumn(name = "flight_id")
    private FlightEntity flight;
}
