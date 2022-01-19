package com.example.frontend_javaproject;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class testcontroller implements Initializable {
    @FXML private Button btnpositive;

    @FXML private Button btnnegative;

    @FXML private Button btnvaccinate;

    @FXML private Button btnexit;

    @FXML private TextField tfnic ;

    @FXML private TextField tfname;

    @FXML private TextField tfnationality ;

    @FXML private TextField tftel ;

    @FXML private TextField  tfgadget_num;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        //Integer.parseInt(txtcni.getText())

        btnpositive.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                DBUtils.clienttaste(actionEvent,Integer.parseInt(tfnic.getText()),tfname.getText(),tfnationality.getText(),Integer.parseInt(tftel.getText()),Integer.parseInt(tfgadget_num.getText()),"Positive");
            }
        });

        btnnegative.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                DBUtils.clienttaste(actionEvent,Integer.parseInt(tfnic.getText()),tfname.getText(),tfnationality.getText(),Integer.parseInt(tftel.getText()),Integer.parseInt(tfgadget_num.getText()),"Negative");
            }
        });

        btnvaccinate.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                DBUtils.changeover(actionEvent,"vaccination.fxml","CLIENT MANAGEMENT");
            }
        });

        btnexit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                DBUtils.changeover(actionEvent,"2servicepage.fxml","CLIENT MANAGEMENT");
            }
        });

    }
}
