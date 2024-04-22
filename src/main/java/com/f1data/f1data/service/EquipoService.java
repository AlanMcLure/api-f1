package com.f1data.f1data.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.f1data.f1data.entity.EquipoEntity;
import com.f1data.f1data.exception.ResourceNotFoundException;
import com.f1data.f1data.repository.EquipoRepository;
import com.f1data.f1data.repository.ResultadoCarreraRepository;

@Service
public class EquipoService {

    @Autowired
    EquipoRepository oEquipoRepository;

    @Autowired
    ResultadoCarreraRepository oResultadoCarreraRepository;

    public EquipoEntity get(Long id) {
        return oEquipoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Equipo no encontrado"));
    }

    public EquipoEntity getByNombre(String nombre) {
        return oEquipoRepository.findByNombre(nombre)
                .orElseThrow(() -> new ResourceNotFoundException("Equipo no encontrado"));
    }

    public Page<EquipoEntity> getPage(Pageable oPageable) {
        return oEquipoRepository.findAll(oPageable);
    }

    public Page<EquipoEntity> getEquiposPorTemporada(int anyo, Pageable oPageable) {
        return oEquipoRepository.findEquiposPorTemporada(anyo, oPageable);
    }

    public Page<EquipoEntity> getByPais(String pais, Pageable oPageable) {
        return oEquipoRepository.findByPais(pais, oPageable);
    }

    public Page<EquipoEntity> getEquiposGanadores(Pageable oPageable) {
        return oEquipoRepository.findEquiposGanadores(oPageable);
    }

    public Page<EquipoEntity> getEquiposGanadoresPorTemporada(int anyo, Pageable oPageable) {
        return oEquipoRepository.findEquiposGanadoresPorTemporada(anyo, oPageable);
    }

    public Page<EquipoEntity> getEquiposPodio(Pageable oPageable) {
        return oEquipoRepository.findEquiposPodio(oPageable);
    }

    public Page<EquipoEntity> getEquiposPodioPorTemporada(int anyo, Pageable oPageable) {
        return oEquipoRepository.findEquiposPodioPorTemporada(anyo, oPageable);
    }

    public Long create(EquipoEntity oEquipo) {
        return oEquipoRepository.save(oEquipo).getId();
    }

    public EquipoEntity update(EquipoEntity oEquipo) {
        return oEquipoRepository.save(oEquipo);
    }

    public Long delete(Long id) {
        EquipoEntity oEquipoEntityBD = get(id);
        oEquipoRepository.delete(oEquipoEntityBD);
        return id;
    }

}
