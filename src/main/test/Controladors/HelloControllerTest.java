package Controladors;

import com.example.formula1.HelloApplication;
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
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.matcher.base.WindowMatchers;
import org.testfx.matcher.control.LabeledMatchers;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(ApplicationExtension.class)
class HelloControllerTest {

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
    void insertarDatosTest(FxRobot robot){
        robot.clickOn("#nuevaEscuderiaTest");
        robot.sleep(1000);


        robot.clickOn("#tfCodEscuderia");
        robot.write("67670");
        robot.clickOn("#tfCodEscuderia");
        robot.write("67670");
        robot.clickOn("#tfCodEscuderia");
        robot.write("67670");
        robot.clickOn("#tfCodEscuderia");
        robot.write("67670");
        robot.clickOn("#tfCodEscuderia");
        robot.write("67670");
        robot.clickOn("#tfCodEscuderia");
        robot.write("67670");
        robot.clickOn("#tfCodEscuderia");
        robot.write("67670");
        robot.clickOn("#tfCodEscuderia");
        robot.write("67670");
        robot.clickOn("#tfCodEscuderia");
        robot.write("67670");
    }
}