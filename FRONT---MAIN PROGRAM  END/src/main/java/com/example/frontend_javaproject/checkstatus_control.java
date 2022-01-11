package com.example.frontend_javaproject;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class checkstatus_control implements Initializable{
    @FXML private Button btncancel;

    @FXML private Button btndisplay;

    @FXML private TextField tfnic;

    @FXML private TextField tfname;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    btncancel.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent actionEvent) {
            DBUtils.changeover(actionEvent,"M_cltmenu.fxml","CLIENT MENU");
        }
    });
    }
}
