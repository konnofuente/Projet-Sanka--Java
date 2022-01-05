module com.example.frontend_javaproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.frontend_javaproject to javafx.fxml;
    exports com.example.frontend_javaproject;
}