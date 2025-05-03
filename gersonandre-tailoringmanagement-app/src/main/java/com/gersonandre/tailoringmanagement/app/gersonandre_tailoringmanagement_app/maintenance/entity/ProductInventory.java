package com.gersonandre.tailoringmanagement.app.gersonandre_tailoringmanagement_app.maintenance.entity;

import com.gersonandre.tailoringmanagement.app.gersonandre_tailoringmanagement_app.maintenance.entity.enums.ProductType;

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
@Table(name = "product_inventory")
public class ProductInventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String description;
    @Enumerated(EnumType.STRING)
    ProductType type;
    Integer quantity;
    Double price;
    @Column(name = "image_url")
    String imageUrl;
    String size;
}
