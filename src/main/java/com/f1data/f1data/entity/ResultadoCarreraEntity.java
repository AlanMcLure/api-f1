package com.f1data.f1data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "resultado_carrera")
public class ResultadoCarreraEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean vuelta_rapida;

    private int num_vueltas_completadas;

    private Double tiempo_final;

    private int posicion;

    private boolean dnf;

    @ManyToOne
    @JoinColumn(name = "piloto_id")
    private PilotoEntity piloto;

    @ManyToOne
    @JoinColumn(name = "carrera_id")
    private CarreraEntity carrera;

    public ResultadoCarreraEntity() {
    }

    public ResultadoCarreraEntity(Long id, boolean vuelta_rapida, int num_vueltas_completadas, Double tiempo_final,
            int posicion, boolean dnf, PilotoEntity piloto, CarreraEntity carrera) {
        this.id = id;
        this.vuelta_rapida = vuelta_rapida;
        this.num_vueltas_completadas = num_vueltas_completadas;
        this.tiempo_final = tiempo_final;
        this.posicion = posicion;
        this.dnf = dnf;
        this.piloto = piloto;
        this.carrera = carrera;
    }

    public ResultadoCarreraEntity(boolean vuelta_rapida, int num_vueltas_completadas, Double tiempo_final, int posicion,
            boolean dnf, PilotoEntity piloto, CarreraEntity carrera) {
        this.vuelta_rapida = vuelta_rapida;
        this.num_vueltas_completadas = num_vueltas_completadas;
        this.tiempo_final = tiempo_final;
        this.posicion = posicion;
        this.dnf = dnf;
        this.piloto = piloto;
        this.carrera = carrera;
    }

    public ResultadoCarreraEntity(int posicion, PilotoEntity piloto, CarreraEntity carrera) {
        this.posicion = posicion;
        this.piloto = piloto;
        this.carrera = carrera;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isVueltaRapida() {
        return vuelta_rapida;
    }

    public void setVueltaRapida(boolean vuelta_rapida) {
        this.vuelta_rapida = vuelta_rapida;
    }

    public int getNumVueltasCompletadas() {
        return num_vueltas_completadas;
    }

    public void setNumVueltasCompletadas(int num_vueltas_completadas) {
        this.num_vueltas_completadas = num_vueltas_completadas;
    }

    public Double getTiempoFinal() {
        return tiempo_final;
    }

    public void setTiempoFinal(Double tiempo_final) {
        this.tiempo_final = tiempo_final;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public boolean isDnf() {
        return dnf;
    }

    public void setDnf(boolean dnf) {
        this.dnf = dnf;
    }

    public PilotoEntity getPiloto() {
        return piloto;
    }

    public void setPiloto(PilotoEntity piloto) {
        this.piloto = piloto;
    }

    public CarreraEntity getCarrera() {
        return carrera;
    }

    public void setCarrera(CarreraEntity carrera) {
        this.carrera = carrera;
    }
    
}