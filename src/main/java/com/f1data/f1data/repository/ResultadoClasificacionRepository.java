package com.f1data.f1data.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.f1data.f1data.entity.ResultadoClasificacionEntity;

@Repository
public interface ResultadoClasificacionRepository extends JpaRepository<ResultadoClasificacionEntity, Long> {

    @Query(value = "SELECT * FROM resultado_clasificacion rc WHERE rc.clasificacion_id = :idClasificacion AND rc.piloto_id = :idPiloto", nativeQuery = true)
    ResultadoClasificacionEntity findByClasificacionAndPiloto(Long idClasificacion, Long idPiloto);

    @Query(value = "SELECT * FROM resultado_clasificacion rc WHERE rc.clasificacion_id = :idClasificacion AND rc.posicion = :posicion", nativeQuery = true)
    ResultadoClasificacionEntity findByClasificacionAndPosicion(Long idClasificacion, int posicion);

    @Query(value = "SELECT * FROM resultado_clasificacion rc WHERE rc.clasificacion_id = :idClasificacion", nativeQuery = true)
    Page<ResultadoClasificacionEntity> findByClasificacion(Long idClasificacion, Pageable oPageable);

    @Query(value = "SELECT * FROM resultado_clasificacion rc WHERE rc.piloto_id = :idPiloto", nativeQuery = true)
    Page<ResultadoClasificacionEntity> findByPiloto(Long idPiloto, Pageable oPageable);

    @Query(value = "SELECT * FROM resultado_clasificacion WHERE clasificacion_id IN (SELECT id FROM carrera WHERE YEAR(fecha_inic) = :year)", nativeQuery = true)
    Page<ResultadoClasificacionEntity> findByYear(int year, Pageable oPageable);

    @Query(value = "SELECT * FROM resultado_clasificacion rc WHERE clasificacion_id IN (SELECT id FROM carrera WHERE YEAR(fecha_inic) = :year) AND piloto_id = :idPiloto", nativeQuery = true)
    Page<ResultadoClasificacionEntity> findByYearAndPiloto(int year, Long idPiloto, Pageable oPageable);

    // Consultas para un piloto específico
    @Query(value = "SELECT COUNT(*) FROM resultado_clasificacion WHERE piloto_id = :idPiloto AND posicion = 1", nativeQuery = true)
    Integer cuentaPolesPorPiloto(Long idPiloto);

    @Query(value = "SELECT COUNT(*) FROM resultado_clasificacion WHERE piloto_id = :idPiloto AND posicion <= 2", nativeQuery = true)
    Integer cuentaPrimerasFilasPorPiloto(Long idPiloto);

    @Query(value = "SELECT COUNT(*) FROM resultado_clasificacion WHERE piloto_id = :idPiloto", nativeQuery = true)
    Integer cuentaClasificacionesDisputadasPorPiloto(Long idPiloto);

    @Query(value = "SELECT COUNT(*) FROM resultado_clasificacion WHERE piloto_id = :idPiloto AND vuelta_q1 IS NOT NULL", nativeQuery = true)
    Integer cuentaQ1PorPiloto(Long idPiloto);

    @Query(value = "SELECT COUNT(*) FROM resultado_clasificacion WHERE piloto_id = :idPiloto AND vuelta_q2 IS NOT NULL", nativeQuery = true)
    Integer cuentaQ2PorPiloto(Long idPiloto);

    @Query(value = "SELECT COUNT(*) FROM resultado_clasificacion WHERE piloto_id = :idPiloto AND vuelta_q3 IS NOT NULL", nativeQuery = true)
    Integer cuentaQ3PorPiloto(Long idPiloto);

    @Query(value = "SELECT COUNT(*) FROM resultado_clasificacion WHERE piloto_id = :idPiloto AND penalizacion > 0", nativeQuery = true)
    Integer cuentaPenalizacionesPorPiloto(Long idPiloto);

    @Query(value = "SELECT MIN(posicion) FROM resultado_clasificacion WHERE piloto_id = :idPiloto", nativeQuery = true)
    Integer mejorPosicionClasificacionPorPiloto(Long idPiloto);

    @Query(value = "SELECT COUNT(*) FROM resultado_clasificacion WHERE piloto_id = :idPiloto AND posicion = (SELECT MIN(posicion) FROM resultado_clasificacion WHERE piloto_id = :idPiloto)", nativeQuery = true)
    Integer cuentaVecesMejorPosicionClasificacion(Long idPiloto);

}
