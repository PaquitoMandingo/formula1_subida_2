package com.example.formula1;

public class Escuderias {
    String CodigoEscuderia;

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

    public String getOfficeCode() {
        return CodigoEscuderia;
    }

    public String getCity() {
        return Nombre;
    }

    public String getPatrocinador() {
        return Patrocinador;
    }

    public String getAddressLine1() {
        return puntosE;
    }

    public String getAddressLine2() {
        return Web;
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
    }
}