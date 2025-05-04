package com.gersonandre.tailoringmanagement.app.gersonandre_tailoringmanagement_app.maintenance.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "shirt")
public class Shirt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    //TODO: Add a field for the fabric
    Double neck;
    Double sleeve;
    String specification;
}
