package reportes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JFrame;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.swing.JRViewer;

public class ReportFormula1 extends JFrame {

    private static final long serialVersionUID = 1L;

    public void showReportSimple() throws JRException, ClassNotFoundException, SQLException {

        String servidor = "jdbc:mariadb://localhost:5555/formula1?useSSL=false";
        String usuario = "root";
        String passwd = "adminer";

        Connection conexionBBDD;
        // Nos conectamos
        conexionBBDD = DriverManager.getConnection(servidor, usuario, passwd);

        //  Block of code to try
        String reportSrcFile = "src/main/java/reportes/ReporteSimple.jrxml";

        // First, compile jrxml file.
        JasperReport jasperReport = JasperCompileManager.compileReport(reportSrcFile);

        // Ejemplo de definición de parámetros para el informe

        HashMap<String, Object> parameters = new HashMap<String, Object>();


        JasperPrint print = JasperFillManager.fillReport(jasperReport, parameters, conexionBBDD);
        JRViewer viewer = new JRViewer(print);
        viewer.setOpaque(true);
        viewer.setVisible(true);
        this.add(viewer);
        this.setSize(700, 500);
        this.setVisible(true);
        System.out.print("Done!");

    }

    public void showReportConSubreport() throws JRException, ClassNotFoundException, SQLException {

        String servidor = "jdbc:mariadb://localhost:5555/formula1?useSSL=false";
        String usuario = "root";
        String passwd = "adminer";

        Connection conexionBBDD;
        // Nos conectamos
        conexionBBDD = DriverManager.getConnection(servidor, usuario, passwd);

        //  Block of code to try
        String reportSrcFile = "src/main/java/reportes/ReporteMaestro.jrxml";


        // First, compile jrxml file.
        JasperReport jasperReport = JasperCompileManager.compileReport(reportSrcFile);



        // Debemos pasar el subreport como un parámetro para que se muestre correctamente el informe
        // El parámetro debe estar definido como del tipo net.sf.jasperreports.engine.JasperReport

        HashMap<String, Object> parameters = new HashMap<String, Object>();


        JasperPrint print = JasperFillManager.fillReport(jasperReport, parameters, conexionBBDD);
        JRViewer viewer = new JRViewer(print);
        viewer.setOpaque(true);
        viewer.setVisible(true);
        this.add(viewer);
        this.setSize(700, 500);
        this.setVisible(true);
        System.out.print("Done!");

    }


}
