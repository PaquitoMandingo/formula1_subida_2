package Controladors;

import com.example.formula1.HelloApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@ExtendWith(ApplicationExtension.class)
class HelloControllerTestUnitario {
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
    Pane mainroot;
    Stage mainstage;

    @Start
    public void start(Stage stage) throws IOException {
        System.out.println(getClass());
        mainroot =  FXMLLoader.load(HelloApplication.class.getResource("hello-view.fxml"));
        mainstage = stage;
        stage.setTitle("Hello!");
        stage.setScene(new Scene(mainroot));
        stage.show();
    }

    @Test
    void registroUnitario() throws SQLException {
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

        PreparedStatement st = null;
        try {
            st = conexionBBDD.prepareStatement(SQLINSERT);

        st.setInt(1, Integer.parseInt("76761"));
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
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}