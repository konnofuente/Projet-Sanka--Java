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

    @FXML private Button btnvaccinate;

    @FXML private TextField tfnic;

    @FXML private TextField tfname;

    @FXML private TextField tftel;

    @FXML private TextField tfnationality;

    @FXML private TextField tfproffesion;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        btnvaccinate.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                DBUtils.clientinfo(actionEvent,Integer.parseInt(tfnic.getText()),tfname.getText(),tfnationality.getText(),Integer.parseInt(tftel.getText()),tfproffesion.getText());
            }
        });

        btnreset.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                tfnic.clear();
                tfname.clear();
                tftel.clear();
                tfnationality.clear();
                tfproffesion.clear();
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
