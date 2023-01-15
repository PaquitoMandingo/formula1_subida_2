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

@ExtendWith(ApplicationExtension.class)
class HelloControllerTestMalAproposito {



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
        void registroUnitario(){

        }

        @Test
        void insertarDatosTest(FxRobot robot){
            robot.doubleClickOn("#tcCodigoEscuderia");
            robot.sleep(1000);

            robot.clickOn("#nuevaEscuderiaTest");
            robot.sleep(1000);



            robot.clickOn("#tfCodEscuderia");
            robot.write("67670");
            robot.clickOn("#tfNombreEscuderia");
            robot.write("Prueba escuderia");
            robot.clickOn("#tfAnioCreacion");
            robot.write("1998");
            robot.clickOn("#tfMundiales");
            robot.write("2020");
            robot.clickOn("#tfPatrocinadores");
            robot.write("ExO2, BenjaminnosCF, ZoyLuzo47");
            robot.clickOn("#tfWeb");
            robot.write("PruebaEscuderiaWeb.com");
            robot.clickOn("#tfPuntosMundial");
            robot.write("147");


            robot.clickOn("#bAnadir");
            robot.sleep(1000);


            robot.clickOn("Aceptar");
            robot.sleep(1000);

            robot.clickOn("#btnVolver");
            robot.sleep(1000);
            robot.clickOn("#btnCargarR");

        /*FxAssert.verifyThat(robot.window("Nueva Ventana"),
                WindowMatchers.isShowing());
        robot.targetWindow("Nueva Ventana");
        FxAssert.verifyThat("#lblMatchers",LabeledMatchers.hasText("Nueva Ventana"));
        /*robot.clickOn("#tfPiloto1");
        robot.write("67670");
        robot.clickOn("#tfPiloto2");
        robot.write("67670");*/
        }
    }