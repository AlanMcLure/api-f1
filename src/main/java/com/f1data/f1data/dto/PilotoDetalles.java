package com.f1data.f1data.dto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.f1data.f1data.entity.EquipoEntity;
import com.f1data.f1data.entity.PilotoEntity;
import com.f1data.f1data.entity.PilotoEquipoEntity;

public class PilotoDetalles {
    private PilotoEntity piloto;
    private List<PilotoEquipoEntity> historialEquipos;
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

    public PilotoDetalles() {
    }

    public PilotoDetalles(PilotoEntity piloto, List<PilotoEquipoEntity> historialEquipos, String fechaActual,
            int puntosConseguidos, int victorias, int podios, int carrerasDisputadas,
            int poles, int vueltasRapidas, int abandono, int mejorPosicionCarrera, int vecesMejorPosicionCarrera,
            int mejorPosicionClasificacion, int vecesMejorPosicionClasificacion) {
        this.piloto = piloto;
        this.historialEquipos = historialEquipos;
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

    public PilotoEntity getPiloto() {
        return piloto;
    }

    public void setPiloto(PilotoEntity piloto) {
        this.piloto = piloto;
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

    public List<PilotoEquipoEntity> getHistorialEquipos() {
        return historialEquipos;
    }

    public void setHistorialEquipos(List<PilotoEquipoEntity> historialEquipos) {
        this.historialEquipos = historialEquipos;
    }

    private EquipoEntity obtenerEquipoActual(PilotoEntity piloto, PilotoEquipoEntity[] historialEquipos,
            String fechaActual) {
        // Convertir la cadena de fecha a un objeto Date
        Date fechaActualDate = parseFecha(fechaActual);

        // Iterar por el historial de equipos para encontrar el equipo actual en función
        // de la fecha actual
        for (PilotoEquipoEntity pilotoEquipo : historialEquipos) {
            // Convertir las cadenas de fecha del historial de equipos a objetos Date
            Date fechaInicDate = parseFecha(pilotoEquipo.getFecha_inic());
            Date fechaFinDate = parseFecha(pilotoEquipo.getFecha_fin());

            // Comprobar si la fecha actual está dentro del rango de fechas del historial de
            // equipos
            if (fechaActualDate.after(fechaInicDate) &&
                    (fechaFinDate == null || fechaActualDate.before(fechaFinDate))) {
                return pilotoEquipo.getEquipo();
            }
        }
        return null; // Devolver null si no se encuentra ningún equipo para la fecha actual
    }

    private Date parseFecha(String fecha) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            return dateFormat.parse(fecha);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

}