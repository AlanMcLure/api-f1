package com.f1data.f1data.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.f1data.f1data.entity.ContratoEntity;

public interface ContratoRepository extends JpaRepository<ContratoEntity, Long> {

    Page<ContratoEntity> findByEquipoId(Long id, Pageable pageable);

    Page<ContratoEntity> findByPilotoId(Long id, Pageable pageable);

    Page<ContratoEntity> findByEquipoIdAndPilotoId(Long idEquipo, Long idPiloto, Pageable pageable);

    Page<ContratoEntity> findByEquipoNombre(String nombre, Pageable pageable);

    @Query(value = "SELECT c FROM Contrato c WHERE c.piloto.id = :idPiloto ORDER BY c.fecha_inic", nativeQuery = true)
    Page<ContratoEntity> findByPilotoOrderByFechaInic(Long idPiloto, Pageable pageable);

}
