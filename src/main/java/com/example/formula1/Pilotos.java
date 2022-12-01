package com.example.formula1;

import javafx.beans.property.*;

import java.math.BigDecimal;
import java.sql.Date;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.Year;

public class Pilotos {

    private final IntegerProperty codigoPiloto;

    private final StringProperty Nombre;

    private final StringProperty Apellidos;

    private final StringProperty Nacionalidad;

    private final IntegerProperty CodigoEscuderiaPiloto;

    private final DoubleProperty Estatura;

    private final FloatProperty Peso;

    private final IntegerProperty dorsal;

    private final StringProperty fechaNacimiento;

    private final IntegerProperty CampeonatosMundiales;

    private final StringProperty primeraVictoria;

    private final IntegerProperty Puntos;

    public Pilotos(Integer codigoPiloto,
                   String Nombre,
                   String Apellidos,
                   String Nacionalidad,
                   Integer CodigoEscuderiaPiloto,
                   Double Estatura,
                   Float Peso,
                   Integer dorsal,
                   String fechaNacimiento,
                   Integer CampeonadotsMundiales,
                   String primeraVictoria,
                   Integer Puntos) {
        this.codigoPiloto = new SimpleIntegerProperty(codigoPiloto);
        this.Nombre = new SimpleStringProperty(Nombre);
        this.Apellidos = new SimpleStringProperty(Apellidos);
        this.Nacionalidad = new SimpleStringProperty(Nacionalidad);
        this.CodigoEscuderiaPiloto = new SimpleIntegerProperty(CodigoEscuderiaPiloto);
        this.Estatura = new SimpleDoubleProperty(Estatura);
        this.Peso = new SimpleFloatProperty(Peso);
        this.dorsal = new SimpleIntegerProperty(dorsal);
        this.fechaNacimiento = new SimpleStringProperty(fechaNacimiento);
        this.CampeonatosMundiales = new SimpleIntegerProperty(CampeonadotsMundiales);
        this.primeraVictoria = new SimpleStringProperty(primeraVictoria);
        this.Puntos = new SimpleIntegerProperty(Puntos);
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

    public double getEstatura() {
        return Estatura.get();
    }

    public DoubleProperty estaturaProperty() {
        return Estatura;
    }

    public void setEstatura(double estatura) {
        this.Estatura.set(estatura);
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

    public String getFechaNacimiento() {
        return fechaNacimiento.get();
    }

    public StringProperty fechaNacimientoProperty() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento.set(fechaNacimiento);
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