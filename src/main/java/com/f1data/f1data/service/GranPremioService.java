package com.f1data.f1data.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.f1data.f1data.entity.GranPremioEntity;
import com.f1data.f1data.exception.ResourceNotFoundException;
import com.f1data.f1data.repository.GranPremioRepository;

@Service
public class GranPremioService {

    @Autowired
    GranPremioRepository oGranPremioRepository;

    public GranPremioEntity get(Long id) {
        return oGranPremioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Gran Premio no encontrado"));
    }

    public GranPremioEntity getGranPremioByNombre(String nombre) {
        return oGranPremioRepository.findByNombre(nombre)
                .orElseThrow(() -> new ResourceNotFoundException("Gran Premio no encontrado"));
    }

    public Page<GranPremioEntity> getPage(Pageable oPageable) {
        return oGranPremioRepository.findAll(oPageable);
    }

    public Page<GranPremioEntity> getGranPremioByYear(int year, Pageable oPageable) {
        return oGranPremioRepository.findByYear(year, oPageable);
    }

    public Long create(GranPremioEntity oGranPremioEntity) {
        return oGranPremioRepository.save(oGranPremioEntity).getId();
    }

    public GranPremioEntity update(GranPremioEntity oGranPremioEntity) {
        GranPremioEntity oGranPremioEntityBD = get(oGranPremioEntity.getId());
        oGranPremioEntityBD.setNombre(oGranPremioEntity.getNombre());
        oGranPremioEntityBD.setFecha_inic(oGranPremioEntity.getFecha_inic());
        oGranPremioEntityBD.setFecha_fin(oGranPremioEntity.getFecha_fin());
        oGranPremioEntityBD.setImg_flag(oGranPremioEntity.getImg_flag());
        oGranPremioEntityBD.setImg(oGranPremioEntity.getImg());
        oGranPremioEntityBD.setCircuito(oGranPremioEntity.getCircuito());
        return oGranPremioRepository.save(oGranPremioEntityBD);
    }

    public Long delete(Long id) {
        GranPremioEntity oGranPremioEntityBD = get(id);
        oGranPremioRepository.delete(oGranPremioEntityBD);
        return id;
    }
}
