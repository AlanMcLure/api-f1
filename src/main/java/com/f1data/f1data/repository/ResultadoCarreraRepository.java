package com.f1data.f1data.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.f1data.f1data.entity.ResultadoCarreraEntity;

@Repository
public interface ResultadoCarreraRepository extends JpaRepository<ResultadoCarreraEntity, Long> {

    @Query(value = "SELECT * FROM resultado_carrera rc WHERE rc.carrera_id = :idCarrera AND rc.piloto_id = :idPiloto", nativeQuery = true)
    ResultadoCarreraEntity findByCarreraAndPiloto(Long idCarrera, Long idPiloto);

    @Query(value = "SELECT * FROM resultado_carrera rc WHERE rc.carrera_id = :idCarrera AND rc.posicion = :posicion", nativeQuery = true)
    ResultadoCarreraEntity findByCarreraAndPosicion(Long idCarrera, int posicion);

    @Query(value = "SELECT * FROM resultado_carrera rc WHERE rc.carrera_id = :idCarrera", nativeQuery = true)
    Page<ResultadoCarreraEntity> findByCarrera(Long idCarrera, Pageable oPageable);

    @Query(value = "SELECT * FROM resultado_carrera rc WHERE rc.piloto_id = :idPiloto", nativeQuery = true)
    Page<ResultadoCarreraEntity> findByPiloto(Long idPiloto, Pageable oPageable);

    @Query(value = "SELECT * FROM resultado_carrera WHERE carrera_id IN (SELECT id FROM carrera WHERE YEAR(fecha_inic) = :year)", nativeQuery = true)
    Page<ResultadoCarreraEntity> findByYear(int year, Pageable oPageable);

    @Query(value = "SELECT * FROM resultado_carrera rc WHERE carrera_id IN (SELECT id FROM carrera WHERE YEAR(fecha_inic) = :year) AND piloto_id = :idPiloto", nativeQuery = true)
    Page<ResultadoCarreraEntity> findByYearAndPiloto(int year, Long idPiloto, Pageable oPageable);
}
