package com.f1data.f1data.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "gran_premio")
public class GranPremioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false) 
    private String nombre;

    @Column(unique = true)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date fecha_inic;

    @Column(unique = true)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date fecha_fin;

    private String img_flag;

    private String img;

    @ManyToOne
    @JoinColumn(name = "circuito_id")
    private CircuitoEntity circuito;

    public GranPremioEntity() {
    }

    public GranPremioEntity(Long id, String nombre, Date fecha_inic, Date fecha_fin, String img_flag, String img,
            CircuitoEntity circuito) {
        this.id = id;
        this.nombre = nombre;
        this.fecha_inic = fecha_inic;
        this.fecha_fin = fecha_fin;
        this.img_flag = img_flag;
        this.img = img;
        this.circuito = circuito;
    }

    public GranPremioEntity(String nombre, Date fecha_inic, Date fecha_fin, String img_flag, String img,
            CircuitoEntity circuito) {
        this.nombre = nombre;
        this.fecha_inic = fecha_inic;
        this.fecha_fin = fecha_fin;
        this.img_flag = img_flag;
        this.img = img;
        this.circuito = circuito;
    }

    public GranPremioEntity(String nombre, Date fecha_inic, Date fecha_fin, String img_flag, String img) {
        this.nombre = nombre;
        this.fecha_inic = fecha_inic;
        this.fecha_fin = fecha_fin;
        this.img_flag = img_flag;
        this.img = img;
    }

    public GranPremioEntity(String nombre, Date fecha_inic, Date fecha_fin, String img_flag) {
        this.nombre = nombre;
        this.fecha_inic = fecha_inic;
        this.fecha_fin = fecha_fin;
        this.img_flag = img_flag;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public String getImgFlag() {
        return img_flag;
    }

    public void setImgFlag(String img_flag) {
        this.img_flag = img_flag;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public CircuitoEntity getCircuito() {
        return circuito;
    }

    public void setCircuito(CircuitoEntity circuito) {
        this.circuito = circuito;
    }
    
}