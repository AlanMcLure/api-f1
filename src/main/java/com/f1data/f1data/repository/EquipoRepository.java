package com.f1data.f1data.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.f1data.f1data.entity.EquipoEntity;

public interface EquipoRepository extends JpaRepository<EquipoEntity, Long> {

    Optional<EquipoEntity> findByNombre(String nombre);

    Page<EquipoEntity> findByPais(String pais, Pageable oPageable);

    // Page<EquipoEntity> findByMotor(String motor, Pageable oPageable);

    // Page<EquipoEntity> findByChasis(String chasis, Pageable oPageable);

}
