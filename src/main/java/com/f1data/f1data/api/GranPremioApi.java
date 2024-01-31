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

import com.f1data.f1data.entity.GranPremioEntity;
import com.f1data.f1data.service.GranPremioService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/granpremio")
public class GranPremioApi {

    @Autowired
    GranPremioService oGranPremioService;

    @GetMapping("/{id}")
    public ResponseEntity<GranPremioEntity> get(@PathVariable("id") Long id) {
        return ResponseEntity.ok(oGranPremioService.get(id));
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<GranPremioEntity> getGranPremioByNombre(@PathVariable("nombre") String nombre) {
        return ResponseEntity.ok(oGranPremioService.getGranPremioByNombre(nombre));
    }

    @PostMapping("")
    public ResponseEntity<Long> create(@RequestBody GranPremioEntity oGranPremioEntity) {
        return ResponseEntity.ok(oGranPremioService.create(oGranPremioEntity));
    }

    @PutMapping("")
    public ResponseEntity<GranPremioEntity> update(@RequestBody GranPremioEntity oGranPremioEntity) {
        return ResponseEntity.ok(oGranPremioService.update(oGranPremioEntity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> delete(@PathVariable("id") Long id) {
        return ResponseEntity.ok(oGranPremioService.delete(id));
    }

    @GetMapping("")
    public ResponseEntity<Page<GranPremioEntity>> getGranPremio(Pageable oPageable) {
        return ResponseEntity.ok(oGranPremioService.getPage(oPageable));
    }

    @GetMapping("/anyo/{anyo}")
    public ResponseEntity<Page<GranPremioEntity>> getGranPremioByYear(@PathVariable("anyo") int anyo,
            Pageable oPageable) {
        return ResponseEntity.ok(oGranPremioService.getGranPremioByYear(anyo, oPageable));
    }
}
