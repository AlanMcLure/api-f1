package com.f1data.f1data.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.f1data.f1data.entity.PilotoEntity;
import com.f1data.f1data.entity.ContratoEntity;
import com.f1data.f1data.repository.ContratoRepository;

@Service
public class ContratoService {

    @Autowired
    ContratoRepository oContratoRepository;

    public Page<ContratoEntity> getPilotosPorEquipo(Long idEquipo, Pageable oPageable) {
        return oContratoRepository.findByEquipoId(idEquipo, oPageable);
    }

    public Page<ContratoEntity> getEquiposPorPiloto(Long idPiloto, Pageable oPageable) {
        return oContratoRepository.findByPilotoId(idPiloto, oPageable);
    }

    public Page<ContratoEntity> getPilotoEquipo(Long idEquipo, Long idPiloto, Pageable oPageable) {
        return oContratoRepository.findByEquipoIdAndPilotoId(idEquipo, idPiloto, oPageable);
    }

    public Page<ContratoEntity> getPilotoEquipoPorNombre(String nombre, Pageable oPageable) {
        return oContratoRepository.findByEquipoNombre(nombre, oPageable);
    }

    // public List<ContratoEntity> obtenerHistorialEquipos(Long idPiloto) {
    // // Recuperar el historial de equipos del piloto específico
    // return oContratoRepository.findByPilotoOrderByFechaInic(idPiloto);
    // }

}
