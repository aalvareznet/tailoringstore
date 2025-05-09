package com.gersonandre.tailoringmanagement.app.gersonandre_tailoringmanagement_app.maintenance.entity;

import com.gersonandre.tailoringmanagement.app.gersonandre_tailoringmanagement_app.config.app.AuditEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "pant")
@EntityListeners(AuditEntityListener.class)
public class Pant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne
    @JoinColumn(name = "fabric_id", nullable = false)
    Fabric fabric;
    @Column(nullable = false)
    Double length;
    @Column(nullable = false)
    Double crouch;
    @Column(nullable = false)
    Double waist;
    @Column(nullable = false)
    Double hip;
    @Column(nullable = false)
    Double knee;
    @Column(nullable = false)
    Double feet;
}
