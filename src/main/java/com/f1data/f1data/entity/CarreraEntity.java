package com.f1data.f1data.entity;

import java.time.LocalDateTime;

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
    
    private int num_vueltas;

    private LocalDateTime fecha_inic;

    private boolean safety;

    @ManyToOne
    @JoinColumn(name = "gran_premio_id")
    private GranPremioEntity granPremio;

    public CarreraEntity() {
    }

    public CarreraEntity(Long id, int num_vueltas, LocalDateTime fecha_inic, boolean safety, GranPremioEntity granPremio) {
        this.id = id;
        this.num_vueltas = num_vueltas;
        this.fecha_inic = fecha_inic;
        this.safety = safety;
        this.granPremio = granPremio;
    }

    public CarreraEntity(int num_vueltas, LocalDateTime fecha_inic, boolean safety, GranPremioEntity granPremio) {
        this.num_vueltas = num_vueltas;
        this.fecha_inic = fecha_inic;
        this.safety = safety;
        this.granPremio = granPremio;
    }

    public CarreraEntity(int num_vueltas, LocalDateTime fecha_inic, boolean safety) {
        this.num_vueltas = num_vueltas;
        this.fecha_inic = fecha_inic;
        this.safety = safety;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNum_vueltas() {
        return num_vueltas;
    }

    public void setNum_vueltas(int num_vueltas) {
        this.num_vueltas = num_vueltas;
    }

    public LocalDateTime getFecha_inic() {
        return fecha_inic;
    }

    public void setFecha_inic(LocalDateTime fecha_inic) {
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