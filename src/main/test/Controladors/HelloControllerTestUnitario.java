package Controladors;

import com.example.formula1.HelloApplication;
import javafx.collections.FXCollections;
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
import java.sql.*;

@ExtendWith(ApplicationExtension.class)
class HelloControllerTestUnitario {
    Pane mainroot;
    Stage mainstage;



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
                + " Puesto, "
                + " FechaSalida ,"
                + " PrecioPromedio ,"
                + " CirculatingSupply ,"
                + " TotalSupply ,"
                + " Contrato ,"
                + " PaginaWeb ,"
                + " CantidadComprada )"
                + " VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";


        PreparedStatement st = null;
        try {
            st = conexionBBDD.prepareStatement(SQLINSERT);

            st.setString(1, "71710");
            st.setString(2, "TestUnitario");
            st.setString(3, "Test unitario e");
            st.setInt(4, Integer.parseInt("22"));
            st.setDate(5, Date.valueOf("2020-01-01"));
            st.setFloat(6, Float.parseFloat("2.0"));
            st.setFloat(7, Float.parseFloat("2.0"));
            st.setFloat(8, Float.parseFloat("2.0"));
            st.setString(9, "TestUnitario");
            st.setString(10, "Test unitario e");
            st.setFloat(11, Float.parseFloat("2.0"));


            st.executeUpdate();
            st.close();
            conexionBBDD.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    void registroComprobar() {
        Criptomoneda c = new Criptomoneda();
        this.datosResultadoConsulta = FXCollections.observableArrayList();
        final String servidor = "jdbc:mariadb://localhost:5555/formula1?useSSL=false";
        final String usuario = "root";
        final String passwd = "adminer";
        int registrosAfectadosConsulta = 0;
        Connection con;


        try {
            con = DriverManager.getConnection(servidor, usuario, passwd);

            String SQL = "SELECT * "
                    + "FROM escuderias "
                    + "WHERE codigoEscuderia ='71710'";


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
            ResultSet resultadoConsulta2 = con.createStatement().executeQuery(SQL);
            if(resultadoConsulta2.next()){
                System.out.println("Registros afectados "+registrosAfectadosConsulta);

            }else {
                assert false:"No tiene datos";
            }

        }catch (SQLException e){
            System.out.println("No existen datos");
        }

    }