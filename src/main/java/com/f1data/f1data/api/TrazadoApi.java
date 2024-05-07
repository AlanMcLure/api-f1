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

import com.f1data.f1data.entity.TrazadoEntity;
import com.f1data.f1data.service.TrazadoService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/trazado")
public class TrazadoApi {

    @Autowired
    TrazadoService oTrazadoService;

    @GetMapping("/{id}")
    public ResponseEntity<TrazadoEntity> get(@PathVariable("id") Long id) {
        return ResponseEntity.ok(oTrazadoService.get(id));
    }

    @PostMapping("")
    public ResponseEntity<Long> create(@RequestBody TrazadoEntity oTrazadoEntity) {
        return ResponseEntity.ok(oTrazadoService.create(oTrazadoEntity));
    }

    @PutMapping("")
    public ResponseEntity<TrazadoEntity> update(
            @RequestBody TrazadoEntity oTrazadoEntity) {
        return ResponseEntity.ok(oTrazadoService.update(oTrazadoEntity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> delete(@PathVariable("id") Long id) {
        return ResponseEntity.ok(oTrazadoService.delete(id));
    }

    @GetMapping("")
    public ResponseEntity<Page<TrazadoEntity>> getResultadosClasificacion(Pageable oPageable) {
        return ResponseEntity.ok(oTrazadoService.getPage(oPageable));
    }

}
