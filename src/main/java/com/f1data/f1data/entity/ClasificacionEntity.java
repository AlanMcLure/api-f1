package com.f1data.f1data.entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "clasificacion")
public class ClasificacionEntity {
  
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime fecha_inic;

    @ManyToOne
    @JoinColumn(name = "gran_premio_id")
    private GranPremioEntity granPremio;

    public ClasificacionEntity() {
    }

    public ClasificacionEntity(Long id, LocalDateTime fecha_inic, GranPremioEntity granPremio) {
      this.id = id;
      this.fecha_inic = fecha_inic;
      this.granPremio = granPremio;
    }

    public ClasificacionEntity(LocalDateTime fecha_inic, GranPremioEntity granPremio) {
      this.fecha_inic = fecha_inic;
      this.granPremio = granPremio;
    }

    public Long getId() {
      return id;
    }

    public void setId(Long id) {
      this.id = id;
    }

    public LocalDateTime getFechaInic() {
      return fecha_inic;
    }

    public void setFechaInic(LocalDateTime fecha_inic) {
      this.fecha_inic = fecha_inic;
    }

    public GranPremioEntity getGranPremio() {
      return granPremio;
    }

    public void setGranPremio(GranPremioEntity granPremio) {
      this.granPremio = granPremio;
    }

}
