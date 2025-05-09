package com.gersonandre.tailoringmanagement.app.gersonandre_tailoringmanagement_app.config.app;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gersonandre.tailoringmanagement.app.gersonandre_tailoringmanagement_app.maintenance.entity.AuditRecord;
import com.gersonandre.tailoringmanagement.app.gersonandre_tailoringmanagement_app.maintenance.repository.AuditRecordRepo;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreRemove;
import jakarta.persistence.PreUpdate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.time.LocalDateTime;
import java.util.Optional;

public class AuditEntityListener {

    private final ObjectMapper mapper = new ObjectMapper();

    @PrePersist
    public void prePersist(Object entity) {
        saveAudit("INSERT", null, entity);
    }

    @PreUpdate
    public void preUpdate(Object entity) {
        saveAudit("UPDATE", null, entity);
    }

    @PreRemove
    public void preRemove(Object entity) {
        saveAudit("DELETE", entity, null);
    }

    private void saveAudit(String action, Object oldObj, Object newObj) {
        try {
            // Usamos el repo real: AuditRecordRepo
            AuditRecordRepo repo = SpringContext.getBean(AuditRecordRepo.class);
            AuditRecord record = new AuditRecord();

            Object target    = Optional.ofNullable(newObj).orElse(oldObj);
            String tableName = target.getClass().getSimpleName();
            String pk        = getEntityId(target);

            record.setTableName(tableName);
            record.setPk(pk);
            record.setAction(action);
            record.setOldData(toJson(oldObj));
            record.setNewData(toJson(newObj));
            record.setChangedAt(LocalDateTime.now());
            record.setChangedBy(currentUser());

            repo.save(record);

        } catch (Exception e) {
            // No interrumpir la operación principal
            e.printStackTrace();
        }
    }

    private String getEntityId(Object entity) {
        try {
            return entity.getClass()
                         .getMethod("getId")
                         .invoke(entity)
                         .toString();
        } catch (Exception e) {
            return "unknown";
        }
    }

    private String toJson(Object obj) {
        if (obj == null) return null;
        try {
            return mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            return "{}";
        }
    }

    private String currentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return Optional.ofNullable(auth)
                       .filter(Authentication::isAuthenticated)
                       .map(Authentication::getName)
                       .orElse("SYSTEM");
    }
}