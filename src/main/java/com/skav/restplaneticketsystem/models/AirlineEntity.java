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
public class AirlineEntity extends BaseEntity {
    @Id
    private Long id;
    private String name;

    @OneToMany(mappedBy = "airline", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<FlightEntity> flights = new ArrayList<>();
}
