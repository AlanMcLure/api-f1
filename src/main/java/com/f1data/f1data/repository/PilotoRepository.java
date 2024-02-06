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

    @Query(value = "SELECT DISTINCT p.* FROM piloto p JOIN resultado_carrera rca ON p.id = rca.piloto_id WHERE rca.posicion = 1", nativeQuery = true)
    Page<PilotoEntity> findPilotosGanadores(Pageable oPageable);

    @Query(value = "SELECT DISTINCT p.* FROM piloto p JOIN resultado_carrera rca ON p.id = rca.piloto_id WHERE rca.posicion IN (1, 2, 3)", nativeQuery = true)
    Page<PilotoEntity> findPilotosPodio(Pageable oPageable);

    /*
     * @Query(value =
     * "SELECT DISTINCT p.id FROM piloto p JOIN resultado_carrera rca ON p.id = rca.piloto_id JOIN carrera c ON rca.carrera_id = c.id WHERE YEAR(c.fecha_inic) = :anyo"
     * , nativeQuery = true)
     * Page<PilotoEntity> findPilotosPorTemporada(@Param("anyo") int anyo, Pageable
     * pageable);
     */
    @Query(value = "SELECT * FROM piloto p WHERE p.id IN (SELECT piloto_id FROM resultado_carrera WHERE carrera_id IN (SELECT id FROM carrera WHERE YEAR(fecha_inic) = :anyo))", nativeQuery = true)
    Page<PilotoEntity> findPilotosPorTemporada(@Param("anyo") int anyo, Pageable oPageable);

    @Query(value = "SELECT DISTINCT p.* FROM piloto p WHERE p.id IN (SELECT piloto_id FROM resultado_carrera rc WHERE rc.posicion = 1) AND p.id IN (SELECT piloto_id FROM resultado_carrera WHERE carrera_id IN (SELECT id FROM carrera WHERE YEAR(fecha_inic) = :anyo))", nativeQuery = true)
    Page<PilotoEntity> findPilotosGanadoresPorTemporada(@Param("anyo") int anyo, Pageable oPageable);

    @Query(value = "SELECT DISTINCT p.* FROM piloto p WHERE p.id IN (SELECT piloto_id FROM resultado_carrera rc WHERE rc.posicion IN (1, 2, 3)) AND p.id IN (SELECT piloto_id FROM resultado_carrera WHERE carrera_id IN (SELECT id FROM carrera WHERE YEAR(fecha_inic) = :anyo))", nativeQuery = true)
    Page<PilotoEntity> findPilotosPodioPorTemporada(@Param("anyo") int anyo, Pageable oPageable);

    @Query(value = "SELECT * FROM piloto p WHERE TIMESTAMPDIFF(YEAR, p.fecha_nac, CURDATE()) = :edad", nativeQuery = true)
    Page<PilotoEntity> findPilotosPorEdad(@Param("edad") int edad, Pageable oPageable);
}
