package com.gersonandre.tailoringmanagement.app.gersonandre_tailoringmanagement_app.maintenance.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "jacket")
public class Jacket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne
    @JoinColumn(name = "fabric_id", nullable = false)
    Fabric fabric;
    @Column(nullable = false)
    Double length;
    @Column(nullable = false)
    Double chest;
    @Column(nullable = false)
    Double waist;
    @Column(nullable = false)
    Double hip;
    @Column(nullable = false)
    Double back;
    @Column(nullable = false)
    Double shoulder;
    @Column(nullable = false)
    Double fit;
    @Column(nullable = false)
    Double lm;
    @Column(nullable = false)
    Double elbow;
    @Column(nullable = false)
    Double fist;
    @Column(nullable = false)
    Double vline;
    @Column(nullable = false)
    String specification;

}
