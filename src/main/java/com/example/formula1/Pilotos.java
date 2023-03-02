package com.example.formula1;

import javafx.beans.property.*;



/**La clase Pilotos es una clase de modelo que representa a un piloto de carreras de Fórmula 1.
Tiene varias propiedades privadas con sus respectivos getters y setters que permiten acceder y modificar los datos del piloto.
También tiene varias propiedades que son instancias de clases Property, que se utilizan para observar cambios en las propiedades.
Las propiedades incluyen:
codigoPiloto: un número único que identifica al piloto.
Nombre: el nombre del piloto.
Apellidos: los apellidos del piloto.
Nacionalidad: la nacionalidad del piloto.
CodigoEscuderiaPiloto: un número que identifica la escudería a la que pertenece el piloto.
Estatura: la estatura del piloto.
Peso: el peso del piloto.
dorsal: el número del dorsal que lleva el piloto en su coche.
fechaNacimiento: la fecha de nacimiento del piloto.
CampeonatosMundiales: el número de campeonatos mundiales que ha ganado el piloto.
primeraVictoria: la fecha de la primera victoria del piloto.
Puntos: el número de puntos que ha obtenido el piloto en el campeonato actual.
Todas las propiedades están encapsuladas y se acceden a través de sus respectivos getters y setters.
También hay una serie de propiedades que son instancias de la clase Property, lo que significa que se pueden observar cambios en ellas mediante un listener.*/

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