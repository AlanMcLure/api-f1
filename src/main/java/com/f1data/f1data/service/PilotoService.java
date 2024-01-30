package com.f1data.f1data.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.f1data.f1data.entity.PilotoEntity;
import com.f1data.f1data.exception.ResourceNotFoundException;
import com.f1data.f1data.repository.PilotoRepository;

@Service
public class PilotoService {

    @Autowired
    private PilotoRepository oPilotoRepository;

    public PilotoEntity get(Long id) {
        return oPilotoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Piloto no encontrado"));
    }

    public Page<PilotoEntity> getPage(Pageable oPageable) {
        return oPilotoRepository.findAll(oPageable);
    }

    public Long create(PilotoEntity oPilotoEntity) {
        return oPilotoRepository.save(oPilotoEntity).getId();
    }

    public PilotoEntity update(PilotoEntity oPilotoEntity) {
        PilotoEntity oPilotoEntityBD = get(oPilotoEntity.getId());
        oPilotoEntityBD.setNombre(oPilotoEntity.getNombre());
        oPilotoEntityBD.setFecha_nac(oPilotoEntity.getFecha_nac());
        oPilotoEntityBD.setNacionalidad(oPilotoEntity.getNacionalidad());
        oPilotoEntityBD.setImg(oPilotoEntity.getImg());
        return oPilotoRepository.save(oPilotoEntityBD);
    }

    public Long delete(Long id) {
        PilotoEntity oPilotoEntityBD = get(id);
        oPilotoRepository.delete(oPilotoEntityBD);
        return id;
    }
}
