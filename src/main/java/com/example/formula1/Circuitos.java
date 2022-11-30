package com.example.formula1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class Circuitos extends Application {



    public static void main(String[] args) {
        launch(args);

    }
    public void start(Stage stage) throws IOException {

        //Labels de titulo
        Label titulo = new Label("Circuitos disponibles en la temporada");
        Label codigoCircuito = new Label("Codigo de circuito: ");
        Label nombreDelCircuito = new Label("Nombre del circuito: ");
        Label anioDeCreacion = new Label("Anio de creacion ");
        Label ultimoGanador = new Label("UltimoGanador: ");
        Label distanciaEnM = new Label("Distancia (m): ");
        Label recordVueltaMinutos = new Label("Record del vuelta (minutos): ");
        Label recordVueltasSegundos = new Label("Record de vuelta (segundos): ");
        Label numeroDeVueltas = new Label("Numero de vueltas: ");
        Label paisProcedencia = new Label("Pais en el que se disputa: ");


        //Propiedades
        titulo.setScaleX(3);
        titulo.setScaleY(3);
        codigoCircuito.setScaleX(2);
        codigoCircuito.setScaleY(2);
        nombreDelCircuito.setScaleX(2);
        nombreDelCircuito.setScaleY(2);
        anioDeCreacion.setScaleX(2);
        anioDeCreacion.setScaleY(2);
        ultimoGanador.setScaleX(2);
        ultimoGanador.setScaleY(2);
        distanciaEnM.setScaleX(2);
        distanciaEnM.setScaleY(2);
        recordVueltaMinutos.setScaleX(2);
        recordVueltaMinutos.setScaleY(2);
        recordVueltasSegundos.setScaleX(2);
        recordVueltasSegundos.setScaleY(2);
        numeroDeVueltas.setScaleX(2);
        numeroDeVueltas.setScaleY(2);
        paisProcedencia.setScaleX(2);
        paisProcedencia.setScaleY(2);





        //HBox 1 y 2
        HBox hbox = new HBox(titulo);
        hbox.setMinWidth(1000);
        hbox.setMinHeight(80.0);

        Insets insets1 = new Insets(60, 0, 0, 65);

        VBox vbox = new VBox(codigoCircuito, nombreDelCircuito, anioDeCreacion, ultimoGanador, distanciaEnM);
        VBox vbox2 = new VBox(recordVueltaMinutos, recordVueltasSegundos, numeroDeVueltas, paisProcedencia);
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(100, 0, 0, 70));
        gridPane.setHgap(200);
        codigoCircuito.setPadding(new Insets(15, 0, 0, 10));
        nombreDelCircuito.setPadding(new Insets(20, 0, 0, 10));
        anioDeCreacion.setPadding(new Insets(20, 0, 0, 10));
        ultimoGanador.setPadding(new Insets(20, 0, 0, 10));
        recordVueltaMinutos.setPadding(new Insets(20, 0, 0, 10));
        recordVueltasSegundos.setPadding(new Insets(20, 0, 0, 10));
        numeroDeVueltas.setPadding(new Insets(20, 0, 0, 10));
        vbox2.setPadding(new Insets(0, 0, 0, 475));
        paisProcedencia.setPadding(new Insets(20, 0, 0, 10));

        distanciaEnM.setPadding((new Insets(20,0,0,10)));
        gridPane.add(vbox, 0 ,1);
        gridPane.add(vbox2, 1, 1);



        AnchorPane anchorPane = new AnchorPane(hbox, gridPane);
        Scene scene = new Scene(anchorPane, 1280,720);


        //Margenes
        titulo.setPadding(new Insets(10, 0, 0, 100));


        //Hoja de estilo


        //IDs
        hbox.setId("cabeceraHbox");
        titulo.setTextFill(Color.BLACK);


        // set the scene
        stage.setScene(scene);
        stage.setMinHeight(1000);
        stage.setMinWidth(1000);
        stage.setResizable(false);
        stage.setTitle("Datos");
        stage.show();
    }
}
