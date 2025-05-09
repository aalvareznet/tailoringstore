package com.gersonandre.tailoringmanagement.app.gersonandre_tailoringmanagement_app.maintenance.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "audit_record")
public class AuditRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "table_name", nullable = false, length = 100)
    String tableName;
    @Column(name = "pk", nullable = false, length = 100)
    private String pk;
    @Column(name = "action", nullable = false, length = 10)
    private String action;
    @Lob
    @Column(name = "old_data", columnDefinition = "TEXT")
    private String oldData;
    @Lob
    @Column(name = "new_data", columnDefinition = "TEXT")
    private String newData;
    @Column(name = "changed_at", nullable = false)
    private LocalDateTime changedAt;
    @Column(name = "changed_by", nullable = false, length = 100)
    private String changedBy;
}
