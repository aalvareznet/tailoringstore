package com.gersonandre.tailoringmanagement.app.gersonandre_tailoringmanagement_app.maintenance.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "suit")
public class Suit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @OneToOne
    @JoinColumn(name = "jacket_id", nullable = true)
    Jacket jacket;
    @OneToOne
    @JoinColumn(name = "pant_id", nullable = true)
    Pant pant;
    @OneToOne
    @JoinColumn(name = "vest_id", nullable = true)
    Vest vest;
    @OneToOne
    @JoinColumn(name = "shirt_id", nullable = true)
    Shirt shirt;
    @OneToOne
    @JoinColumn(name = "accessory_id", nullable = true)
    Accessory accessory;
    @OneToOne
    @JoinColumn(name = "shoe_id", nullable = true)
    Shoe shoe;
}
