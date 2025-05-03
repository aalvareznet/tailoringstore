package com.gersonandre.tailoringmanagement.app.gersonandre_tailoringmanagement_app.maintenance.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "factory")
public class Factory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String address;
    String phone;
    String email;
    @Column(name = "contact_person")
    String contactPerson;
    String description;
}
