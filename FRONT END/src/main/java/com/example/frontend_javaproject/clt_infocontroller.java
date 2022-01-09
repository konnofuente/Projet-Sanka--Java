package com.example.frontend_javaproject;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.*;
import java.util.Calendar;
import java.util.ResourceBundle;

public class clt_infocontroller implements Initializable {

        @FXML private Button btnconfirm;

        @FXML private TextField txtcni;

        @FXML private TextField txtname;

        @FXML private TextField txtnty;

        @FXML private TextField txtphone;

        @FXML private TextField txtstatus;


        @Override
        public void initialize(URL url, ResourceBundle resourceBundle) {



                btnconfirm.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent actionEvent) {
                                 DBUtils.clientinfo(actionEvent,Integer.parseInt(txtcni.getText()),txtname.getText(),txtnty.getText(),Integer.parseInt(txtphone.getText()),txtstatus.getText());
                        }

                });
        }
}
