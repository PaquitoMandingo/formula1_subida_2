package com.example.formula1;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class HelloController {

    @FXML
    private TableColumn tcEscuderia;
    @FXML
    private TableColumn tcCodigoEscuderia;
    @FXML
    private TableColumn tcPatrocinador;
    @FXML
    private TableColumn tcWeb;
    @FXML
    private TableColumn tcPuntosMundialEscuderias;
    private Connection c;
    @FXML
    private TextField tfCodigoEscuderia;
    @FXML
    private TableView tableViewEscuderia;
    @FXML
    private Button nuevaEscuderia;

    //***************************************************************************************************************//
//***************************************************************************************************************//
//************************************************CARGAR**********************************************************//
//***************************************************************************************************************//
//***************************************************************************************************************//
    public boolean cargar(ActionEvent actionEvent) {
        ObservableList<Object> data = null;
        try {
            //creamos la conexion y le ponemos los datos con la ruta para que lo ejecute
            final String servidor = "jdbc:mariadb://localhost:5555/formula1?useSSL=false";
            final String usuario = "root";
            final String passwd = "adminer";
            Connection conexionBBDD;

            Escuderias auxiliar;
            data = FXCollections.observableArrayList();
            c = DriverManager.getConnection("jdbc:mariadb://localhost:5555/formula1?useSSL=false"
                    , "root",
                    "adminer");
            ;
            //hacemos la consulta con los datos que queremos sacar
            String SQL = "SELECT * " + "FROM escuderia";
            ResultSet datos = c.createStatement().executeQuery(SQL);
            System.out.println(datos.toString());

            //esto nos da unos datos pero tenemos que mostrarlo en la tabla
            //de esta forma los mostramos en la tabla
            while (datos.next()) {
                auxiliar = new Escuderias(
                        datos.getString("CodigoEscuderia"),
                        datos.getString("Nombre"),
                        datos.getString("Patrocinador"),
                        datos.getString("puntosE"),
                        datos.getString("Web"));

                data.add(auxiliar);
                System.out.println(auxiliar.toString());

            }
            //esto es para poner los datos en la tabla para ello simplemnete le ponemos que en el id de cada columna de la tabla le aplique
            //su dato es decir para oficina pues el codigo que tenemos en el array  y asi con cada dato
            tcCodigoEscuderia.setCellValueFactory(new PropertyValueFactory<Escuderias, String>("CodigoEscuderia"));
            tcEscuderia.setCellValueFactory(new PropertyValueFactory<Escuderias, String>("Nombre"));
            tcPatrocinador.setCellValueFactory(new PropertyValueFactory<Escuderias, String>("Patrocinador"));
            tcPuntosMundialEscuderias.setCellValueFactory(new PropertyValueFactory<Escuderias, String>("puntosE"));
            tcWeb.setCellValueFactory(new PropertyValueFactory<Escuderias, String>("Web"));
            //sin esto no podremos mostrar nada asi que es obligatorio

            //proximo paso insertar datos
            //para ello debemos volver a conectar a la base de datos


        } catch (Exception e) {
            e.printStackTrace();
            data.removeAll();
            tableViewEscuderia.getColumns().clear();
            System.out.println(e.toString());
            tableViewEscuderia.setItems(null);
            System.out.println("Error on Building Data");

        }
        tableViewEscuderia.setItems(data);
        System.out.println(data);
        return false;
    }


    @FXML
    public void nuevaEscuderia(Event event) {
        try {
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("nuevaEscuderia.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}