package com.f1data.f1data.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.f1data.f1data.entity.EquipoEntity;
import com.f1data.f1data.service.EquipoService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/equipo")
public class EquipoApi {

    @Autowired
    EquipoService oEquipoService;

    @GetMapping("/{id}")
    public ResponseEntity<EquipoEntity> get(@PathVariable("id") Long id) {
        return ResponseEntity.ok(oEquipoService.get(id));
    }

    // @GetMapping("/{id}/detalles")
    // public ResponseEntity<EquipoDetalles> obtenerDetallesEquipo(@PathVariable
    // Long id) {
    // EquipoDetalles detalles = oEquipoService.obtenerDetallesEquipo(id);
    // return new ResponseEntity<>(detalles, HttpStatus.OK);
    // }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<EquipoEntity> getByNombre(@PathVariable("nombre") String nombre) {
        return ResponseEntity.ok(oEquipoService.getByNombre(nombre));
    }

    @PostMapping("")
    public ResponseEntity<Long> create(@RequestBody EquipoEntity oEquipoEntity) {
        return ResponseEntity.ok(oEquipoService.create(oEquipoEntity));
    }

    @PutMapping("")
    public ResponseEntity<EquipoEntity> update(@RequestBody EquipoEntity oEquipoEntity) {
        return ResponseEntity.ok(oEquipoService.update(oEquipoEntity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> delete(@PathVariable("id") Long id) {
        return ResponseEntity.ok(oEquipoService.delete(id));
    }

    @GetMapping("")
    public ResponseEntity<Page<EquipoEntity>> getPage(@RequestParam(required = false) Integer temporada,
            Pageable oPageable) {
        if (temporada != null) {
            return ResponseEntity.ok(oEquipoService.getEquiposPorTemporada(temporada, oPageable));
        } else {
            return ResponseEntity.ok(oEquipoService.getPage(oPageable));
        }
    }

    @GetMapping("/pais/{pais}")
    public ResponseEntity<Page<EquipoEntity>> getByPais(@PathVariable("pais") String pais,
            Pageable oPageable) {
        return ResponseEntity.ok(oEquipoService.getByPais(pais, oPageable));
    }

    @GetMapping("/ganadores")
    public ResponseEntity<Page<EquipoEntity>> getEquiposGanadores(@RequestParam(required = false) Integer temporada,
            Pageable oPageable) {
        if (temporada != null) {
            return ResponseEntity.ok(oEquipoService.getEquiposGanadoresPorTemporada(temporada, oPageable));
        } else {
            return ResponseEntity.ok(oEquipoService.getEquiposGanadores(oPageable));
        }
    }

    @GetMapping("/podio")
    public ResponseEntity<Page<EquipoEntity>> getEquiposPodio(@RequestParam(required = false) Integer temporada,
            Pageable oPageable) {
        if (temporada != null) {
            return ResponseEntity.ok(oEquipoService.getEquiposPodioPorTemporada(temporada, oPageable));
        } else {
            return ResponseEntity.ok(oEquipoService.getEquiposPodio(oPageable));
        }
    }

    @GetMapping("/temporada/{anyo}")
    public ResponseEntity<Page<EquipoEntity>> getEquiposPorTemporada(@PathVariable("anyo") int anyo,
            Pageable oPageable) {
        return ResponseEntity.ok(oEquipoService.getEquiposPorTemporada(anyo, oPageable));
    }
}
