package Controladors;

import com.example.formula1.Escuderias;
import com.example.formula1.Pilotos;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class NuevoPiloto_Controller {

    @FXML
    private TableColumn tcCodigoPiloto;

    @FXML
    private TableColumn tcNacionalidad;

    @FXML
    private TableColumn tcEscuderiaPiloto;

    @FXML
    private TableColumn tcEstatura;

    @FXML
    private TableColumn tcPeso;

    @FXML
    private TableColumn tcDorsal;


    @FXML
    private TableColumn tcCampeonatosMundiales;

    @FXML
    private TableColumn tcPrimeraVictoria;

    @FXML
    private TableView tableViewPilotos;

    private Connection c;
    @FXML
    private TableColumn tcNombrePiloto;
    @FXML
    private TableColumn tcApellidoPiloto;
    @FXML
    private TableColumn tcFechaNac;
    @FXML
    private TableColumn tcPuntosTemporada;

    public void initialize(){

        cargarAutoPilotos();
    }


    public boolean cargarAutoPilotos() {
        ObservableList<Object> data = null;
        try {
            //creamos la conexion y le ponemos los datos con la ruta para que lo ejecute
            final String servidor = "jdbc:mariadb://localhost:5555/formula1?useSSL=false";
            final String usuario = "root";
            final String passwd = "adminer";
            Connection conexionBBDD;

            Pilotos auxiliar;
            data = FXCollections.observableArrayList();
            c = DriverManager.getConnection("jdbc:mariadb://localhost:5555/formula1?useSSL=false"
                    , "root",
                    "adminer");
            ;
            //hacemos la consulta con los datos que queremos sacar
            String SQL = "SELECT * " + "FROM pilotos";
            ResultSet datos = c.createStatement().executeQuery(SQL);
            System.out.println(datos.toString());

            //esto nos da unos datos pero tenemos que mostrarlo en la tabla
            //de esta forma los mostramos en la tabla
            while (datos.next()) {
                auxiliar = new Pilotos(
                        datos.getInt("codigoPiloto"),
                        datos.getString("Nombre"),
                        datos.getString("Apellidos"),
                        datos.getString("Nacionalidad"),
                        datos.getInt("Escuderia"),
                        datos.getBigDecimal("Estatura"),
                        datos.getFloat("Peso"),
                        datos.getInt("dorsal"),
                        datos.getDate("fechaNacimiento"),
                        datos.getInt("CampeonatosMundiales"),
                        datos.getString("Primera Victoria"),
                        datos.getInt("Puntos"));


                        data.add(auxiliar);
                //System.out.println(auxiliar.toString());
            }
            //esto es para poner los datos en la tabla para ello simplemnete le ponemos que en el id de cada columna de la tabla le aplique
            //su dato es decir para oficina pues el codigo que tenemos en el array  y asi con cada dato
            tcCodigoPiloto.setCellValueFactory(new PropertyValueFactory<Escuderias, String>("codigoPiloto"));
            tcNombrePiloto.setCellValueFactory(new PropertyValueFactory<Escuderias, String>("Nombre"));
            tcApellidoPiloto.setCellValueFactory(new PropertyValueFactory<Escuderias, String>("Apellidos"));
            tcNacionalidad.setCellValueFactory(new PropertyValueFactory<Escuderias, String>("Nacionalidad"));
            tcEscuderiaPiloto.setCellValueFactory(new PropertyValueFactory<Escuderias, String>("CodigoEscuderiaPiloto"));
            tcEstatura.setCellValueFactory(new PropertyValueFactory<Escuderias, String>("Estatura"));
            tcPeso.setCellValueFactory(new PropertyValueFactory<Escuderias, String>("Peso"));
            tcDorsal.setCellValueFactory(new PropertyValueFactory<Escuderias, String>("dorsal"));
            tcFechaNac.setCellValueFactory(new PropertyValueFactory<Escuderias, String>("fechaNacimiento"));
            tcCampeonatosMundiales.setCellValueFactory(new PropertyValueFactory<Escuderias, String>("CampeonatosMundiales"));
            tcPrimeraVictoria.setCellValueFactory(new PropertyValueFactory<Escuderias, String>("primeraVictoria"));
            tcPuntosTemporada.setCellValueFactory(new PropertyValueFactory<Escuderias, String>("Puntos"));
            //sin esto no podremos mostrar nada asi que es obligatorio
            tableViewPilotos.setItems(data);
            System.out.println("Cargados los datos");
            //proximo paso insertar datos
            //para ello debemos volver a conectar a la base de datos


        } catch (Exception e) {
            e.printStackTrace();
            data.removeAll();
            tableViewPilotos.getColumns().clear();
            System.out.println(e.toString());
            tableViewPilotos.setItems(null);
            System.out.println("Error on Building Data");

        }
        tableViewPilotos.setItems(data);
        System.out.println(data);
        return false;
    }

    //***************************************************************************************************************//
//***************************************************************************************************************//
//************************************************CARGAR**********************************************************//
//***************************************************************************************************************//
//***************************************************************************************************************//
    /*public boolean cargarPilotos(ActionEvent actionEvent) {
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
            String SQL = "SELECT * " + "FROM escuderia where Nombre like \"%"+tfCodigoEscuderia.getText()+"%\"";
            ResultSet datos = c.createStatement().executeQuery(SQL);
            System.out.println(datos.toString());

            //esto nos da unos datos pero tenemos que mostrarlo en la tabla
            //de esta forma los mostramos en la tabla
            while (datos.next()) {
                auxiliar = new Escuderias(
                        datos.getInt("CodigoEscuderia"),
                        datos.getString("Nombre"),
                        datos.getInt("AnioCreacion"),
                        datos.getString("MundialesGanados"),
                        datos.getString("Patrocinador"),
                        datos.getString("Web"),
                        datos.getInt("puntosE"),
                        datos.getInt("CodigoPiloto1"),
                        datos.getInt("CodigoPiloto2"));


                data.add(auxiliar);
                //System.out.println(auxiliar.toString());
            }
            //esto es para poner los datos en la tabla para ello simplemnete le ponemos que en el id de cada columna de la tabla le aplique
            //su dato es decir para oficina pues el codigo que tenemos en el array  y asi con cada dato
            tcCodigoEscuderia.setCellValueFactory(new PropertyValueFactory<Escuderias, String>("CodigoEscuderia"));
            tcEscuderia.setCellValueFactory(new PropertyValueFactory<Escuderias, String>("Nombre"));
            tcPatrocinador.setCellValueFactory(new PropertyValueFactory<Escuderias, String>("Patrocinador"));
            tcPuntosMundialEscuderias.setCellValueFactory(new PropertyValueFactory<Escuderias, String>("puntosE"));
            tcWeb.setCellValueFactory(new PropertyValueFactory<Escuderias, String>("Web"));
            //sin esto no podremos mostrar nada asi que es obligatorio
            tableViewEscuderia.setItems(data);
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
    }*/
}
