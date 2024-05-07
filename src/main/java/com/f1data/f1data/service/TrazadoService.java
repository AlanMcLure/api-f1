package com.f1data.f1data.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.f1data.f1data.entity.TrazadoEntity;
import com.f1data.f1data.exception.ResourceNotFoundException;
import com.f1data.f1data.repository.TrazadoRepository;

@Service
public class TrazadoService {

    @Autowired
    TrazadoRepository oTrazadoRepository;

    public TrazadoEntity get(Long id) {
        return oTrazadoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Trazado no encontrado"));
    }

    public Page<TrazadoEntity> getPage(Pageable oPageable) {
        return oTrazadoRepository.findAll(oPageable);
    }

    public Long create(TrazadoEntity oTrazadoEntity) {
        return oTrazadoRepository.save(oTrazadoEntity).getId();
    }

    public TrazadoEntity update(TrazadoEntity oTrazadoEntity) {
        return oTrazadoRepository.save(oTrazadoEntity);
    }

    public Long delete(Long id) {
        TrazadoEntity oTrazadoEntity = get(id);
        oTrazadoRepository.delete(oTrazadoEntity);
        return id;
    }
}
