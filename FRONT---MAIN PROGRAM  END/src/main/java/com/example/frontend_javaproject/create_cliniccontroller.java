package com.example.frontend_javaproject;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class create_cliniccontroller implements Initializable {

    @FXML
    private Button btncancel;

    @FXML
    private Button btnreturn;

    @FXML
    private Button btnconfirm;

    @FXML
    private TextField tfid;

    @FXML
    private TextField tfname ;

    @FXML
    private TextField  tftown;

    @FXML
    private TextField tftaste ;

    @FXML
    private TextField tfvacc ;

    @FXML
    private TextField tfhospital ;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //this is the button will create a clinic in our database
        btnconfirm.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                DBUtils.createclinic(actionEvent,Integer.parseInt(tfid.getText()),tfname.getText(),Integer.parseInt(tfvacc.getText()),Integer.parseInt(tftaste.getText()),tfhospital.getText());
                reset();
            }
        });

        btnreturn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                DBUtils.changeover(actionEvent,"menu_clinic.fxml","CLINIC MANAGEMENT");
            }
        });


        btncancel.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                DBUtils.changeover(actionEvent,"menu_clinic.fxml","CLINIC MANAGEMENT");
            }
        });
    }

    private  void reset(){
        tfhospital.clear();
        tfname.clear();
        tfid.clear();
        tftaste.clear();
        tftown.clear();
        tfvacc.clear();
    }
}
