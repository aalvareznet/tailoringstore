package com.gersonandre.tailoringmanagement.app.gersonandre_tailoringmanagement_app.maintenance.entity;

import com.gersonandre.tailoringmanagement.app.gersonandre_tailoringmanagement_app.maintenance.entity.enums.CustomerRank;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "customer")
public class Customer {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name="first_name", nullable = false)
    String firstName;
    @Column(name="last_name", nullable = false)
    String lastName;
    @Column(nullable = false)
    String email;
    @Column(nullable = false)
    String phone;
    String address;
    @Enumerated(EnumType.STRING)
    CustomerRank rank;

}
