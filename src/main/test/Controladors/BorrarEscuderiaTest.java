package Controladors;

import com.example.formula1.HelloApplication;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(ApplicationExtension.class)
class BorrarEscuderiaTest {

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
    void borrarEscuderia(FxRobot robot){
        robot.doubleClickOn("67670");
        robot.clickOn("#btnBorrar");
        robot.sleep(1000);
        robot.clickOn("Sí");
        robot.clickOn("#btnCargarR");
        robot.sleep(1000);

    }

}