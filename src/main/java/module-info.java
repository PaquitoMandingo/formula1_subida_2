module com.example.formula1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.formula1 to javafx.fxml;
    exports com.example.formula1;
}