package com.f1data.f1data.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.f1data.f1data.entity.ClasificacionEntity;
import com.f1data.f1data.exception.ResourceNotFoundException;
import com.f1data.f1data.repository.ClasificacionRepository;

@Service
public class ClasificacionService {
  
    @Autowired
    ClasificacionRepository oClasificacionRepository;

    public ClasificacionEntity get(Long id) {
        return oClasificacionRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Clasificación no encontrada"));
    }

    public Page<ClasificacionEntity> getPage(Pageable oPageable) {
      return oClasificacionRepository.findAll(oPageable);
    }

    public Long create(ClasificacionEntity oClasificacionEntity) {
        return oClasificacionRepository.save(oClasificacionEntity).getId();
    }

    public ClasificacionEntity update(ClasificacionEntity oClasificacionEntity) {
        ClasificacionEntity oClasificacionEntityBD = get(oClasificacionEntity.getId());
        oClasificacionEntityBD.setFechaInic(oClasificacionEntity.getFechaInic());
        oClasificacionEntityBD.setGranPremio(oClasificacionEntity.getGranPremio());
        return oClasificacionRepository.save(oClasificacionEntityBD);
    }

    public Long delete(Long id) {
        ClasificacionEntity oClasificacionEntityBD = get(id);
        oClasificacionRepository.delete(oClasificacionEntityBD);
        return id;
    }
}
