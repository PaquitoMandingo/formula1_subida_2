module com.example.formula1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.formula1 to javafx.fxml;
    exports com.example.formula1;
}