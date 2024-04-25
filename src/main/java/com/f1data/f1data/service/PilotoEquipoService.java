package com.f1data.f1data.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.f1data.f1data.entity.PilotoEntity;
import com.f1data.f1data.entity.PilotoEquipoEntity;
import com.f1data.f1data.repository.PilotoEquipoRepository;

@Service
public class PilotoEquipoService {

    @Autowired
    PilotoEquipoRepository oPilotoEquipoRepository;

    public Page<PilotoEquipoEntity> getPilotosPorEquipo(Long idEquipo, Pageable oPageable) {
        return oPilotoEquipoRepository.findByEquipoId(idEquipo, oPageable);
    }

    public Page<PilotoEquipoEntity> getEquiposPorPiloto(Long idPiloto, Pageable oPageable) {
        return oPilotoEquipoRepository.findByPilotoId(idPiloto, oPageable);
    }

    public Page<PilotoEquipoEntity> getPilotoEquipo(Long idEquipo, Long idPiloto, Pageable oPageable) {
        return oPilotoEquipoRepository.findByEquipoIdAndPilotoId(idEquipo, idPiloto, oPageable);
    }

    public Page<PilotoEquipoEntity> getPilotoEquipoPorNombre(String nombre, Pageable oPageable) {
        return oPilotoEquipoRepository.findByEquipoNombre(nombre, oPageable);
    }

    public List<PilotoEquipoEntity> obtenerHistorialEquipos(PilotoEntity piloto) {
        // Recuperar el historial de equipos del piloto específico
        return oPilotoEquipoRepository.findByPilotoOrderByFechaInic(piloto);
    }

}
