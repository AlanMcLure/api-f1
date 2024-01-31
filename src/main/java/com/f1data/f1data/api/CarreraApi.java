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

import com.f1data.f1data.entity.CarreraEntity;
import com.f1data.f1data.service.CarreraService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/carrera")
public class CarreraApi {

    @Autowired
    CarreraService oCarreraService;

    @GetMapping("/{id}")
    public ResponseEntity<CarreraEntity> get(@PathVariable("id") Long id) {
        return ResponseEntity.ok(oCarreraService.get(id));
    }

    @PostMapping("")
    public ResponseEntity<Long> create(@RequestBody CarreraEntity oCarreraEntity) {
        return ResponseEntity.ok(oCarreraService.create(oCarreraEntity));
    }

    @PutMapping("")
    public ResponseEntity<CarreraEntity> update(@RequestBody CarreraEntity oCarreraEntity) {
        return ResponseEntity.ok(oCarreraService.update(oCarreraEntity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> delete(@PathVariable("id") Long id) {
        return ResponseEntity.ok(oCarreraService.delete(id));
    }

    @GetMapping("")
    public ResponseEntity<Page<CarreraEntity>> getCarrera(Pageable oPageable) {
        return ResponseEntity.ok(oCarreraService.getPage(oPageable));
    }

    @GetMapping("/vueltas/{vueltas}")
    public ResponseEntity<Page<CarreraEntity>> getCarreraByVueltas(@PathVariable("vueltas") int vueltas,
            Pageable oPageable) {
        return ResponseEntity.ok(oCarreraService.getCarreraByVueltas(vueltas, oPageable));
    }

}
