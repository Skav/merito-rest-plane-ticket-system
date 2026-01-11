package com.skav.restplaneticketsystem.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "airlines")
@Getter
@Setter
public class AirlineEntity extends BaseEntity { // Dziedziczenie
    @Id
    private Long id;
    private String name;

    // Relacja 1:N (Kompozycja - loty należą do linii)
    @OneToMany(mappedBy = "airline", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JsonManagedReference // Do obsługi JSON (żeby nie było pętli)
    private List<FlightEntity> flights = new ArrayList<>();
}
