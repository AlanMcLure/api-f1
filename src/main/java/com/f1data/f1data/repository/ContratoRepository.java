package com.f1data.f1data.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.f1data.f1data.entity.PilotoEntity;
import com.f1data.f1data.entity.ContratoEntity;

public interface ContratoRepository extends JpaRepository<ContratoEntity, Long> {

    Page<ContratoEntity> findByEquipoId(Long id, Pageable pageable);

    Page<ContratoEntity> findByPilotoId(Long id, Pageable pageable);

    Page<ContratoEntity> findByEquipoIdAndPilotoId(Long idEquipo, Long idPiloto, Pageable pageable);

    Page<ContratoEntity> findByEquipoNombre(String nombre, Pageable pageable);

    @Query("SELECT pe FROM PilotoEquipoEntity pe WHERE pe.piloto = :piloto ORDER BY pe.fecha_inic")
    List<ContratoEntity> findByPilotoOrderByFechaInic(@Param("piloto") PilotoEntity piloto);

}
