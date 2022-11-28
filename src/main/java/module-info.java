module com.example.formula1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.mariadb.jdbc;

    opens com.example.formula1 to javafx.fxml;
    exports com.example.formula1;
    exports Controladors;
    opens Controladors to javafx.fxml;
}