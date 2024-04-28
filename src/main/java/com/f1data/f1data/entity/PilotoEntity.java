package com.f1data.f1data.entity;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "piloto")
public class PilotoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private String fecha_nac;

    private String nacionalidad;

    private String img;

    private String img_flag;

    private String lugar_nac;

    private String casco;

    @OneToMany(mappedBy = "piloto")
    private Set<ContratoEntity> equipos;

    public PilotoEntity() {
    }

    public PilotoEntity(Long id, String nombre, String fecha_nac, String nacionalidad, String img, String img_flag,
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

    public PilotoEntity(Long id, String nombre, String fecha_nac, String nacionalidad, String img, String img_flag,
            String lugar_nac) {
        this.id = id;
        this.nombre = nombre;
        this.fecha_nac = fecha_nac;
        this.nacionalidad = nacionalidad;
        this.img = img;
        this.img_flag = img_flag;
        this.lugar_nac = lugar_nac;
    }

    public PilotoEntity(Long id, String nombre, String fecha_nac, String nacionalidad, String img) {
        this.id = id;
        this.nombre = nombre;
        this.fecha_nac = fecha_nac;
        this.nacionalidad = nacionalidad;
        this.img = img;
    }

    public PilotoEntity(Long id, String nombre, String fecha_nac, String nacionalidad) {
        this.id = id;
        this.nombre = nombre;
        this.fecha_nac = fecha_nac;
        this.nacionalidad = nacionalidad;
    }

    public PilotoEntity(String nombre, String fecha_nac, String nacionalidad, String img) {
        this.nombre = nombre;
        this.fecha_nac = fecha_nac;
        this.nacionalidad = nacionalidad;
        this.img = img;
    }

    public PilotoEntity(String nombre, String fecha_nac, String nacionalidad) {
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

    public String getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(String fecha_nac) {
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

    public String getImg_flag() {
        return img_flag;
    }

    public void setImg_flag(String img_flag) {
        this.img_flag = img_flag;
    }

    public String getLugar_nac() {
        return lugar_nac;
    }

    public void setLugar_nac(String lugar_nac) {
        this.lugar_nac = lugar_nac;
    }

    public String getCasco() {
        return casco;
    }

    public void setCasco(String casco) {
        this.casco = casco;
    }

    public Set<ContratoEntity> getEquipos() {
        return equipos;
    }

    public void setEquipos(Set<ContratoEntity> equipos) {
        this.equipos = equipos;
    }

}
