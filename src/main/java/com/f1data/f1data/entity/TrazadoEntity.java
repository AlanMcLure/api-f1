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
@Table(name = "trazado", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"circuito_id", "fecha_inic", "fecha_fin"})
})
public class TrazadoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer num_metros;

    private String img;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date fecha_inic;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date fecha_fin;

    @ManyToOne
    @JoinColumn(name = "circuito_id")
    private CircuitoEntity circuito;

    public TrazadoEntity() {

    }

    public TrazadoEntity(Long id, Integer num_metros, String img, Date fecha_fin, Date fechaFin,
            CircuitoEntity circuito) {
        this.id = id;
        this.num_metros = num_metros;
        this.img = img;
        this.fecha_fin = fecha_fin;
        this.fecha_fin = fecha_fin;
        this.circuito = circuito;
    }

    public TrazadoEntity(Integer num_metros, String img, Date fecha_fin, Date fechaFin,
            CircuitoEntity circuito) {
        this.num_metros = num_metros;
        this.img = img;
        this.fecha_fin = fecha_fin;
        this.fecha_fin = fecha_fin;
        this.circuito = circuito;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumMetros() {
        return num_metros;
    }

    public void setNumMetros(Integer num_metros) {
        this.num_metros = num_metros;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Date getFechaInic() {
        return fecha_fin;
    }

    public void setFechaInic(Date fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public Date getFechaFin() {
        return fecha_fin;
    }

    public void setFechaFin(Date fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public CircuitoEntity getCircuito() {
        return circuito;
    }

    public void setCircuito(CircuitoEntity circuito) {
        this.circuito = circuito;
    }

}
