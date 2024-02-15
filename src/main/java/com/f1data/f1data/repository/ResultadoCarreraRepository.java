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

    // Consultas para un piloto específico
    @Query(value = "SELECT COUNT(*) FROM resultado_carrera WHERE piloto_id = :idPiloto AND posicion = 1", nativeQuery = true)
    Integer cuentaVictoriasPorPiloto(Long idPiloto);

    @Query(value = "SELECT COUNT(*) FROM resultado_carrera WHERE piloto_id = :idPiloto AND posicion <= 3", nativeQuery = true)
    Integer cuentaPodiosPorPiloto(Long idPiloto);

    @Query(value = "SELECT COUNT(*) FROM resultado_carrera WHERE piloto_id = :idPiloto", nativeQuery = true)
    Integer cuentaCarrerasDisputadasPorPiloto(Long idPiloto);

    @Query(value = "SELECT COUNT(*) FROM resultado_carrera WHERE piloto_id = :idPiloto AND vuelta_rapida = 1", nativeQuery = true)
    Integer cuentaVueltasRapidasPorPiloto(Long idPiloto);

    @Query(value = "SELECT COUNT(*) FROM resultado_carrera WHERE piloto_id = :idPiloto AND dnf = 1", nativeQuery = true)
    Integer cuentaAbandonosPorPiloto(Long idPiloto);

    @Query(value = "SELECT MIN(posicion) FROM resultado_carrera WHERE piloto_id = :idPiloto", nativeQuery = true)
    Integer mejorPosicionCarreraPorPiloto(Long idPiloto);

    @Query(value = "SELECT COUNT(*) FROM resultado_carrera WHERE piloto_id = :idPiloto AND posicion = (SELECT MIN(posicion) FROM resultado_carrera WHERE piloto_id = :idPiloto)", nativeQuery = true)
    Integer cuentaVecesMejorPosicionCarrera(Long idPiloto);

    @Query(value = "SELECT SUM(CASE "
            + "WHEN posicion = 1 THEN 25 "
            + "WHEN posicion = 2 THEN 18 "
            + "WHEN posicion = 3 THEN 15 "
            + "WHEN posicion = 4 THEN 12 "
            + "WHEN posicion = 5 THEN 10 "
            + "WHEN posicion = 6 THEN 8 "
            + "WHEN posicion = 7 THEN 6 "
            + "WHEN posicion = 8 THEN 4 "
            + "WHEN posicion = 9 THEN 2 "
            + "WHEN posicion = 10 THEN 1 "
            + "ELSE 0 END "
            + "+ CASE WHEN posicion <= 10 AND vuelta_rapida = 1 THEN 1 ELSE 0 END) "
            + "FROM resultado_carrera WHERE piloto_id = :idPiloto", nativeQuery = true)
    Integer sumaPuntosPorPiloto(Long idPiloto);

    // Por hacer (crear resultadoClasificacionRepository)
}
