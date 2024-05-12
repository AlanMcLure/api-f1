package com.f1data.f1data.dto;

import java.util.List;

import com.f1data.f1data.entity.EquipoEntity;
import com.f1data.f1data.entity.PilotoEntity;

public class EquipoDetalles {

    private EquipoEntity equipo;
    private List<PilotoEntity> pilotosActuales;
    private int puntosConseguidos;
    private int victorias;
    private int podios;
    private int carrerasDisputadas;
    private int poles;
    private int vueltasRapidas;
    private int abandono;
    private int mejorPosicionCarrera;
    private int vecesMejorPosicionCarrera;
    private int mejorPosicionClasificacion;
    private int vecesMejorPosicionClasificacion;

    public EquipoDetalles() {
    }

    public EquipoDetalles(EquipoEntity equipo, int puntosConseguidos, int victorias, int podios, int carrerasDisputadas,
            int poles, int vueltasRapidas, int abandono, int mejorPosicionCarrera, int vecesMejorPosicionCarrera,
            int mejorPosicionClasificacion, int vecesMejorPosicionClasificacion) {
        this.equipo = equipo;
        this.puntosConseguidos = puntosConseguidos;
        this.victorias = victorias;
        this.podios = podios;
        this.carrerasDisputadas = carrerasDisputadas;
        this.poles = poles;
        this.vueltasRapidas = vueltasRapidas;
        this.abandono = abandono;
        this.mejorPosicionCarrera = mejorPosicionCarrera;
        this.vecesMejorPosicionCarrera = vecesMejorPosicionCarrera;
        this.mejorPosicionClasificacion = mejorPosicionClasificacion;
        this.vecesMejorPosicionClasificacion = vecesMejorPosicionClasificacion;
    }

    public EquipoEntity getEquipo() {
        return equipo;
    }

    public void setEquipo(EquipoEntity equipo) {
        this.equipo = equipo;
    }

    public int getPuntosConseguidos() {
        return puntosConseguidos;
    }

    public void setPuntosConseguidos(int puntosConseguidos) {
        this.puntosConseguidos = puntosConseguidos;
    }

    public int getVictorias() {
        return victorias;
    }

    public void setVictorias(int victorias) {
        this.victorias = victorias;
    }

    public int getPodios() {
        return podios;
    }

    public void setPodios(int podios) {
        this.podios = podios;
    }

    public int getCarrerasDisputadas() {
        return carrerasDisputadas;
    }

    public void setCarrerasDisputadas(int carrerasDisputadas) {
        this.carrerasDisputadas = carrerasDisputadas;
    }

    public int getPoles() {
        return poles;
    }

    public void setPoles(int poles) {
        this.poles = poles;
    }

    public int getVueltasRapidas() {
        return vueltasRapidas;
    }

    public void setVueltasRapidas(int vueltasRapidas) {
        this.vueltasRapidas = vueltasRapidas;
    }

    public int getAbandonos() {
        return abandono;
    }

    public void setAbandonos(int abandono) {
        this.abandono = abandono;
    }

    public int getMejorPosicionCarrera() {
        return mejorPosicionCarrera;
    }

    public void setMejorPosicionCarrera(int mejorPosicionCarrera) {
        this.mejorPosicionCarrera = mejorPosicionCarrera;
    }

    public int getVecesMejorPosicionCarrera() {
        return vecesMejorPosicionCarrera;
    }

    public void setVecesMejorPosicionCarrera(int vecesMejorPosicionCarrera) {
        this.vecesMejorPosicionCarrera = vecesMejorPosicionCarrera;
    }

    public int getMejorPosicionClasificacion() {
        return mejorPosicionClasificacion;
    }

    public void setMejorPosicionClasificacion(int mejorPosicionClasificacion) {
        this.mejorPosicionClasificacion = mejorPosicionClasificacion;
    }

    public int getVecesMejorPosicionClasificacion() {
        return vecesMejorPosicionClasificacion;
    }

    public void setVecesMejorPosicionClasificacion(int vecesMejorPosicionClasificacion) {
        this.vecesMejorPosicionClasificacion = vecesMejorPosicionClasificacion;
    }

}
