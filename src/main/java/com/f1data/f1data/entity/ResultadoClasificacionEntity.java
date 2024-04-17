package com.f1data.f1data.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "resultado_clasificacion")
public class ResultadoClasificacionEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private Double vuelta_q1;

  private Double vuelta_q2;

  private Double vuelta_q3;

  private int posicion;

  private boolean penalizacion;

  @ManyToOne
  @JoinColumn(name = "piloto_id")
  private PilotoEntity piloto;

  @ManyToOne
  @JoinColumn(name = "clasificacion_id")
  private ClasificacionEntity clasificacion;

  public ResultadoClasificacionEntity() {
    
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Double getVuelta_q1() {
    return vuelta_q1;
  }

  public void setVuelta_q1(Double vuelta_q1) {
    this.vuelta_q1 = vuelta_q1;
  }

  public Double getVuelta_q2() {
    return vuelta_q2;
  }

  public void setVuelta_q2(Double vuelta_q2) {
    this.vuelta_q2 = vuelta_q2;
  }

  public Double getVuelta_q3() {
    return vuelta_q3;
  }

  public void setVuelta_q3(Double vuelta_q3) {
    this.vuelta_q3 = vuelta_q3;
  }

  public int getPosicion() {
    return posicion;
  }

  public void setPosicion(int posicion) {
    this.posicion = posicion;
  }

  public boolean isPenalizacion() {
    return penalizacion;
  }

  public void setPenalizacion(boolean penalizacion) {
    this.penalizacion = penalizacion;
  }

    public PilotoEntity getPiloto() {
    return piloto;
  }

  public void setPiloto(PilotoEntity piloto) {
    this.piloto = piloto;
  }

  public ClasificacionEntity getClasificacion() {
    return clasificacion;
  }

  public void setClasificacion(ClasificacionEntity clasificacion) {
    this.clasificacion = clasificacion;
  }
    
}