package com.f1data.f1data.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.f1data.f1data.entity.GranPremioEntity;

@Repository
public interface GranPremioRepository extends JpaRepository<GranPremioEntity, Long> {

    Optional<GranPremioEntity> findByNombre(String nombre);

    @Query(value = "SELECT * FROM gran_premio gp WHERE YEAR(gp.fecha_inic) = :year ORDER BY gp.fecha_inic", nativeQuery = true)
    Page<GranPremioEntity> findByYear(int year, Pageable oPageable);
}
