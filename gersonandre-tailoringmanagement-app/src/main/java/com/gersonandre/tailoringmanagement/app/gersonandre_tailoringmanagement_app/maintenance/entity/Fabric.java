package com.gersonandre.tailoringmanagement.app.gersonandre_tailoringmanagement_app.maintenance.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "fabric")
public class Fabric {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String description;
    Double quantity;
    //TODO: Add a field for the provider
}
