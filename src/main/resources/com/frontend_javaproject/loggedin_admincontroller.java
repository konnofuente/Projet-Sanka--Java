package com.example.frontend_javaproject.frontend_javaproject;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class loggedin_admincontroller implements Initializable {
    @FXML private Button btn_logout;
   @FXML private Label label_welcome;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    btn_logout.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent actionEvent) {
            DBUtils.switchpanel(actionEvent,"admin-login.fxml");
            DBUtils.changescene(actionEvent, "admin-login.fxml", null, null);

        }
    });

    }
    public void setuser_info(String adminname){
            label_welcome.setText("WELCOME MR "+adminname+" !");
    }
}
