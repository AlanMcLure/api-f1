package com.f1data.f1data.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.f1data.f1data.entity.ClasificacionEntity;
import com.f1data.f1data.service.ClasificacionService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/clasificaion")
public class ClasificacionApi {
  
  @Autowired
  ClasificacionService oClasificacionService;

  @GetMapping("/{id}")
  public ResponseEntity<ClasificacionEntity> get(@PathVariable("id") Long id) {
    return ResponseEntity.ok(oClasificacionService.get(id));
  }

  @PostMapping("")
  public ResponseEntity<Long> create(@RequestBody ClasificacionEntity oClasificacionEntity) {
    return ResponseEntity.ok(oClasificacionService.create(oClasificacionEntity));
  }

  @PutMapping("")
  public ResponseEntity<ClasificacionEntity> update(@RequestBody ClasificacionEntity oClasificacionEntity) {
    return ResponseEntity.ok(oClasificacionService.update(oClasificacionEntity));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Long> delete(@PathVariable("id") Long id) {
    return ResponseEntity.ok(oClasificacionService.delete(id));
  }

  @GetMapping("")
  public ResponseEntity<Page<ClasificacionEntity>> getClasificacion(Pageable oPageable) {
    return ResponseEntity.ok(oClasificacionService.getPage(oPageable));
  }
}
