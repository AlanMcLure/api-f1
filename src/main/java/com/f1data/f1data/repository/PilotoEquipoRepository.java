package com.f1data.f1data.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.f1data.f1data.entity.PilotoEntity;
import com.f1data.f1data.entity.PilotoEquipoEntity;

public interface PilotoEquipoRepository extends JpaRepository<PilotoEquipoEntity, Long> {

    Page<PilotoEquipoEntity> findByEquipoId(Long id, Pageable pageable);

    Page<PilotoEquipoEntity> findByPilotoId(Long id, Pageable pageable);

    Page<PilotoEquipoEntity> findByEquipoIdAndPilotoId(Long idEquipo, Long idPiloto, Pageable pageable);

    Page<PilotoEquipoEntity> findByEquipoNombre(String nombre, Pageable pageable);

    @Query("SELECT pe FROM PilotoEquipoEntity pe WHERE pe.piloto = :piloto ORDER BY pe.fecha_inic")
    List<PilotoEquipoEntity> findByPilotoOrderByFechaInic(@Param("piloto") PilotoEntity piloto);

}
