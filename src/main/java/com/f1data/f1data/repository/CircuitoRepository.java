package com.f1data.f1data.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.f1data.f1data.entity.CircuitoEntity;

@Repository
public interface CircuitoRepository extends JpaRepository<CircuitoEntity, Long> {
    
    Optional<CircuitoEntity> findByNombre(String nombre);

    Page<CircuitoEntity> findByPais(String pais, Pageable oPageable);

    Page<CircuitoEntity> findByCiudad(String ciudad, Pageable oPageable);

    Page<CircuitoEntity> findByRegion(String region, Pageable oPageable);
    
}
