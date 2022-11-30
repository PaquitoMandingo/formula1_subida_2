package com.example.formula1;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

import java.math.BigDecimal;
import java.sql.Date;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.time.Year;

public class Pilotos {

    private IntegerProperty codigoPiloto;

    private StringProperty Nombre;

    private StringProperty Apellidos;

    private StringProperty Nacionalidad;

    private IntegerProperty CodigoEscuderiaPiloto;

    private DecimalFormat Estatura;

    private FloatProperty Peso;

    private IntegerProperty dorsal;

    private DateFormat fechaNacimiento;

    private IntegerProperty CampeonatosMundiales;

    private StringProperty primeraVictoria;

    private IntegerProperty Puntos;

    public Pilotos(IntegerProperty codigoPiloto, StringProperty nombre, StringProperty apellidos, StringProperty nacionalidad, IntegerProperty codigoEscuderiaPiloto, DecimalFormat estatura, FloatProperty peso, IntegerProperty dorsal, DateFormat fechaNacimiento, IntegerProperty campeonatosMundiales, StringProperty primeraVictoria, IntegerProperty puntos) {
        this.codigoPiloto = codigoPiloto;
        Nombre = nombre;
        Apellidos = apellidos;
        Nacionalidad = nacionalidad;
        CodigoEscuderiaPiloto = codigoEscuderiaPiloto;
        Estatura = estatura;
        Peso = peso;
        this.dorsal = dorsal;
        this.fechaNacimiento = fechaNacimiento;
        CampeonatosMundiales = campeonatosMundiales;
        this.primeraVictoria = primeraVictoria;
        Puntos = puntos;
    }

    public Pilotos(int codigoPiloto, String nombre, String apellidos, String nacionalidad, int codigoEscuderiaPiloto, BigDecimal estatura, float peso, int dorsal, Date fechaNacimiento, int campeonatosMundiales, String primeraVictoria, int puntos) {
    }

    public int getCodigoPiloto() {
        return codigoPiloto.get();
    }

    public IntegerProperty codigoPilotoProperty() {
        return codigoPiloto;
    }

    public void setCodigoPiloto(int codigoPiloto) {
        this.codigoPiloto.set(codigoPiloto);
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

    public String getApellidos() {
        return Apellidos.get();
    }

    public StringProperty apellidosProperty() {
        return Apellidos;
    }

    public void setApellidos(String apellidos) {
        this.Apellidos.set(apellidos);
    }

    public String getNacionalidad() {
        return Nacionalidad.get();
    }

    public StringProperty nacionalidadProperty() {
        return Nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.Nacionalidad.set(nacionalidad);
    }

    public int getCodigoEscuderiaPiloto() {
        return CodigoEscuderiaPiloto.get();
    }

    public IntegerProperty codigoEscuderiaPilotoProperty() {
        return CodigoEscuderiaPiloto;
    }

    public void setCodigoEscuderiaPiloto(int codigoEscuderiaPiloto) {
        this.CodigoEscuderiaPiloto.set(codigoEscuderiaPiloto);
    }

    public DecimalFormat getEstatura() {
        return Estatura;
    }

    public void setEstatura(DecimalFormat estatura) {
        Estatura = estatura;
    }

    public float getPeso() {
        return Peso.get();
    }

    public FloatProperty pesoProperty() {
        return Peso;
    }

    public void setPeso(float peso) {
        this.Peso.set(peso);
    }

    public int getDorsal() {
        return dorsal.get();
    }

    public IntegerProperty dorsalProperty() {
        return dorsal;
    }

    public void setDorsal(int dorsal) {
        this.dorsal.set(dorsal);
    }

    public DateFormat getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(DateFormat fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getCampeonatosMundiales() {
        return CampeonatosMundiales.get();
    }

    public IntegerProperty campeonatosMundialesProperty() {
        return CampeonatosMundiales;
    }

    public void setCampeonatosMundiales(int campeonatosMundiales) {
        this.CampeonatosMundiales.set(campeonatosMundiales);
    }

    public String getPrimeraVictoria() {
        return primeraVictoria.get();
    }

    public StringProperty primeraVictoriaProperty() {
        return primeraVictoria;
    }

    public void setPrimeraVictoria(String primeraVictoria) {
        this.primeraVictoria.set(primeraVictoria);
    }

    public int getPuntos() {
        return Puntos.get();
    }

    public IntegerProperty puntosProperty() {
        return Puntos;
    }

    public void setPuntos(int puntos) {
        this.Puntos.set(puntos);
    }
}
