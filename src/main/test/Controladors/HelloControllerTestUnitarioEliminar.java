package Controladors;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxAssert;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;
import org.testfx.matcher.base.WindowMatchers;
import org.testfx.matcher.control.LabeledMatchers;

import java.io.IOException;
import java.sql.*;

public class HelloControllerTestUnitarioEliminar {
    @Test()
    void registroUnitarioEliminar() throws SQLException {

        final String servidor = "jdbc:mariadb://localhost:5555/noinch?useSSL=false";
        final String usuario = "root";
        final String passwd = "adminer";
        int registrosAfectadosConsulta = 0;
        Connection con;
        con = DriverManager.getConnection(servidor, usuario, passwd);
        try {

            con = DriverManager.getConnection(servidor, usuario, passwd);
            String SQL = "DELETE FROM criptomoneda "
                    + " WHERE Token = 'UNI' ";

            PreparedStatement st = con.prepareStatement(SQL);

            st.executeUpdate();

            st.close();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error:" + e.toString());

        }
    }

    @Test
    void registroComprobar() {
        Criptomoneda c = new Criptomoneda();
        this.datosResultadoConsulta = FXCollections.observableArrayList();
        final String servidor = "jdbc:mariadb://localhost:5555/noinch?useSSL=false";
        final String usuario = "root";
        final String passwd = "adminer";
        int registrosAfectadosConsulta = 0;
        Connection con;


        try {
            con = DriverManager.getConnection(servidor, usuario, passwd);

            String SQL = "SELECT * "
                    + "FROM criptomoneda "
                    + "WHERE Token ='UNI'";


            ResultSet resultadoConsulta = con.createStatement().executeQuery(SQL);
            PreparedStatement st = con.prepareStatement(SQL);

            while (resultadoConsulta.next()) {

                c = new Criptomoneda(
                        resultadoConsulta.getString("token"),
                        resultadoConsulta.getString("nombre"),
                        resultadoConsulta.getString("descripcion"),
                        resultadoConsulta.getInt("puesto"),
                        resultadoConsulta.getDate("fechaSalida"),
                        resultadoConsulta.getFloat("precioPromedio"),
                        resultadoConsulta.getFloat("circulatingSupply"),
                        resultadoConsulta.getFloat("totalSupply"),
                        resultadoConsulta.getString("contrato"),
                        resultadoConsulta.getString("paginaWeb"),
                        resultadoConsulta.getFloat("cantidadComprada")
                );

                datosResultadoConsulta.add(c);
                registrosAfectadosConsulta++;
                System.out.println(c.toString());

            }

            if(registrosAfectadosConsulta != 0){
                assert false:"El campo sigue existiendo";

            }else {

                System.out.println("Se ha eliminado correctamente");
            }

        }catch (SQLException e){
            System.out.println("No existen datos");
        }

    }
