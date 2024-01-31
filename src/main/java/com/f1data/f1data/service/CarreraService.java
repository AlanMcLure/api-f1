package com.f1data.f1data.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.f1data.f1data.entity.CarreraEntity;
import com.f1data.f1data.exception.ResourceNotFoundException;
import com.f1data.f1data.repository.CarreraRepository;

@Service
public class CarreraService {

    @Autowired
    CarreraRepository oCarreraRepository;

    public CarreraEntity get(Long id) {
        return oCarreraRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Carrera no encontrada"));
    }

    // public CarreraEntity getCarreraByNumVueltas(int num_vueltas) {
    // return oCarreraRepository.findByNumVueltas(num_vueltas)
    // .orElseThrow(() -> new ResourceNotFoundException("Carrera no encontrada"));
    // }

    public Page<CarreraEntity> getPage(Pageable oPageable) {
        return oCarreraRepository.findAll(oPageable);
    }

    public Page<CarreraEntity> getCarreraByVueltas(int num_vueltas, Pageable oPageable) {
        return oCarreraRepository.findByNumVueltas(num_vueltas, oPageable);
    }

    public Long create(CarreraEntity oCarreraEntity) {
        return oCarreraRepository.save(oCarreraEntity).getId();
    }

    public CarreraEntity update(CarreraEntity oCarreraEntity) {
        CarreraEntity oCarreraEntityBD = get(oCarreraEntity.getId());
        oCarreraEntityBD.setNumVueltas(oCarreraEntity.getNumVueltas());
        oCarreraEntityBD.setFechaInic(oCarreraEntity.getFechaInic());
        oCarreraEntityBD.setSafety(oCarreraEntity.isSafety());
        oCarreraEntityBD.setGranPremio(oCarreraEntity.getGranPremio());
        return oCarreraRepository.save(oCarreraEntityBD);
    }

    public Long delete(Long id) {
        CarreraEntity oCarreraEntityBD = get(id);
        oCarreraRepository.delete(oCarreraEntityBD);
        return id;
    }

}
