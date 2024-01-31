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

import com.f1data.f1data.entity.CircuitoEntity;
import com.f1data.f1data.service.CircuitoService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/circuito")
public class CircuitoApi {
    
    @Autowired CircuitoService oCircuitoService;

    @GetMapping("/{id}")
    public ResponseEntity<CircuitoEntity> get(@PathVariable("id") Long id) {
        return ResponseEntity.ok(oCircuitoService.get(id));
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<CircuitoEntity> getByNombre(@PathVariable("nombre") String nombre) {
        return ResponseEntity.ok(oCircuitoService.getCircuitoByNombre(nombre));
    }

    @PostMapping("")
    public ResponseEntity<Long> create(@RequestBody CircuitoEntity oCircuitoEntity) {
        return ResponseEntity.ok(oCircuitoService.create(oCircuitoEntity));
    }

    @PutMapping("")
    public ResponseEntity<CircuitoEntity> update(@RequestBody CircuitoEntity oCircuitoEntity) {
        return ResponseEntity.ok(oCircuitoService.update(oCircuitoEntity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> delete(@PathVariable("id") Long id) {
        return ResponseEntity.ok(oCircuitoService.delete(id));
    }

    @GetMapping("")
    public ResponseEntity<Page<CircuitoEntity>> getPage(Pageable oPageable) {
        return ResponseEntity.ok(oCircuitoService.getPage(oPageable));
    }

    @GetMapping("/pais/{pais}")
    public ResponseEntity<Page<CircuitoEntity>> getByPais(@PathVariable("pais") String pais, Pageable oPageable) {
        return ResponseEntity.ok(oCircuitoService.getCircuitoByPais(pais, oPageable));
    }

    @GetMapping("/ciudad/{ciudad}")
    public ResponseEntity<Page<CircuitoEntity>> getByCiudad(@PathVariable("ciudad") String ciudad, Pageable oPageable) {
        return ResponseEntity.ok(oCircuitoService.getCircuitoByCiudad(ciudad, oPageable));
    }

    @GetMapping("/region/{region}")
    public ResponseEntity<Page<CircuitoEntity>> getByRegion(@PathVariable("region") String region, Pageable oPageable) {
        return ResponseEntity.ok(oCircuitoService.getCircuitoByRegion(region, oPageable));
    }
}
