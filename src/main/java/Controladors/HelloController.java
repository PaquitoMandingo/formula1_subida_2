package Controladors;

import com.example.formula1.Circuitos;
import com.example.formula1.Escuderias;
import com.example.formula1.HelloApplication;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class HelloController {

    @FXML
    private TableColumn tcEscuderia;
    @FXML
    private TableColumn tcCodigoEscuderia;
    @FXML
    private TableColumn tcPatrocinador;
    @FXML
    private TableColumn tcWeb;
    @FXML
    private TableColumn tcPuntosMundialEscuderias;
    private Connection c;
    @FXML
    private TextField tfCodigoEscuderia;
    @FXML
    private TableView tableViewEscuderia;
    @FXML
    private Button nuevaEscuderia;
    @FXML
    private TextField tfCodigoEscuderia_Borrar;
    @FXML
    private int codEscuderia;

    public void initialize(){
        cargarAuto();
        cargarGestorDobleCLick();
    }

//***************************************************************************************************************//
//***************************************************************************************************************//
//************************************************Gestor dobleclik************************************************//
//***************************************************************************************************************//
//***************************************************************************************************************//
    /**

     Configura la funcionalidad de doble clic en una fila de la tabla de escuderías.
     Si la tabla es nula, no se realiza ninguna acción.
     Al hacer doble clic en una fila, se obtiene el código de la escudería de la fila seleccionada
     y se muestra en el campo de texto correspondiente para borrar la escudería.
     */
    private void cargarGestorDobleCLick () {
        if(tableViewEscuderia == null){

        }else{
            tableViewEscuderia.setRowFactory(tv -> {
                TableRow<Escuderias> row = new TableRow<>();
                row.setOnMouseClicked(event -> {
                    if (event.getClickCount() == 2 && (!row.isEmpty())) {
                        codEscuderia = row.getItem().getCodigoEscuderia();
                        tfCodigoEscuderia_Borrar.setText(String.valueOf(codEscuderia));
                    }
                });
                return row;
            });
        }

    }

//***************************************************************************************************************//
//***************************************************************************************************************//
//************************************************Cargar atuomatico************************************************//
//***************************************************************************************************************//
//***************************************************************************************************************//
    /**
     Carga los datos de las escuderías desde la base de datos y los muestra en una tabla.
     @return devuelve false siempre.
     */
    public boolean cargarAuto() {
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
            String SQL = "SELECT * " + "FROM escuderia";
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
    }

//***************************************************************************************************************//
//***************************************************************************************************************//
//************************************************CARGAR**********************************************************//
//***************************************************************************************************************//
//***************************************************************************************************************//

    /**

    Método que carga los datos de la base de datos y los muestra en una tabla.
    @param actionEvent evento de acción que activa el método.
            @return false siempre, ya que no se usa para nada más.
            */
    public boolean cargar(ActionEvent actionEvent) {
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
    }


//***************************************************************************************************************//
//***************************************************************************************************************//
//************************************************Borrar con advertencia*****************************************//
//***************************************************************************************************************//
//***************************************************************************************************************//
    /**
     Método que maneja el evento del botón "Seguro" para borrar una escudería de la base de datos.
     Este método está marcado como @Deprecated, lo que significa que se considera obsoleto y se recomienda
     no usarlo en nuevos desarrollos. En su lugar, se debería usar un método que utilice un patrón de diseño
     MVC (Modelo-Vista-Controlador) para separar la lógica de negocio de la interfaz de usuario.
     @param actionEvent el evento generado por el botón "Seguro"*/

    @Deprecated
    public void btnSeguro(ActionEvent actionEvent) {
        Alert alert;

        if ( ! tfCodigoEscuderia_Borrar.getText().trim().equals("")) {

            alert = new Alert(Alert.AlertType.CONFIRMATION, "¿Seguro que desea borrar la escuderia con el codigo '"
                    + tfCodigoEscuderia_Borrar.getText() + "' ?.", ButtonType.YES, ButtonType.NO );

            alert.showAndWait();
            if (alert.getResult() == ButtonType.YES) {
                int registroBorrados = 0;

                try {
                    // Nos conectamos
                    final String servidor = "jdbc:mariadb://localhost:5555/formula1?useSSL=false";
                    final String usuario = "root";
                    final String passwd = "adminer";

                    Connection conexionBBDD;
                    conexionBBDD = DriverManager.getConnection(servidor, usuario, passwd);

                    String SQLBORRAR = "DELETE FROM escuderia "
                            + " WHERE CodigoEscuderia = ? ";
                    PreparedStatement st = conexionBBDD.prepareStatement(SQLBORRAR);

                    st.setString(1, tfCodigoEscuderia_Borrar.getText());

                    // Ejecutamos la consulta preparada (con las ventajas de seguridad y velocidad en el servidor de BBDD
                    // nos devuelve el número de registros afectados. Al ser un Delete nos debe devolver 1 si se ha hecho correctamente
                    registroBorrados = st.executeUpdate();
                    st.close();
                    conexionBBDD.close();



                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Error:" + e.toString());

                }
                if (registroBorrados == 1) {

                } else {
                    alert = new Alert(Alert.AlertType.INFORMATION, "No se ha encontrado la escuderia con el código '"
                            + tfCodigoEscuderia_Borrar.getText() + "' .", ButtonType.OK );
                    alert.showAndWait();
                }
            }
        }
        else {
            alert = new Alert(Alert.AlertType.INFORMATION, "Debe indicar el código de la escuderia a borrar.", ButtonType.OK );
            alert.showAndWait();
        }
    }


//***************************************************************************************************************//
//***************************************************************************************************************//
//************************************************Nueva Escuderia************************************************//
//***************************************************************************************************************//
//***************************************************************************************************************//
    /**
     Abre una ventana para añadir una nueva escudería.
     @param event Evento que desencadena la acción de añadir una nueva escudería.
     */
    @FXML
    public void nuevaEscuderia(ActionEvent event) {
        try {
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("nuevaEscuderia.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 720, 480);
            stage.setTitle("Añadir nueva escuderia");
            stage.setScene(scene);
            stage.show();

            Stage stage3 = (Stage) this.nuevaEscuderia.getScene().getWindow();
            stage3.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

//***************************************************************************************************************//
//***************************************************************************************************************//
//************************************************Nueva Piloto************************************************//
//***************************************************************************************************************//
//***************************************************************************************************************//
    /**

     Método que se ejecuta al pulsar el botón "Nuevo Piloto" y muestra la ventana para añadir un nuevo piloto.
     Crea un nuevo objeto Stage y carga el archivo FXML correspondiente. También inicializa el controlador de la ventana
     y le pasa los parámetros necesarios (el objeto Stage y el código de la escudería a la que pertenecerá el nuevo piloto).
     Finalmente, muestra la ventana y espera a que el usuario termine de interactuar con ella.
     @param event El evento que ha desencadenado la acción (pulsar el botón "Nuevo Piloto").
     */
    public void nuevoPiloto(Event event) {
        try {
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("nuevoPiloto.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
            stage.setTitle("Añadir nuevo piloto");
            stage.setScene(scene);
            NuevoPiloto_Controller controller = fxmlLoader.getController();
            controller.init(stage,codEscuderia);
            stage.showAndWait();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

//***************************************************************************************************************//
//***************************************************************************************************************//
//************************************************Nueva Circuito************************************************//
//***************************************************************************************************************//
//***************************************************************************************************************//
    /**

     Controlador principal de la aplicación que maneja la navegación a través del menú.
     */
    public class Menu_Controller {

        /**

         Abre la ventana de circuitos al seleccionar la opción correspondiente en el menú.
         @param event El evento de selección de la opción de circuitos en el menú.
         */
        public void circuitos(Event event) {
            Circuitos circuitos = new Circuitos();
            Stage stage = new Stage();
            try {
                circuitos.start(stage);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        /**

         Abre la ventana de reportes al seleccionar la opción correspondiente en el menú.
         @param event El evento de selección de la opción de reportes en el menú.
         */
        public void reportes(Event event) {
            try {
                Stage stage = new Stage();
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("reportes.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
                stage.setTitle("Reportes");
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}


