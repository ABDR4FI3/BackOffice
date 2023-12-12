module com.example.backoffice {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.j;


    opens com.example.backoffice to javafx.fxml;
    exports com.example.backoffice;
}