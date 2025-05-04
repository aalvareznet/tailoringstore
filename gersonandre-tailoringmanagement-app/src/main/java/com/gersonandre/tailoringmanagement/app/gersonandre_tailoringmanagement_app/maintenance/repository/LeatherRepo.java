package com.gersonandre.tailoringmanagement.app.gersonandre_tailoringmanagement_app.maintenance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gersonandre.tailoringmanagement.app.gersonandre_tailoringmanagement_app.maintenance.entity.Leather;

@Repository
public interface LeatherRepo extends JpaRepository<Leather, Long>{

}
