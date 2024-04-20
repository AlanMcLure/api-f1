package com.f1data.f1data.api;

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

import com.f1data.f1data.entity.ResultadoClasificacionEntity;
import com.f1data.f1data.service.ResultadoClasificacionService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/resultadoclasificacion")
public class ResultadoClasificacionApi {

    @Autowired
    ResultadoClasificacionService oResultadoClasificacionService;

    @GetMapping("/{id}")
    public ResponseEntity<ResultadoClasificacionEntity> get(@PathVariable("id") Long id) {
        return ResponseEntity.ok(oResultadoClasificacionService.get(id));
    }

    @GetMapping("/clasificacion/{idClasificacion}/piloto/{idPiloto}")
    public ResponseEntity<ResultadoClasificacionEntity> getByClasificacionAndPiloto(
            @PathVariable("idClasificacion") Long idClasificacion,
            @PathVariable("idPiloto") Long idPiloto) {
        return ResponseEntity.ok(oResultadoClasificacionService
                .getResultadoClasificacionByClasificacionAndPiloto(idClasificacion, idPiloto));
    }

    @GetMapping("/clasificacion/{idClasificacion}/posicion/{posicion}")
    public ResponseEntity<ResultadoClasificacionEntity> getByClasificacionAndPosicion(
            @PathVariable("idClasificacion") Long idClasificacion,
            @PathVariable("posicion") int posicion) {
        return ResponseEntity.ok(oResultadoClasificacionService
                .getResultadoClasificacionByClasificacionAndPosicion(idClasificacion, posicion));
    }

    @PostMapping("")
    public ResponseEntity<Long> create(@RequestBody ResultadoClasificacionEntity oResultadoClasificacionEntity) {
        return ResponseEntity.ok(oResultadoClasificacionService.create(oResultadoClasificacionEntity));
    }

    @PutMapping("")
    public ResponseEntity<ResultadoClasificacionEntity> update(
            @RequestBody ResultadoClasificacionEntity oResultadoClasificacionEntity) {
        return ResponseEntity.ok(oResultadoClasificacionService.update(oResultadoClasificacionEntity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> delete(@PathVariable("id") Long id) {
        return ResponseEntity.ok(oResultadoClasificacionService.delete(id));
    }

    @GetMapping("")
    public ResponseEntity<Page<ResultadoClasificacionEntity>> getResultadosClasificacion(Pageable oPageable) {
        return ResponseEntity.ok(oResultadoClasificacionService.getPage(oPageable));
    }

    @GetMapping("/clasificacion/{idClasificacion}")
    public ResponseEntity<Page<ResultadoClasificacionEntity>> getResultadosClasificacionByClasificacion(
            @PathVariable("idClasificacion") Long idClasificacion, Pageable oPageable) {
        return ResponseEntity
                .ok(oResultadoClasificacionService.getResultadosClasificacionByClasificacion(idClasificacion,
                        oPageable));
    }

    @GetMapping("/piloto/{idPiloto}")
    public ResponseEntity<Page<ResultadoClasificacionEntity>> getResultadosClasificacionByPiloto(
            @PathVariable("idPiloto") Long idPiloto, Pageable oPageable) {
        return ResponseEntity
                .ok(oResultadoClasificacionService.getResultadosClasificacionByPiloto(idPiloto, oPageable));
    }

    @GetMapping("/anyo/{anyo}")
    public ResponseEntity<Page<ResultadoClasificacionEntity>> getResultadosClasificacionByYear(
            @PathVariable("anyo") int anyo, Pageable oPageable) {
        return ResponseEntity.ok(oResultadoClasificacionService.getResultadosClasificacionByYear(anyo, oPageable));
    }

    @GetMapping("/anyo/{anyo}/piloto/{idPiloto}")
    public ResponseEntity<Page<ResultadoClasificacionEntity>> getResultadosClasificacionByYearAndPiloto(
            @PathVariable("anyo") int anyo, @PathVariable("idPiloto") Long idPiloto, Pageable oPageable) {
        return ResponseEntity
                .ok(oResultadoClasificacionService.getResultadosClasificacionByYearAndPiloto(anyo, idPiloto,
                        oPageable));
    }

}
