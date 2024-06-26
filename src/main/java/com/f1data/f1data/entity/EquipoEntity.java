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
@Table(name = "equipo")
public class EquipoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date fecha_inic;

    private String nacionalidad;

    private String img;

    public EquipoEntity() {

    }

    public EquipoEntity(Long id, String nombre, Date fecha_inic, String nacionalidad, String img) {
        this.id = id;
        this.nombre = nombre;
        this.fecha_inic = fecha_inic;
        this.nacionalidad = nacionalidad;
        this.img = img;
    }

    public EquipoEntity(String nombre, Date fecha_inic, String nacionalidad, String img) {
        this.nombre = nombre;
        this.fecha_inic = fecha_inic;
        this.nacionalidad = nacionalidad;
        this.img = img;
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

}
