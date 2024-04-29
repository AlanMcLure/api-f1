package com.f1data.f1data.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.f1data.f1data.dto.PilotoDetalles;
import com.f1data.f1data.entity.PilotoEntity;
import com.f1data.f1data.entity.ContratoEntity;
import com.f1data.f1data.exception.ResourceNotFoundException;
import com.f1data.f1data.repository.PilotoRepository;
import com.f1data.f1data.repository.ResultadoCarreraRepository;

@Service
public class PilotoService {

    @Autowired
    private PilotoRepository oPilotoRepository;

    @Autowired
    private ContratoService oContratoRepository;

    @Autowired
    private ResultadoCarreraRepository oResultadoCarreraRepository;

    public PilotoEntity get(Long id) {
        return oPilotoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Piloto no encontrado"));
    }

    public PilotoEntity getByNombre(String nombre) {
        return oPilotoRepository.findByNombre(nombre)
                .orElseThrow(() -> new ResourceNotFoundException("Piloto no encontrado"));
    }

    public Page<PilotoEntity> getPage(Pageable oPageable) {
        return oPilotoRepository.findAll(oPageable);
    }

    public Page<PilotoEntity> getPilotosPorTemporada(int anyo, Pageable oPageable) {
        return oPilotoRepository.findPilotosPorTemporada(anyo, oPageable);
    }

    public Page<PilotoEntity> getByNacionalidad(String nacionalidad, Pageable oPageable) {
        return oPilotoRepository.findByNacionalidadContaining(nacionalidad, oPageable);
    }

    public Page<PilotoEntity> getPilotosGanadores(Pageable oPageable) {
        return oPilotoRepository.findPilotosGanadores(oPageable);
    }

    public Page<PilotoEntity> getPilotosGanadoresPorTemporada(int anyo, Pageable oPageable) {
        return oPilotoRepository.findPilotosGanadoresPorTemporada(anyo, oPageable);
    }

    public Page<PilotoEntity> getPilotosPodio(Pageable oPageable) {
        return oPilotoRepository.findPilotosPodio(oPageable);
    }

    public Page<PilotoEntity> getPilotosPodioPorTemporada(int anyo, Pageable oPageable) {
        return oPilotoRepository.findPilotosPodioPorTemporada(anyo, oPageable);
    }

    public Page<PilotoEntity> getPilotosPorEdad(int edad, Pageable oPageable) {
        return oPilotoRepository.findPilotosPorEdad(edad, oPageable);
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

    // Consultas para un piloto específico
    public PilotoDetalles obtenerDetallesPiloto(Long idPiloto) {
        PilotoEntity piloto = oPilotoRepository.findById(idPiloto)
                .orElseThrow(() -> new ResourceNotFoundException("Piloto no encontrado"));

        Integer victorias = oResultadoCarreraRepository.cuentaVictoriasPorPiloto(idPiloto);
        Integer podios = oResultadoCarreraRepository.cuentaPodiosPorPiloto(idPiloto);
        Integer carrerasDisputadas = oResultadoCarreraRepository.cuentaCarrerasDisputadasPorPiloto(idPiloto);
        Integer vueltasRapidas = oResultadoCarreraRepository.cuentaVueltasRapidasPorPiloto(idPiloto);
        Integer abandonos = oResultadoCarreraRepository.cuentaAbandonosPorPiloto(idPiloto);
        Integer mejorPosicionCarrera = oResultadoCarreraRepository.mejorPosicionCarreraPorPiloto(idPiloto);
        Integer vecesMejorPosicionCarrera = oResultadoCarreraRepository.cuentaVecesMejorPosicionCarrera(idPiloto);
        Integer puntos = oResultadoCarreraRepository.sumaPuntosPorPiloto(idPiloto);
        // List<ContratoEntity> historialEquipos =
        // oContratoRepository.obtenerHistorialEquipos(idPiloto);

        PilotoDetalles detalles = new PilotoDetalles();
        detalles.setPiloto(piloto);
        detalles.setVictorias(victorias != null ? victorias : 0);
        detalles.setPodios(podios != null ? podios : 0);
        detalles.setCarrerasDisputadas(carrerasDisputadas != null ? carrerasDisputadas : 0);
        detalles.setVueltasRapidas(vueltasRapidas != null ? vueltasRapidas : 0);
        detalles.setAbandonos(abandonos != null ? abandonos : 0);
        detalles.setMejorPosicionCarrera(mejorPosicionCarrera != null ? mejorPosicionCarrera : 0);
        detalles.setVecesMejorPosicionCarrera(vecesMejorPosicionCarrera != null ? vecesMejorPosicionCarrera : 0);
        detalles.setPuntosConseguidos(puntos != null ? puntos : 0);
        // detalles.setHistorialEquipos(historialEquipos);

        return detalles;
    }
}
