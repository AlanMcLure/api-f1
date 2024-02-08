package com.f1data.f1data.api;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

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

import com.f1data.f1data.dto.PilotoDetalles;
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

    @GetMapping("/{id}/detalles")
    public ResponseEntity<PilotoDetalles> obtenerDetallesPiloto(@PathVariable Long id) {
        PilotoDetalles detalles = oPilotoService.obtenerDetallesPiloto(id);
        return new ResponseEntity<>(detalles, HttpStatus.OK);
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<PilotoEntity> getByNombre(@PathVariable("nombre") String nombre) {
        return ResponseEntity.ok(oPilotoService.getByNombre(nombre));
    }
    /*
     * @GetMapping("/nombre/{nombre}")
     * public ResponseEntity<PilotoEntity> getByNombre(@PathVariable("nombre")
     * String nombre) {
     * try {
     * String nombreDecodificado = URLDecoder.decode(nombre, "UTF-8");
     * return ResponseEntity.ok(oPilotoService.getByNombre(nombreDecodificado));
     * } catch (UnsupportedEncodingException e) {
     * // Manejar la excepción de codificación no compatible
     * // Puedes imprimir un mensaje de error o realizar alguna otra acción
     * apropiada
     * e.printStackTrace();
     * return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
     * }
     * }
     */

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
    public ResponseEntity<Page<PilotoEntity>> getPage(@RequestParam(required = false) Integer temporada,
            Pageable oPageable) {
        if (temporada != null) {
            return ResponseEntity.ok(oPilotoService.getPilotosPorTemporada(temporada, oPageable));
        } else {
            return ResponseEntity.ok(oPilotoService.getPage(oPageable));
        }
    }

    @GetMapping("/nacionalidad/{nacionalidad}")
    public ResponseEntity<Page<PilotoEntity>> getByNacionalidad(@PathVariable("nacionalidad") String nacionalidad,
            Pageable oPageable) {
        return ResponseEntity.ok(oPilotoService.getByNacionalidad(nacionalidad, oPageable));
    }

    @GetMapping("/ganadores")
    public ResponseEntity<Page<PilotoEntity>> getPilotosGanadores(@RequestParam(required = false) Integer temporada,
            Pageable oPageable) {
        if (temporada != null) {
            return ResponseEntity.ok(oPilotoService.getPilotosGanadoresPorTemporada(temporada, oPageable));
        } else {
            return ResponseEntity.ok(oPilotoService.getPilotosGanadores(oPageable));
        }
    }

    @GetMapping("/podio")
    public ResponseEntity<Page<PilotoEntity>> getPilotosPodio(@RequestParam(required = false) Integer temporada,
            Pageable oPageable) {
        if (temporada != null) {
            return ResponseEntity.ok(oPilotoService.getPilotosPodioPorTemporada(temporada, oPageable));
        } else {
            return ResponseEntity.ok(oPilotoService.getPilotosPodio(oPageable));
        }
    }

    @GetMapping("/temporada/{anyo}")
    public ResponseEntity<Page<PilotoEntity>> getPilotosPorTemporada(@PathVariable("anyo") int anyo,
            Pageable oPageable) {
        return ResponseEntity.ok(oPilotoService.getPilotosPorTemporada(anyo, oPageable));
    }

    @GetMapping("/edad/{edad}")
    public ResponseEntity<Page<PilotoEntity>> getPilotosPorEdad(@PathVariable("edad") int edad, Pageable oPageable) {
        return ResponseEntity.ok(oPilotoService.getPilotosPorEdad(edad, oPageable));
    }

}
