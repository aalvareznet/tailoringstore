package com.gersonandre.tailoringmanagement.app.gersonandre_tailoringmanagement_app.maintenance.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "vest")
public class Vest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Double length;
    Double chest;
    Double waist;
    Double hip;
    Double back;
    Double shoulder;
    Double bm;
    Double vline;
    String specification;
}
