package com.f1data.f1data.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.f1data.f1data.entity.EquipoEntity;

public interface EquipoRepository extends JpaRepository<EquipoEntity, Long> {

    Optional<EquipoEntity> findByNombre(String nombre);

    Page<EquipoEntity> findByPais(String pais, Pageable oPageable);

    // Page<EquipoEntity> findByMotor(String motor, Pageable oPageable);

    // Page<EquipoEntity> findByChasis(String chasis, Pageable oPageable);

    @Query(value = "SELECT DISTINCT e.* FROM equipo e JOIN piloto_equipo pe ON e.id = pe.equipo_id JOIN resultado_carrera rc ON pe.piloto_id = rc.piloto_id WHERE rc.posicion = 1", nativeQuery = true)
    Page<EquipoEntity> findEquiposGanadores(Pageable oPageable);

    @Query(value = "SELECT DISTINCT e.* FROM equipo e JOIN piloto_equipo pe ON e.id = pe.equipo_id JOIN resultado_carrera rc ON pe.piloto_id = rc.piloto_id WHERE rc.posicion IN (1, 2, 3)", nativeQuery = true)
    Page<EquipoEntity> findEquiposPodio(Pageable oPageable);

    @Query(value = "SELECT * FROM equipo e WHERE e.id IN (SELECT equipo_id FROM piloto_equipo WHERE piloto_id IN (SELECT piloto_id FROM resultado_carrera WHERE carrera_id IN (SELECT id FROM carrera WHERE YEAR(fecha_inic) = :anyo)))", nativeQuery = true)
    Page<EquipoEntity> findEquiposPorTemporada(@Param("anyo") int anyo, Pageable oPageable);

    @Query(value = "SELECT DISTINCT e.* FROM equipo e WHERE e.id IN (SELECT equipo_id FROM piloto_equipo pe WHERE pe.piloto_id IN (SELECT piloto_id FROM resultado_carrera rc WHERE rc.posicion = 1) AND pe.piloto_id IN (SELECT piloto_id FROM resultado_carrera WHERE carrera_id IN (SELECT id FROM carrera WHERE YEAR(fecha_inic) = :anyo)))", nativeQuery = true)
    Page<EquipoEntity> findEquiposGanadoresPorTemporada(@Param("anyo") int anyo, Pageable oPageable);

    @Query(value = "SELECT DISTINCT e.* FROM equipo e WHERE e.id IN (SELECT equipo_id FROM piloto_equipo pe WHERE pe.piloto_id IN (SELECT piloto_id FROM resultado_carrera rc WHERE rc.posicion IN (1, 2, 3)) AND pe.piloto_id IN (SELECT piloto_id FROM resultado_carrera WHERE carrera_id IN (SELECT id FROM carrera WHERE YEAR(fecha_inic) = :anyo)))", nativeQuery = true)
    Page<EquipoEntity> findEquiposPodioPorTemporada(@Param("anyo") int anyo, Pageable oPageable);

}
