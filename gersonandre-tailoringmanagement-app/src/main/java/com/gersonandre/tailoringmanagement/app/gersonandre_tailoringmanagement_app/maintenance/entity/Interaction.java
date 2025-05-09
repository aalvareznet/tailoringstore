package com.gersonandre.tailoringmanagement.app.gersonandre_tailoringmanagement_app.maintenance.entity;

import java.time.LocalDateTime;

import com.gersonandre.tailoringmanagement.app.gersonandre_tailoringmanagement_app.config.app.AuditEntityListener;
import com.gersonandre.tailoringmanagement.app.gersonandre_tailoringmanagement_app.maintenance.entity.enums.InteractionType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "interaction")
@EntityListeners(AuditEntityListener.class)
public class Interaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    InteractionType type;
    @Column(name = "ocurred_at", nullable = false)
    LocalDateTime ocurredAt;
    @Column(nullable = false)
    String notes;
    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    Customer customer;
}
