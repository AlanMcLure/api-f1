package com.f1data.f1data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.f1data.f1data.entity.ClasificacionEntity;

@Repository
public interface ClasificacionRepository extends JpaRepository<ClasificacionEntity, Long> {


    
}
