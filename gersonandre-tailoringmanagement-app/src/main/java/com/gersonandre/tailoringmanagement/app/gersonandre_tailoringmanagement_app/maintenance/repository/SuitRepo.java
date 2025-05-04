package com.gersonandre.tailoringmanagement.app.gersonandre_tailoringmanagement_app.maintenance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gersonandre.tailoringmanagement.app.gersonandre_tailoringmanagement_app.maintenance.entity.Suit;

@Repository
public interface SuitRepo extends JpaRepository<Suit, Long>{

}
