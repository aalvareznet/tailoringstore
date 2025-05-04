package com.gersonandre.tailoringmanagement.app.gersonandre_tailoringmanagement_app.maintenance.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "jacket")
public class Jacket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    //TODO: add a field for the fabric
    Double length;
    Double chest;
    Double waist;
    Double hip;
    Double back;
    Double shoulder;
    Double fit;
    Double lm;
    Double elbow;
    Double fist;
    Double vline;
    String specification;

}
