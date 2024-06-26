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
@Table(name = "resultado_clasificacion")
public class ResultadoClasificacionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double vuelta_q1;

    private Double vuelta_q2;

    private Double vuelta_q3;

    private int posicion;

    private int penalizacion;

    @ManyToOne
    @JoinColumn(name = "piloto_id")
    private PilotoEntity piloto;

    @ManyToOne
    @JoinColumn(name = "clasificacion_id")
    private ClasificacionEntity clasificacion;

    public ResultadoClasificacionEntity() {
    }

    public ResultadoClasificacionEntity(Long id, Double vuelta_q1, Double vuelta_q2, Double vuelta_q3, int posicion,
            int penalizacion, PilotoEntity piloto, ClasificacionEntity clasificacion) {
        this.id = id;
        this.vuelta_q1 = vuelta_q1;
        this.vuelta_q2 = vuelta_q2;
        this.vuelta_q3 = vuelta_q3;
        this.posicion = posicion;
        this.penalizacion = penalizacion;
        this.piloto = piloto;
        this.clasificacion = clasificacion;
    }

    public ResultadoClasificacionEntity(Double vuelta_q1, Double vuelta_q2, Double vuelta_q3, int posicion,
            int penalizacion, PilotoEntity piloto, ClasificacionEntity clasificacion) {
        this.vuelta_q1 = vuelta_q1;
        this.vuelta_q2 = vuelta_q2;
        this.vuelta_q3 = vuelta_q3;
        this.posicion = posicion;
        this.penalizacion = penalizacion;
        this.piloto = piloto;
        this.clasificacion = clasificacion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getVueltaQ1() {
        return vuelta_q1;
    }

    public void setVueltaQ1(Double vuelta_q1) {
        this.vuelta_q1 = vuelta_q1;
    }

    public Double getVueltaQ2() {
        return vuelta_q2;
    }

    public void setVueltaQ2(Double vuelta_q2) {
        this.vuelta_q2 = vuelta_q2;
    }

    public Double getVueltaQ3() {
        return vuelta_q3;
    }

    public void setVueltaQ3(Double vuelta_q3) {
        this.vuelta_q3 = vuelta_q3;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public int getPenalizacion() {
        return penalizacion;
    }

    public void setPenalizacion(int penalizacion) {
        this.penalizacion = penalizacion;
    }

    public PilotoEntity getPiloto() {
        return piloto;
    }

    public void setPiloto(PilotoEntity piloto) {
        this.piloto = piloto;
    }

    public ClasificacionEntity getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(ClasificacionEntity clasificacion) {
        this.clasificacion = clasificacion;
    }
    
}
