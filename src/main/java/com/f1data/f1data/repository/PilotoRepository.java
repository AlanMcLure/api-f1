package com.f1data.f1data.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.f1data.f1data.entity.PilotoEntity;

@Repository
public interface PilotoRepository extends JpaRepository<PilotoEntity, Long> {
    
    Optional<PilotoEntity> findByNombre(String nombre);

    Page<PilotoEntity> findByNacionalidadContaining(String nacionalidad, Pageable oPageable);

    @Query(value = "SELECT DISTINCT p.* FROM piloto p JOIN resultadoCarrera rca ON p.id = rca.piloto_id WHERE rca.posicion = 1", nativeQuery = true)
    Page<PilotoEntity> findPilotosGanadores(Pageable oPageable);

    @Query(value = "SELECT DISTINCT p.* FROM piloto p JOIN resultadoCarrera rca ON p.id = rca.piloto_id WHERE rca.posicion IN (1, 2, 3)", nativeQuery = true)
    Page<PilotoEntity> findPilotosPodio(Pageable oPageable);

    /* @Query(value = "SELECT DISTINCT p.id FROM piloto p JOIN resultadoCarrera rca ON p.id = rca.piloto_id JOIN carrera c ON rca.carrera_id = c.id WHERE YEAR(c.fecha_inic) = :anyo", nativeQuery = true)
    Page<PilotoEntity> findPilotosPorTemporada(@Param("anyo") int anyo, Pageable pageable); */
    @Query(value = "SELECT DISTINCT p.* FROM piloto p " +
                   "JOIN resultadoCarrera rc ON p.id = rc.piloto_id " +
                   "JOIN carrera c ON rc.carrera_id = c.id " +
                   "WHERE YEAR(c.fecha_inic) = :anyo", nativeQuery = true)
    List<PilotoEntity> findPilotosPorTemporada(@Param("anyo") int anyo);

    @Query(value = "SELECT * FROM piloto p WHERE TIMESTAMPDIFF(YEAR, p.fecha_nac, CURDATE()) = :edad", nativeQuery = true)
    Page<PilotoEntity> findPilotosPorEdad(@Param("edad") int edad, Pageable oPageable);
}
