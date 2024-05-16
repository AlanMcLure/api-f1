package com.f1data.f1data.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "piloto_equipo", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"piloto_id", "equipo_id", "fecha_inic", "fecha_fin"})
})
public class ContratoEntity {

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
    private Date fecha_inic;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date fecha_fin;

    public ContratoEntity() {

    }

    public ContratoEntity(Long id, PilotoEntity piloto, EquipoEntity equipo, Date fecha_inic, Date fecha_fin) {
        this.id = id;
        this.piloto = piloto;
        this.equipo = equipo;
        this.fecha_inic = fecha_inic;
        this.fecha_fin = fecha_fin;
    }

    public ContratoEntity(PilotoEntity piloto, EquipoEntity equipo, Date fecha_inic, Date fecha_fin) {
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

    public Date getFechaInic() {
        return fecha_inic;
    }

    public void setFechaInic(Date fecha_inic) {
        this.fecha_inic = fecha_inic;
    }

    public Date getFechaFin() {
        return fecha_fin;
    }

    public void setFechaFin(Date fecha_fin) {
        this.fecha_fin = fecha_fin;
    }
    
}
