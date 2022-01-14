package com.example.frontend_javaproject;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class vaccinationcontroller implements Initializable {

    @FXML private Button btnreturn;

    @FXML private Button btnreset;

    @FXML private TextField cni;

    @FXML private TextField name;

    @FXML private TextField phone_num;

    @FXML private TextField nationality;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {



        btnreset.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                cni.clear();
                name.clear();
                phone_num.clear();
                nationality.clear();
            }
        });

        btnreturn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                DBUtils.changeover(actionEvent,"2servicepage.fxml","Service Page");
            }
        });
    }
}
