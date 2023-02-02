package reportes;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import net.sf.jasperreports.engine.JRException;

import java.sql.SQLException;

public class ReportController{
    @FXML
    private Label welcomeText;


    @FXML
    public void onImprimirListadoClick(ActionEvent actionEvent) {

        try {
            // --- Show Jasper Report on click-----
            new ReportFormula1().showReportSimple();
        } catch (ClassNotFoundException | JRException | SQLException e1) {
            e1.printStackTrace();
        }
    }

    @FXML
    public void onImprimirListadoPedidosCliClick(ActionEvent actionEvent) {
        try {
            // --- Show Jasper Report on click-----
            new ReportFormula1().showReportConSubreport();
        } catch (ClassNotFoundException | JRException | SQLException e1) {
            e1.printStackTrace();
        }
    }
}