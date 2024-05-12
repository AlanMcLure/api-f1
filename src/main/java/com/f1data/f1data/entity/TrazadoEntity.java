package com.f1data.f1data.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "trazado")
public class TrazadoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "num_metros")
    private Integer numMetros;

    @Column(name = "img")
    private String img;

    @Column(name = "fecha_inic")
    private Date fechaInic;

    @Column(name = "fecha_fin")
    private Date fechaFin;

    @ManyToOne
    @JoinColumn(name = "circuito_id")
    private CircuitoEntity circuito;

    public TrazadoEntity() {
    }

    public TrazadoEntity(Integer numMetros, String img, Date fechaInic, Date fechaFin,
            CircuitoEntity circuito) {
        this.numMetros = numMetros;
        this.img = img;
        this.fechaInic = fechaInic;
        this.fechaFin = fechaFin;
        this.circuito = circuito;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumMetros() {
        return numMetros;
    }

    public void setNumMetros(Integer numMetros) {
        this.numMetros = numMetros;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Date getFechaInic() {
        return fechaInic;
    }

    public void setFechaInic(Date fechaInic) {
        this.fechaInic = fechaInic;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public CircuitoEntity getCircuito() {
        return circuito;
    }

    public void setCircuito(CircuitoEntity circuito) {
        this.circuito = circuito;
    }

}
