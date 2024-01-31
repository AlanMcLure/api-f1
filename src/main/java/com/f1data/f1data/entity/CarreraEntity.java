package com.f1data.f1data.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "carrera")
public class CarreraEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "num_vueltas")
    private int numVueltas;

    private LocalDateTime fecha_inic;

    private boolean safety;

    @ManyToOne
    @JoinColumn(name = "gran_premio_id")
    private GranPremioEntity granPremio;

    public CarreraEntity() {
    }

    public CarreraEntity(Long id, int numVueltas, LocalDateTime fecha_inic, boolean safety,
            GranPremioEntity granPremio) {
        this.id = id;
        this.numVueltas = numVueltas;
        this.fecha_inic = fecha_inic;
        this.safety = safety;
        this.granPremio = granPremio;
    }

    public CarreraEntity(int numVueltas, LocalDateTime fecha_inic, boolean safety, GranPremioEntity granPremio) {
        this.numVueltas = numVueltas;
        this.fecha_inic = fecha_inic;
        this.safety = safety;
        this.granPremio = granPremio;
    }

    public CarreraEntity(int numVueltas, LocalDateTime fecha_inic, boolean safety) {
        this.numVueltas = numVueltas;
        this.fecha_inic = fecha_inic;
        this.safety = safety;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumVueltas() {
        return numVueltas;
    }

    public void setNumVueltas(int numVueltas) {
        this.numVueltas = numVueltas;
    }

    public LocalDateTime getFechaInic() {
        return fecha_inic;
    }

    public void setFechaInic(LocalDateTime fecha_inic) {
        this.fecha_inic = fecha_inic;
    }

    public boolean isSafety() {
        return safety;
    }

    public void setSafety(boolean safety) {
        this.safety = safety;
    }

    public GranPremioEntity getGranPremio() {
        return granPremio;
    }

    public void setGranPremio(GranPremioEntity granPremio) {
        this.granPremio = granPremio;
    }
}