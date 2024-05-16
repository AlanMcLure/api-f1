package com.f1data.f1data.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "piloto")
public class PilotoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false) 
    private String nombre;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date fecha_nac;

    private String nacionalidad;

    private String img;

    private String img_flag;

    private String lugar_nac;

    private String casco;

    public PilotoEntity() {
    }

    public PilotoEntity(Long id, String nombre, Date fecha_nac, String nacionalidad, String img, String img_flag,
            String lugar_nac, String casco) {
        this.id = id;
        this.nombre = nombre;
        this.fecha_nac = fecha_nac;
        this.nacionalidad = nacionalidad;
        this.img = img;
        this.img_flag = img_flag;
        this.lugar_nac = lugar_nac;
        this.casco = casco;
    }

    public PilotoEntity(Long id, String nombre, Date fecha_nac, String nacionalidad, String img, String img_flag,
            String lugar_nac) {
        this.id = id;
        this.nombre = nombre;
        this.fecha_nac = fecha_nac;
        this.nacionalidad = nacionalidad;
        this.img = img;
        this.img_flag = img_flag;
        this.lugar_nac = lugar_nac;
    }

    public PilotoEntity(Long id, String nombre, Date fecha_nac, String nacionalidad, String img) {
        this.id = id;
        this.nombre = nombre;
        this.fecha_nac = fecha_nac;
        this.nacionalidad = nacionalidad;
        this.img = img;
    }

    public PilotoEntity(Long id, String nombre, Date fecha_nac, String nacionalidad) {
        this.id = id;
        this.nombre = nombre;
        this.fecha_nac = fecha_nac;
        this.nacionalidad = nacionalidad;
    }

    public PilotoEntity(String nombre, Date fecha_nac, String nacionalidad, String img) {
        this.nombre = nombre;
        this.fecha_nac = fecha_nac;
        this.nacionalidad = nacionalidad;
        this.img = img;
    }

    public PilotoEntity(String nombre, Date fecha_nac, String nacionalidad) {
        this.nombre = nombre;
        this.fecha_nac = fecha_nac;
        this.nacionalidad = nacionalidad;
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

    public Date getFechaNac() {
        return fecha_nac;
    }

    public void setFechaNac(Date fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getImgFlag() {
        return img_flag;
    }

    public void setImgFlag(String img_flag) {
        this.img_flag = img_flag;
    }

    public String getLugarNac() {
        return lugar_nac;
    }

    public void setLugarNac(String lugar_nac) {
        this.lugar_nac = lugar_nac;
    }

    public String getCasco() {
        return casco;
    }

    public void setCasco(String casco) {
        this.casco = casco;
    }

}
