package com.gersonandre.tailoringmanagement.app.gersonandre_tailoringmanagement_app.maintenance.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "suit")
public class Suit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    //TODO: Add a field for all the pieces of the suit, even shoes.
    
}
