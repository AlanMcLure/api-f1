package com.f1data.f1data.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.f1data.f1data.entity.ResultadoCarreraEntity;
import com.f1data.f1data.exception.ResourceNotFoundException;
import com.f1data.f1data.repository.ResultadoCarreraRepository;

@Service
public class ResultadoCarreraService {

    @Autowired
    ResultadoCarreraRepository oResultadoCarreraRepository;

    public ResultadoCarreraEntity get(Long id) {
        return oResultadoCarreraRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Gran Premio no encontrado"));
    }

    public ResultadoCarreraEntity getResultadoCarreraByCarreraAndPiloto(Long idCarrera, Long idPiloto) {
        return oResultadoCarreraRepository.findByCarreraAndPiloto(idCarrera, idPiloto);
    }

    public ResultadoCarreraEntity getResultadoCarreraByCarreraAndPosicion(Long idCarrera, int posicion) {
        return oResultadoCarreraRepository.findByCarreraAndPosicion(idCarrera, posicion);
    }

    public Page<ResultadoCarreraEntity> getPage(Pageable oPageable) {
        return oResultadoCarreraRepository.findAll(oPageable);
    }

    public Page<ResultadoCarreraEntity> getResultadosCarreraByCarrera(Long idCarrera, Pageable oPageable) {
        return oResultadoCarreraRepository.findByCarrera(idCarrera, oPageable);
    }

    public Page<ResultadoCarreraEntity> getResultadosCarreraByPiloto(Long idPiloto, Pageable oPageable) {
        return oResultadoCarreraRepository.findByPiloto(idPiloto, oPageable);
    }

    public Page<ResultadoCarreraEntity> getResultadosCarreraByYear(int year, Pageable oPageable) {
        return oResultadoCarreraRepository.findByYear(year, oPageable);
    }

    public Page<ResultadoCarreraEntity> getResultadosCarreraByYearAndPiloto(int year, Long idPiloto,
            Pageable oPageable) {
        return oResultadoCarreraRepository.findByYearAndPiloto(year, idPiloto, oPageable);
    }

    public Long create(ResultadoCarreraEntity oResultadoCarreraEntity) {
        return oResultadoCarreraRepository.save(oResultadoCarreraEntity).getId();
    }

    // public Long create(ResultadoCarreraEntity oResultadoCarreraEntity, Long
    // idCarrera, Long idPiloto) {
    // CarreraEntity carrera = carreraRepository.findById(idCarrera)
    // .orElseThrow(() -> new RuntimeException("Carrera no encontrada"));
    // PilotoEntity piloto = pilotoRepository.findById(idPiloto)
    // .orElseThrow(() -> new RuntimeException("Piloto no encontrado"));

    // oResultadoCarreraEntity.setCarrera(carrera);
    // oResultadoCarreraEntity.setPiloto(piloto);

    // return oResultadoCarreraRepository.save(oResultadoCarreraEntity).getId();
    // }

    public ResultadoCarreraEntity update(ResultadoCarreraEntity oResultadoCarreraEntity) {
        ResultadoCarreraEntity oResultadoCarreraEntityBD = get(oResultadoCarreraEntity.getId());
        oResultadoCarreraEntityBD.setCarrera(oResultadoCarreraEntity.getCarrera());
        oResultadoCarreraEntityBD.setPiloto(oResultadoCarreraEntity.getPiloto());
        oResultadoCarreraEntityBD.setVuelta_rapida(oResultadoCarreraEntity.isVuelta_rapida());
        oResultadoCarreraEntityBD.setTiempo_final(oResultadoCarreraEntity.getTiempo_final());
        oResultadoCarreraEntityBD.setPosicion(oResultadoCarreraEntity.getPosicion());
        oResultadoCarreraEntityBD.setNum_vueltas_completadas(oResultadoCarreraEntity.getNum_vueltas_completadas());
        oResultadoCarreraEntityBD.setTiempo_final(oResultadoCarreraEntity.getTiempo_final());
        return oResultadoCarreraRepository.save(oResultadoCarreraEntityBD);
    }

    public Long delete(Long id) {
        ResultadoCarreraEntity oResultadoCarreraEntityBD = get(id);
        oResultadoCarreraRepository.delete(oResultadoCarreraEntityBD);
        return id;
    }
}
