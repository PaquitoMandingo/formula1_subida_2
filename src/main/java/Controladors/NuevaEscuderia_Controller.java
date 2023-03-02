package Controladors;

import com.example.formula1.Escuderias;
import com.example.formula1.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
/**
 * La clase contiene métodos para manejar eventos de la interfaz gráfica de usuario en JavaFX para agregar y guardar información de escuderías
 * en una base de datos. El método initialize() está vacío, mientras que el método volver() maneja el evento de presionar el botón de "Volver" y
 * carga la vista principal. El método guardar() maneja el evento de presionar el botón de "Guardar" y guarda la información de la escudería en la base de datos.
 * */
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
/**
 * La función initialize es un método que se ejecuta automáticamente al cargar la vista correspondiente a este controlador.
 * En este caso, el método está vacío, por lo que no realiza ninguna acción.*/
    @javafx.fxml.FXML
    public void initialize() {

    }
    /**La función volver se ejecuta cuando se hace clic en el botón "Volver". Lo que hace es cargar la vista "hello-view.fxml"
     * utilizando un FXMLLoader, crear una nueva escena y un nuevo Stage, mostrar el nuevo Stage y cerrar el Stage actual.*/
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
/**
 * La clase contiene también anotaciones de JavaFX, como @FXML en el método initialize()
 * para indicar que el método será utilizado en el archivo FXML para cargar la vista,
 * y también en el método guardar() para identificar los elementos de la interfaz que serán utilizados en el método.
 * Además, la clase utiliza la clase Alert para mostrar mensajes de información y confirmación al usuario.
 * */
    @FXML
    public void guardar(ActionEvent actionEvent) {
        Alert alert;


        if (!tfAnadirCodigoEscuderia.getText().trim().equals("")&& !btnAnadirEscuderia.getText().isBlank()) {

            alert = new Alert(Alert.AlertType.CONFIRMATION, "Se ha añadido correctamente'");

            alert.showAndWait();
            if (alert.getResult() == ButtonType.OK) {
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
                    st.setObject(8, tfCodigoPiloto1.getText().isBlank() ? null : Integer.parseInt(tfCodigoPiloto1.getText()));
                    st.setObject(9, tfCodigoPiloto2.getText().isBlank() ? null : Integer.parseInt(tfCodigoPiloto2.getText()));

                    System.out.println("Funciona");
                    st.executeUpdate();
                    st.close();
                    conexionBBDD.close();

                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Error:" + e.toString());
                }
            }
        }else{
            alert = new Alert(Alert.AlertType.CONFIRMATION, "No se han introducido los datos correcdtamente'");
        }
    }

}