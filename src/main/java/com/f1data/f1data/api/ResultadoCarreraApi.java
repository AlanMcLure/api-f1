package com.f1data.f1data.api;

import javax.naming.spi.DirStateFactory.Result;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.f1data.f1data.entity.ResultadoCarreraEntity;
import com.f1data.f1data.service.ResultadoCarreraService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/resultadocarrera")
public class ResultadoCarreraApi {

    @Autowired
    ResultadoCarreraService oResultadoCarreraService;

    @GetMapping("/{id}")
    public ResponseEntity<ResultadoCarreraEntity> get(@PathVariable("id") Long id) {
        return ResponseEntity.ok(oResultadoCarreraService.get(id));
    }

    @GetMapping("/carrera/{idCarrera}/piloto/{idPiloto}")
    public ResponseEntity<ResultadoCarreraEntity> getByCarreraAndPiloto(@PathVariable("idCarrera") Long idCarrera,
            @PathVariable("idPiloto") Long idPiloto) {
        return ResponseEntity.ok(oResultadoCarreraService.getResultadoCarreraByCarreraAndPiloto(idCarrera, idPiloto));
    }

    @GetMapping("/carrera/{idCarrera}/posicion/{posicion}")
    public ResponseEntity<ResultadoCarreraEntity> getByCarreraAndPosicion(@PathVariable("idCarrera") Long idCarrera,
            @PathVariable("posicion") int posicion) {
        return ResponseEntity.ok(oResultadoCarreraService.getResultadoCarreraByCarreraAndPosicion(idCarrera, posicion));
    }

    @PostMapping("")
    public ResponseEntity<Long> create(@RequestBody ResultadoCarreraEntity oResultadoCarreraEntity) {
        return ResponseEntity.ok(oResultadoCarreraService.create(oResultadoCarreraEntity));
    }

    @PutMapping("")
    public ResponseEntity<ResultadoCarreraEntity> update(@RequestBody ResultadoCarreraEntity oResultadoCarreraEntity) {
        return ResponseEntity.ok(oResultadoCarreraService.update(oResultadoCarreraEntity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> delete(@PathVariable("id") Long id) {
        return ResponseEntity.ok(oResultadoCarreraService.delete(id));
    }

    @GetMapping("")
    public ResponseEntity<Page<ResultadoCarreraEntity>> getResultadosCarrera(Pageable oPageable) {
        return ResponseEntity.ok(oResultadoCarreraService.getPage(oPageable));
    }

    @GetMapping("/carrera/{idCarrera}")
    public ResponseEntity<Page<ResultadoCarreraEntity>> getResultadosCarreraByCarrera(
            @PathVariable("idCarrera") Long idCarrera, Pageable oPageable) {
        return ResponseEntity.ok(oResultadoCarreraService.getResultadosCarreraByCarrera(idCarrera, oPageable));
    }

    @GetMapping("/piloto/{idPiloto}")
    public ResponseEntity<Page<ResultadoCarreraEntity>> getResultadosCarreraByPiloto(
            @PathVariable("idPiloto") Long idPiloto, Pageable oPageable) {
        return ResponseEntity.ok(oResultadoCarreraService.getResultadosCarreraByPiloto(idPiloto, oPageable));
    }

    @GetMapping("/anyo/{anyo}")
    public ResponseEntity<Page<ResultadoCarreraEntity>> getResultadosCarreraByYear(@PathVariable("anyo") int anyo,
            Pageable oPageable) {
        return ResponseEntity.ok(oResultadoCarreraService.getResultadosCarreraByYear(anyo, oPageable));
    }

    @GetMapping("/anyo/{anyo}/piloto/{idPiloto}")
    public ResponseEntity<Page<ResultadoCarreraEntity>> getResultadosCarreraByYearAndPiloto(
            @PathVariable("anyo") int anyo, @PathVariable("idPiloto") Long idPiloto, Pageable oPageable) {
        return ResponseEntity
                .ok(oResultadoCarreraService.getResultadosCarreraByYearAndPiloto(anyo, idPiloto, oPageable));
    }

}
