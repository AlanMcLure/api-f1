package com.f1data.f1data.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.f1data.f1data.entity.CircuitoEntity;
import com.f1data.f1data.exception.ResourceNotFoundException;
import com.f1data.f1data.repository.CircuitoRepository;

@Service
public class CircuitoService {
    
    @Autowired CircuitoRepository oCircuitoRepository;

    public CircuitoEntity get(Long id) {
        return oCircuitoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Circuito no encontrado"));
    }

    public CircuitoEntity getCircuitoByNombre(String nombre) {
        return oCircuitoRepository.findByNombre(nombre).orElseThrow(() -> new ResourceNotFoundException("Circuito no encontrado"));
    }

    public Page<CircuitoEntity> getPage(Pageable oPageable) {
        return oCircuitoRepository.findAll(oPageable);
    }

    public Page<CircuitoEntity> getCircuitoByPais(String pais, Pageable oPageable) {
        return oCircuitoRepository.findByPais(pais, oPageable);
    }

    public Page<CircuitoEntity> getCircuitoByCiudad(String ciudad, Pageable oPageable) {
        return oCircuitoRepository.findByCiudad(ciudad, oPageable);
    }

    public Page<CircuitoEntity> getCircuitoByRegion(String region, Pageable oPageable) {
        return oCircuitoRepository.findByRegion(region, oPageable);
    }

    public Long create(CircuitoEntity oCircuitoEntity) {
        return oCircuitoRepository.save(oCircuitoEntity).getId();
    }

    public CircuitoEntity update(CircuitoEntity oCircuitoEntity) {
        CircuitoEntity oCircuitoEntityBD = get(oCircuitoEntity.getId());
        oCircuitoEntityBD.setNombre(oCircuitoEntity.getNombre());
        oCircuitoEntityBD.setCiudad(oCircuitoEntity.getCiudad());
        oCircuitoEntityBD.setPais(oCircuitoEntity.getPais());
        oCircuitoEntityBD.setRegion(oCircuitoEntity.getRegion());
        return oCircuitoRepository.save(oCircuitoEntityBD);
    }

    public Long delete(Long id) {
        CircuitoEntity oCircuitoEntityBD = get(id);
        oCircuitoRepository.delete(oCircuitoEntityBD);
        return id;
    }
}
