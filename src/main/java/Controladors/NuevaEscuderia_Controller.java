package Controladors;

import com.example.formula1.Escuderias;
import com.example.formula1.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class NuevaEscuderia_Controller
{


    @FXML
    private TextField tfAnadirCodigoEscuderia;
    @FXML
    private TextField tfNombreEscuderia;
    @FXML
    private TextField tfAnioCreacion;
    @FXML
    private TextField tfMundiales;
    @FXML
    private TextField tfPatrocinadores;
    @FXML
    private TextField tfWeb;
    @FXML
    private TextField tfPuntosMundialesEquipos;
    @FXML
    private TextField tfCodigoPiloto1;
    @FXML
    private TextField tfCodigoPiloto2;
    @FXML
    private Button btnAnadirEscuderia;
    @FXML
    private Button btnVolver;

    @javafx.fxml.FXML
    public void initialize() {

    }
    public void volver(ActionEvent event){

        try {
            FXMLLoader fxmlLoader2 = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
            Parent root = null;
            root = fxmlLoader2.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("Escuderias");
            stage.setScene(scene);
            stage.show();

            Stage stage3 = (Stage) this.btnVolver.getScene().getWindow();
            stage3.close();
        }catch (IOException E){

        }
    }

    //***************************************************************************************************************//
//***************************************************************************************************************//
//****************************************Guardar datos**********************************************************//
//***************************************************************************************************************//
//***************************************************************************************************************//

    public void guardar(ActionEvent actionEvent) {
        try {
            final String servidor = "jdbc:mariadb://localhost:5555/formula1?useSSL=false";
            final String usuario = "root";
            final String passwd = "adminer";
            int registrosAfectadosConsulta = 0;
            Connection conexionBBDD;
            conexionBBDD = DriverManager.getConnection(servidor, usuario, passwd);
            String SQLINSERT = "INSERT INTO escuderia ("
                    + " CodigoEscuderia ,"
                    + " Nombre ,"
                    + " AnioCreacion ,"
                    + " MundialesGanados, "
                    + " patrocinador ,"
                    + " Web ,"
                    + " puntosE ,"
                    + " CodigoPiloto1 ,"
                    + " CodigoPiloto2 )"
                    + " VALUES ( ?, ?, ?, ?, ?, ?, ?, ?,?)";

            PreparedStatement st = conexionBBDD.prepareStatement(SQLINSERT);
            st.setInt(1, Integer.parseInt(tfAnadirCodigoEscuderia.getText()));
            st.setString(2, tfNombreEscuderia.getText());
            st.setInt(3, Integer.parseInt(tfAnioCreacion.getText()));
            st.setString(4, tfMundiales.getText());
            st.setString(5, tfPatrocinadores.getText());
            st.setString(6, tfWeb.getText());
            st.setInt(7, Integer.parseInt(tfPuntosMundialesEquipos.getText()));
            st.setObject(8, tfCodigoPiloto1.getText().isBlank() ? null :Integer.parseInt(tfCodigoPiloto1.getText()));
            st.setObject(9, tfCodigoPiloto2.getText().isBlank() ? null :Integer.parseInt(tfCodigoPiloto2.getText()));


            System.out.println("Funciona");
            st.executeUpdate();
            st.close();
            conexionBBDD.close();



        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error:" + e.toString());

        }
    }



}
