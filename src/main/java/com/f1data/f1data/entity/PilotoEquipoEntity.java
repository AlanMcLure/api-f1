package com.f1data.f1data.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "piloto_equipo")
public class PilotoEquipoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "piloto_id")
    private PilotoEntity piloto;

    @ManyToOne
    @JoinColumn(name = "equipo_id")
    private EquipoEntity equipo;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private String fecha_inic;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private String fecha_fin;

    public PilotoEquipoEntity() {

    }

    public PilotoEquipoEntity(Long id, PilotoEntity piloto, EquipoEntity equipo, String fecha_inic, String fecha_fin) {
        this.id = id;
        this.piloto = piloto;
        this.equipo = equipo;
        this.fecha_inic = fecha_inic;
        this.fecha_fin = fecha_fin;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PilotoEntity getPiloto() {
        return piloto;
    }

    public void setPiloto(PilotoEntity piloto) {
        this.piloto = piloto;
    }

    public EquipoEntity getEquipo() {
        return equipo;
    }

    public void setEquipo(EquipoEntity equipo) {
        this.equipo = equipo;
    }

    public String getFecha_inic() {
        return fecha_inic;
    }

    public void setFecha_inic(String fecha_inic) {
        this.fecha_inic = fecha_inic;
    }

    public String getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(String fecha_fin) {
        this.fecha_fin = fecha_fin;
    }
}
