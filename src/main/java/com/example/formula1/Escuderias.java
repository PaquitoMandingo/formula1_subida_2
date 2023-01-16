package com.example.formula1;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Escuderias {

    private IntegerProperty codigoEscuderia;
    private StringProperty nombre;
    private IntegerProperty anioCreacion;
    private StringProperty mundialesGanados;
    private StringProperty patrocinador;
    private StringProperty web;
    private IntegerProperty puntosE;
    private IntegerProperty codigoPiloto1;
    private IntegerProperty codigoPiloto2;

    public Escuderias(int codigoEscuderia, String nombre, int anioCreacion, String mundialesGanados, String patrocinador, String web, int puntosE, int codigoPiloto1, int codigoPiloto2) {
        this.codigoEscuderia = new SimpleIntegerProperty(codigoEscuderia);
        this.nombre = new SimpleStringProperty(nombre);
        this.anioCreacion = new SimpleIntegerProperty(anioCreacion);
        this.mundialesGanados = new SimpleStringProperty(mundialesGanados);
        this.patrocinador = new SimpleStringProperty(patrocinador);
        this.web = new SimpleStringProperty(web);
        this.puntosE = new SimpleIntegerProperty(puntosE);
        this.codigoPiloto1 = new SimpleIntegerProperty(codigoPiloto1);
        this.codigoPiloto2 = new SimpleIntegerProperty(codigoPiloto2);
    }

    public Escuderias() {

    }

    public int getCodigoEscuderia() {
        return codigoEscuderia.get();
    }

    public IntegerProperty codigoEscuderiaProperty() {
        return codigoEscuderia;
    }

    public void setCodigoEscuderia(int codigoEscuderia) {
        this.codigoEscuderia.set(codigoEscuderia);
    }

    public String getNombre() {
        return nombre.get();
    }

    public StringProperty nombreProperty() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre.set(nombre);
    }

    public int getAnioCreacion() {
        return anioCreacion.get();
    }

    public IntegerProperty anioCreacionProperty() {
        return anioCreacion;
    }

    public void setAnioCreacion(int anioCreacion) {
        this.anioCreacion.set(anioCreacion);
    }

    public String getMundialesGanados() {
        return mundialesGanados.get();
    }

    public StringProperty mundialesGanadosProperty() {
        return mundialesGanados;
    }

    public void setMundialesGanados(String mundialesGanados) {
        this.mundialesGanados.set(mundialesGanados);
    }

    public String getPatrocinador() {
        return patrocinador.get();
    }

    public StringProperty patrocinadorProperty() {
        return patrocinador;
    }

    public void setPatrocinador(String patrocinador) {
        this.patrocinador.set(patrocinador);
    }

    public String getWeb() {
        return web.get();
    }

    public StringProperty webProperty() {
        return web;
    }

    public void setWeb(String web) {
        this.web.set(web);
    }

    public int getPuntosE() {
        return puntosE.get();
    }

    public IntegerProperty puntosEProperty() {
        return puntosE;
    }

    public void setPuntosE(int puntosE) {
        this.puntosE.set(puntosE);
    }

    public int getCodigoPiloto1() {
        return codigoPiloto1.get();
    }

    public IntegerProperty codigoPiloto1Property() {
        return codigoPiloto1;
    }

    public void setCodigoPiloto1(int codigoPiloto1) {
        this.codigoPiloto1.set(codigoPiloto1);
    }

    public int getCodigoPiloto2() {
        return codigoPiloto2.get();
    }

    public IntegerProperty codigoPiloto2Property() {
        return codigoPiloto2;
    }

    public void setCodigoPiloto2(int codigoPiloto2) {
        this.codigoPiloto2.set(codigoPiloto2);
    }

    @Override
    public String toString() {
        return "Escuderias{" +
                "codigoEscuderia=" + codigoEscuderia +
                ", nombre=" + nombre +
                ", anioCreacion=" + anioCreacion +
                ", mundialesGanados=" + mundialesGanados +
                ", patrocinador=" + patrocinador +
                ", web=" + web +
                ", puntosE=" + puntosE +
                ", codigoPiloto1=" + codigoPiloto1 +
                ", codigoPiloto2=" + codigoPiloto2 +
                '}';
    }
}