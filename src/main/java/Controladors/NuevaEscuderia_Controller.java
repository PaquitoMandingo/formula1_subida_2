package Controladors;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class NuevaEscuderia_Controller
{
    @javafx.fxml.FXML
    public void initialize() {

    }
    @FXML
    private TextField tfCodigoEscuderia;
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




//***************************************************************************************************************//
//***************************************************************************************************************//
//****************************************Guardar datos**********************************************************//
//***************************************************************************************************************//
//***************************************************************************************************************//
    @FXML
    public boolean guardar(ActionEvent actionEvent) {
        try {
            final String servidor = "jdbc:mariadb://localhost:5555/noinch?useSSL=false";
            final String usuario = "root";
            final String passwd = "adminer";
            int registrosAfectadosConsulta = 0;
            Connection conexionBBDD;
            conexionBBDD = DriverManager.getConnection(servidor, usuario, passwd);
            String SQLINSERT = "INSERT INTO escuderias ("
                    + " codigoEscuderia ,"
                    + " nombre ,"
                    + " anioCreacion ,"
                    + " patrocinador ,"
                    + " web ,"
                    + " puntosE ,"
                    + " codigoPiloto1 ,"
                    + " codigoPiloto2 )"
                    + " VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement st = conexionBBDD.prepareStatement(SQLINSERT);
            st.setString(1, tfCodigoEscuderia.getText());
            st.setString(2, tfNombreEscuderia.getText());
            st.setString(3, tfAnioCreacion.getText());
            st.setString(4, tfMundiales.getText());
            st.setString(5, tfPatrocinadores.getText());
            st.setString(6, tfWeb.getText());
            st.setString(7, tfPuntosMundialesEquipos.getText());
            st.setString(8, tfCodigoPiloto1.getText());
            st.setString(9, tfCodigoPiloto2.getText());


            System.out.println("Funciona");
            registrosAfectadosConsulta = st.executeUpdate();
            st.close();
            conexionBBDD.close();

            if (registrosAfectadosConsulta == 1) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error:" + e.toString());
            return false;
        }
    }
}
