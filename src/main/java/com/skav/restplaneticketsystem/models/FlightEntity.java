package com.skav.restplaneticketsystem.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "flights")
@Getter
@Setter
public class FlightEntity extends BaseEntity {
    @Id
    private Long id;
    private String flightNumber;
    private String origin;      // Miejsce wylotu [cite: 23]
    private String destination; // Miejsce przylotu [cite: 23]
    private LocalDateTime departureTime;
    private BigDecimal price;
    private int availableSeats;

    @ManyToOne
    @JoinColumn(name = "airline_id")
    @JsonBackReference
    private AirlineEntity airline;

    // Metoda biznesowa (Enkapsulacja logiki zmiany stanu)
    public void decreaseSeats() {
        if (this.availableSeats > 0) {
            this.availableSeats--;
        }
    }

    public void bookSeat() {
        if (this.availableSeats <= 0) {
            throw new IllegalStateException("Brak wolnych miejsc w locie: " + this.flightNumber);
        }
        this.availableSeats--;
    }

}