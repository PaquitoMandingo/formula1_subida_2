package com.example.formula1;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class HelloController {

    @FXML
    private TableColumn tcEscuderia;
    @FXML
    private TableColumn tcCodigoEscuderia;
    @FXML
    private TableColumn tcAnioCreacion;
    @FXML
    private TableColumn tcMundiales;
    @FXML
    private TableColumn tcPiloto1;
    @FXML
    private TableColumn tcPiloto2;
    @FXML
    private TableColumn tcPatrocinador;
    @FXML
    private TableColumn tcWeb;
    @FXML
    private TableColumn tcPuntosMundialEscuderias;
    private Connection c;

    //***************************************************************************************************************//
//***************************************************************************************************************//
//************************************************CARGAR**********************************************************//
//***************************************************************************************************************//
//***************************************************************************************************************//
    public boolean cargar(ActionEvent actionEvent) {
        try {
            //creamos la conexion y le ponemos los datos con la ruta de lo que tiene que abrir
            final String servidor = "jdbc:mariadb://localhost:5555/noinch?useSSL=false";
            final String usuario = "adminer";
            final String passwd = "adminer";
            Connection conexionBBDD;

            Escuderias auxiliar;
            ObservableList<Object> data = FXCollections.observableArrayList();
            c = DriverManager.getConnection("jdbc:mariadb://localhost:5555/noinch?useSSL=false"
                    , "adminer",
                    "adminer");
            ;
            //hacemos la consulta
            String SQL = "SELECT * " + "FROM offices";
            ResultSet datos = c.createStatement().executeQuery(SQL);
            System.out.println(datos.toString());

            //esto nos da unos datos pero tenemos que mostrarlo en la tabla
            //de esta forma los mostramos en la tabla
            while (datos.next()) {
                auxiliar = new Escuderias(
                        datos.getString("officeCode"),
                        datos.getString("city"),
                        datos.getString("phone"),
                        datos.getString("addressLine1"),
                        datos.getString("addressLine2"));

                data.add(auxiliar);
                System.out.println(auxiliar.toString());

            }
            //tcProductCode.setCellValueFactory(new PropertyValueFactory<Producto, String>("productCode"));


            //esto es para poner los datos en la tabla para ello simplemnete le ponemos que en el id de cada columna de la tabla le aplique
            //su dato es decir para oficina pues el codigo que tenemos en el array  y asi con cada dato
            tcOfficeCode.setCellValueFactory(new PropertyValueFactory<Oficina, String>("officeCode"));
            tcCity.setCellValueFactory(new PropertyValueFactory<Oficina, String>("city"));
            tcPhone.setCellValueFactory(new PropertyValueFactory<Oficina, String>("phone"));
            tcAddres_1.setCellValueFactory(new PropertyValueFactory<Oficina, String>("addressLine1"));
            tcAddres_2.setCellValueFactory(new PropertyValueFactory<Oficina, String>("addressLine2"));
            //sin esto no podremos mostrar nada asi que es obligatorio
            tvOficina.setItems(data);

            //proximo paso insertar datos
            //para ello debemos volver a conectar a la base de datos



        } catch (Exception e) {
            e.printStackTrace();
            data.removeAll();
            tvDatos.getColumns().clear();
            tvDatos.setItems(null);
            System.out.println("Error on Building Data");

        }
        return false;
    }

}