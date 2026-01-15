package com.skav.restplaneticketsystem.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "passengers")
@Getter
@Setter
public class PassengerEntity extends BaseEntity {
    @Id
    private Long id;
    private String firstName;
    private String lastName;
}
