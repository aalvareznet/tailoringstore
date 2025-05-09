package com.gersonandre.tailoringmanagement.app.gersonandre_tailoringmanagement_app.maintenance.entity;

import java.time.LocalDateTime;

import com.gersonandre.tailoringmanagement.app.gersonandre_tailoringmanagement_app.config.app.AuditEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "segment")
@EntityListeners(AuditEntityListener.class)
public class Segment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(nullable = false)
    String name;
    @Column(nullable = false)
    String criteria;
    @Column(name = "created_at", nullable = false)
    LocalDateTime createdAt;
}
