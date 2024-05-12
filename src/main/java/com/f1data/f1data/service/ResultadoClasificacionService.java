package com.f1data.f1data.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.f1data.f1data.entity.ResultadoClasificacionEntity;
import com.f1data.f1data.exception.ResourceNotFoundException;
import com.f1data.f1data.repository.ResultadoClasificacionRepository;

@Service
public class ResultadoClasificacionService {

    @Autowired
    ResultadoClasificacionRepository oResultadoClasificacionRepository;

    public ResultadoClasificacionEntity get(Long id) {
        return oResultadoClasificacionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Resultado de clasificación no encontrado"));
    }

    public ResultadoClasificacionEntity getResultadoClasificacionByClasificacionAndPiloto(Long idClasificacion,
            Long idPiloto) {
        return oResultadoClasificacionRepository.findByClasificacionAndPiloto(idClasificacion, idPiloto);
    }

    public ResultadoClasificacionEntity getResultadoClasificacionByClasificacionAndPosicion(Long idClasificacion,
            int posicion) {
        return oResultadoClasificacionRepository.findByClasificacionAndPosicion(idClasificacion, posicion);
    }

    public Page<ResultadoClasificacionEntity> getPage(Pageable oPageable) {
        return oResultadoClasificacionRepository.findAll(oPageable);
    }

    public Page<ResultadoClasificacionEntity> getResultadosClasificacionByClasificacion(Long idClasificacion,
            Pageable oPageable) {
        return oResultadoClasificacionRepository.findByClasificacion(idClasificacion, oPageable);
    }

    public Page<ResultadoClasificacionEntity> getResultadosClasificacionByPiloto(Long idPiloto, Pageable oPageable) {
        return oResultadoClasificacionRepository.findByPiloto(idPiloto, oPageable);
    }

    public Page<ResultadoClasificacionEntity> getResultadosClasificacionByYear(int year, Pageable oPageable) {
        return oResultadoClasificacionRepository.findByYear(year, oPageable);
    }

    public Page<ResultadoClasificacionEntity> getResultadosClasificacionByYearAndPiloto(int year, Long idPiloto,
            Pageable oPageable) {
        return oResultadoClasificacionRepository.findByYearAndPiloto(year, idPiloto, oPageable);
    }

    public Long create(ResultadoClasificacionEntity oResultadoClasificacionEntity) {
        return oResultadoClasificacionRepository.save(oResultadoClasificacionEntity).getId();
    }

    public ResultadoClasificacionEntity update(ResultadoClasificacionEntity oResultadoClasificacionEntity) {
        return oResultadoClasificacionRepository.save(oResultadoClasificacionEntity);
    }

    public Long delete(Long id) {
        ResultadoClasificacionEntity oResultadoClasificacionEntity = get(id);
        oResultadoClasificacionRepository.delete(oResultadoClasificacionEntity);
        return id;
    }

}
