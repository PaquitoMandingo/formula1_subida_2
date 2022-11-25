package com.example.formula1;

import javafx.beans.property.StringProperty;

public class Escuderias {
    private  StringProperty CodigoEscuderia;
    private  StringProperty Nombre;
    private  StringProperty Patrocinador;
    private  StringProperty puntosE;
    private  StringProperty Web;

    private  StringProperty AnioCreacion;

    private  StringProperty MundialesGanados;

    private  StringProperty CodigoPiloto1;

    private  StringProperty CodigoPiloto2;




    //String CodigoEscuderia;

    @Override
    public String toString() {
        return "Escuderia{" +
                "CodigoEscuderia='" + CodigoEscuderia + '\'' +
                ", Nombre='" + Nombre + '\'' +
                ", Patrocinador='" + Patrocinador + '\'' +
                ", puntose='" + puntosE + '\'' +
                ", Web='" + Web + '\'' +
                '}';
    }

    public String getCodigoEscuderia() {
        return CodigoEscuderia.get();
    }

    public StringProperty codigoEscuderiaProperty() {
        return CodigoEscuderia;
    }

    public void setCodigoEscuderia(String codigoEscuderia) {
        this.CodigoEscuderia.set(codigoEscuderia);
    }

    public String getNombre() {
        return Nombre.get();
    }

    public StringProperty nombreProperty() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        this.Nombre.set(nombre);
    }

    public String getPatrocinador() {
        return Patrocinador.get();
    }

    public StringProperty patrocinadorProperty() {
        return Patrocinador;
    }

    public void setPatrocinador(String patrocinador) {
        this.Patrocinador.set(patrocinador);
    }

    public String getPuntosE() {
        return puntosE.get();
    }

    public StringProperty puntosEProperty() {
        return puntosE;
    }

    public void setPuntosE(String puntosE) {
        this.puntosE.set(puntosE);
    }

    public String getWeb() {
        return Web.get();
    }

    public StringProperty webProperty() {
        return Web;
    }

    public void setWeb(String web) {
        this.Web.set(web);
    }

    public String getAnioCreacion() {
        return AnioCreacion.get();
    }

    public StringProperty anioCreacionProperty() {
        return AnioCreacion;
    }

    public void setAnioCreacion(String anioCreacion) {
        this.AnioCreacion.set(anioCreacion);
    }

    public String getMundialesGanados() {
        return MundialesGanados.get();
    }

    public StringProperty mundialesGanadosProperty() {
        return MundialesGanados;
    }

    public void setMundialesGanados(String mundialesGanados) {
        this.MundialesGanados.set(mundialesGanados);
    }

    public String getCodigoPiloto1() {
        return CodigoPiloto1.get();
    }

    public StringProperty codigoPiloto1Property() {
        return CodigoPiloto1;
    }

    public void setCodigoPiloto1(String codigoPiloto1) {
        this.CodigoPiloto1.set(codigoPiloto1);
    }

    public String getCodigoPiloto2() {
        return CodigoPiloto2.get();
    }

    public StringProperty codigoPiloto2Property() {
        return CodigoPiloto2;
    }

    public void setCodigoPiloto2(String codigoPiloto2) {
        this.CodigoPiloto2.set(codigoPiloto2);
    }

    public Escuderias(StringProperty codigoEscuderia, StringProperty nombre, StringProperty patrocinador, StringProperty puntosE, StringProperty web, StringProperty anioCreacion, StringProperty mundialesGanados, StringProperty codigoPiloto1, StringProperty codigoPiloto2) {
        CodigoEscuderia = codigoEscuderia;
        Nombre = nombre;
        Patrocinador = patrocinador;
        this.puntosE = puntosE;
        Web = web;
        AnioCreacion = anioCreacion;
        MundialesGanados = mundialesGanados;
        CodigoPiloto1 = codigoPiloto1;
        CodigoPiloto2 = codigoPiloto2;
    }

    /*
    public void setOfficeCode(String officeCode) {
        this.CodigoEscuderia = CodigoEscuderia;
    }

    public void setCity(String city) {
        this.Nombre = Nombre;
    }

    public void setPatrocinador(String patrocinador) {
        this.Patrocinador = patrocinador;
    }

    public void setAddressLine1(String puntosE) {
        this.puntosE = puntosE;
    }

    public void setAddressLine2(String Web) {
        this.puntosE = Web;
    }
    

    String Nombre;
    String Patrocinador;
    String puntosE;
    String Web;

    public Escuderias(String CodigoEscuderia, String Nombre, String Patrocinador, String puntosE, String Web) {
        this.CodigoEscuderia = CodigoEscuderia;
        this.Nombre = Nombre;
        this.Patrocinador = Patrocinador;
        this.puntosE = puntosE;
        this.Web = Web;
    }*/
}