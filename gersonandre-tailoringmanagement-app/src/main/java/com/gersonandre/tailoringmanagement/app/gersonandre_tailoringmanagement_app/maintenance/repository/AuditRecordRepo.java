package com.gersonandre.tailoringmanagement.app.gersonandre_tailoringmanagement_app.maintenance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gersonandre.tailoringmanagement.app.gersonandre_tailoringmanagement_app.maintenance.entity.AuditRecord;

public interface AuditRecordRepo extends JpaRepository<AuditRecord, Long>{

}
