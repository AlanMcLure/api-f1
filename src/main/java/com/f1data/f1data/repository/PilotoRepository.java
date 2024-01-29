package com.f1data.f1data.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.f1data.f1data.entity.PilotoEntity;

@Repository
public interface PilotoRepository extends JpaRepository<PilotoEntity, Long> {
    
    Optional<PilotoEntity> findByNombre(String nombre);

    Page<PilotoEntity> findByNacionalidadContaining(String nacionalidad, Pageable pageable);

    @Query(value = "SELECT * FROM Piloto p JOIN ResultadoCarrera rca ON p.id = rca.piloto_id WHERE rca.posicion = 1", nativeQuery = true)
    List<PilotoEntity> findPilotosGanadores();

    @Query(value = "SELECT * FROM Piloto p JOIN ResultadoCarrera rca ON p.id = rca.piloto_id WHERE rca.posicion IN (1, 2, 3)", nativeQuery = true)
    List<PilotoEntity> findPilotosPodio();
}
