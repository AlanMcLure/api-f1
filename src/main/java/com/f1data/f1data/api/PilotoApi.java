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

import com.f1data.f1data.entity.PilotoEntity;
import com.f1data.f1data.service.PilotoService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/piloto")
public class PilotoApi {

    @Autowired
    PilotoService oPilotoService;

    @GetMapping("/{id}")
    public ResponseEntity<PilotoEntity> get(@PathVariable("id") Long id) {
        return ResponseEntity.ok(oPilotoService.get(id));
    }

    @PostMapping("")
    public ResponseEntity<Long> create(@RequestBody PilotoEntity oPilotoEntity) {
        return ResponseEntity.ok(oPilotoService.create(oPilotoEntity));
    }

    @PutMapping("")
    public ResponseEntity<PilotoEntity> update(@RequestBody PilotoEntity oPilotoEntity) {
        return ResponseEntity.ok(oPilotoService.update(oPilotoEntity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> delete(@PathVariable("id") Long id) {
        return ResponseEntity.ok(oPilotoService.delete(id));
    }

    @GetMapping("")
    public ResponseEntity<Page<PilotoEntity>> getPage(Pageable oPageable) {
        return ResponseEntity.ok(oPilotoService.getPage(oPageable));
    }

}
