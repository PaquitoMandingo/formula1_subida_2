package Controladors;

import com.example.formula1.Escuderias;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
    ObservableList<Escuderias> resultadoConsulta = FXCollections.observableArrayList();

    @Test()
    void registroUnitarioEliminar() throws SQLException {

        final String servidor = "jdbc:mariadb://localhost:5555/formula1?useSSL=false";
        final String usuario = "root";
        final String passwd = "adminer";
        int registrosAfectadosConsulta = 0;
        Connection con;
        con = DriverManager.getConnection(servidor, usuario, passwd);
        try {

            con = DriverManager.getConnection(servidor, usuario, passwd);
            String SQL = "DELETE FROM escuderia "
                    + " WHERE CodigoEscuderia = '71710' ";



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
        this.resultadoConsulta = FXCollections.observableArrayList();
        final String servidor = "jdbc:mariadb://localhost:5555/formula1?useSSL=false";
        final String usuario = "root";
        final String passwd = "adminer";
        int registrosAfectadosConsulta = 0;
        Connection con;


        try {
            con = DriverManager.getConnection(servidor, usuario, passwd);

            String SQL = "SELECT * "
                    + "FROM escuderia "
                    + "WHERE CodigoEscuderia ='71710'";

            ResultSet datos = con.createStatement().executeQuery(SQL);
            PreparedStatement st = con.prepareStatement(SQL);

            while (datos.next()) {

                Escuderias e = new Escuderias(

                        datos.getInt("CodigoEscuderia"),
                        datos.getString("Nombre"),
                        datos.getInt("AnioCreacion"),
                        datos.getString("MundialesGanados"),
                        datos.getString("Patrocinador"),
                        datos.getString("Web"),
                        datos.getInt("puntosE"),
                        datos.getInt("CodigoPiloto1"),
                        datos.getInt("CodigoPiloto2"));


                resultadoConsulta.add(e);
                registrosAfectadosConsulta++;
                System.out.println(e.toString());
            }

            if (registrosAfectadosConsulta != 0) {
                assert false : "El campo sigue existiendo";

            } else {

                System.out.println("Se ha eliminado correctamente");
            }



        } catch (SQLException e) {
            System.out.println("No existen datos");
        }
    }
}
