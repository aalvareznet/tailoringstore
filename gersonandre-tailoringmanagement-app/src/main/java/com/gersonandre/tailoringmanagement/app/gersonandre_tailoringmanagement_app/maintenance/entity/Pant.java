package com.gersonandre.tailoringmanagement.app.gersonandre_tailoringmanagement_app.maintenance.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "pant")
public class Pant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Double length;
    Double crouch;
    Double waist;
    Double hip;
    Double knee;
    Double feet;
}
