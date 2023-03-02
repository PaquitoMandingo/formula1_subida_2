package com.example.formula1;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
/**Esta es una clase de Java llamada HelloApplication que extiende la clase Application. Contiene un método llamado start que se llama cuando se inicia la aplicación.
Este método carga un archivo FXML llamado "hello-view.fxml" utilizando una instancia de FXMLLoader,
y establece el elemento de interfaz de usuario resultante como el nodo raíz de una nueva Scene. Luego, la Scene se muestra en un nuevo Stage.
El método main de esta clase simplemente llama al método launch, que es un método estático de la clase Application que inicia la aplicación JavaFX.
Cuando se llama a launch, se crea una nueva instancia de HelloApplication y se llama a su método start.
Esta clase no tiene otros miembros o métodos públicos o privados, por lo que el propósito de la aplicación es mostrar la interfaz de usuario definida en el archivo "hello-view.fxml".*/
public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}