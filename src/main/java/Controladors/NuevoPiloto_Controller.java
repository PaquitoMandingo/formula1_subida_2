package Controladors;

import com.example.formula1.Escuderias;
import com.example.formula1.HelloApplication;
import com.example.formula1.Pilotos;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.w3c.dom.Text;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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

    @FXML
    private TextField tfdorsal;
    @FXML
    private TextField tfpuntos;
    @FXML
    private TextField tfescuderia;

    //private Text codigoPiloto;
    @FXML
    private TextField tfCodigoPiloto;

    private Stage stage;
    private int codigoEscuderia;

    private SimpleStringProperty escuderia, piloto, dorsal ,puntos;

    public void init(Stage stage, int codigoEscuderia){
        escuderia = new SimpleStringProperty();
        piloto = new SimpleStringProperty();
        dorsal = new SimpleStringProperty();
        puntos = new SimpleStringProperty();
        escuderia.bind(tfescuderia.textProperty());
        piloto.bind(tfCodigoPiloto.textProperty());
        dorsal.bind(tfdorsal.textProperty());
        puntos.bind(tfpuntos.textProperty());
        this.stage = stage;
        this.codigoEscuderia = codigoEscuderia;
        cargarAutoPilotos();
        cargarGestorDobleCLick();
    }
    //***************************************************************************************************************//
//***************************************************************************************************************//
//************************************************Gestor dobleclik************************************************//
//***************************************************************************************************************//
//***************************************************************************************************************//
    private void cargarGestorDobleCLick () {
        if(tableViewPilotos == null){

        }else{
            tableViewPilotos.setRowFactory(tv -> {
                TableRow<Pilotos> row = new TableRow<>();
                row.setOnMouseClicked(event -> {
                    if (event.getClickCount() == 2 && (!row.isEmpty())) {
                        System.out.println("**************regeght");
                        tfCodigoPiloto.setText(String.valueOf(row.getItem().getCodigoPiloto()));
                        tfescuderia.setText(String.valueOf(codigoEscuderia));
                        tfdorsal.setText(String.valueOf(row.getItem().getDorsal()));
                        tfpuntos.setText(String.valueOf(row.getItem().getPuntos()));
                    }
                });
                return row;
            });
        }

    }


    @FXML
    public void volver(ActionEvent event){
        stage.close();
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
            String SQL = "SELECT * " + "FROM pilotos WHERE Escuderia = " + codigoEscuderia;
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
                        datos.getDouble("Estatura"),
                        datos.getFloat("Peso"),
                        datos.getInt("dorsal"),
                        datos.getString("fechaNacimiento"),
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
            tcDorsal.setCellValueFactory(new PropertyValueFactory<Escuderias, String>("Dorsal"));
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
//***********************************************Actualizar**********************************************************//
//***************************************************************************************************************//
//***************************************************************************************************************//
    public Boolean actualizar(ActionEvent event) {
        Connection c;
        int registrosAfectadosConsulta = 0;

        try {
            // Nos conectamos
            c = DriverManager.getConnection("jdbc:mariadb://localhost:5555/formula1?useSSL=false"
                    , "root",
                    "adminer");
            String SQL = "UPDATE pilotos "
                    + " SET "
                    + " Escuderia =? ,"
                    + " Dorsal =? ,"
                    + " Puntos =? "
                    + " WHERE codigoPiloto = ? ";

            PreparedStatement st = c.prepareStatement(SQL);

            st.setString(1, escuderia.get());
            st.setString(2, dorsal.get());
            st.setString(3, puntos.get());
            st.setString(4, piloto.get());

            // Ejecutamos la consulta preparada (con las ventajas de seguridad y velocidad en el servidor de BBDD
            // nos devuelve el número de registros afectados. Al ser un Update nos debe devolver 1 si se ha hecho correctamente
            registrosAfectadosConsulta = st.executeUpdate();
            if(tfCodigoPiloto.getText() == ""){
                Alert alert;
                alert = new Alert(Alert.AlertType.WARNING, "No se ha modificado ningun dato", ButtonType.OK);
                alert.showAndWait();
            }else {
                Alert alert;
                alert = new Alert(Alert.AlertType.INFORMATION, "Se han modificado los datos de la tabla", ButtonType.OK);
                alert.showAndWait();
            }
            cargarAutoPilotos();
            //borrarTF();
            st.close();
            c.close();

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



//***************************************************************************************************************//
//***************************************************************************************************************//
//************************************************Guardar**********************************************************//
//***************************************************************************************************************//
//***************************************************************************************************************//
    /*@Deprecated
    public void guardar(ActionEvent actionEvent) {
        Alert alert;

        if (!btnAnadirEscuderia.getText().trim().equals("")) {

            alert = new Alert(Alert.AlertType.CONFIRMATION, "Se ha añadido correctamente'");

            alert.showAndWait();
            if (alert.getResult() == ButtonType.YES) {
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
        }
    }*/
}
