package com.example.frontend_javaproject;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class clt_modifie_control implements Initializable {
    @FXML private Button btnexit;

    @FXML private Button btnconfirm;

    @FXML private Button btnreset;

    @FXML private Button btnreturn;

    @FXML private TextField tfold_nic;

    @FXML private TextField tfnew_nic;

    @FXML private TextField tfname;

    @FXML private TextField tfnationality;

    @FXML private TextField tfphone;

    @FXML private TextField tfstatus;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        btnreturn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                DBUtils.changeover(actionEvent,"M_cltmenu.fxml","ADMINISTRATOR");
            }
        });

        btnreset.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                tfnationality.clear();
                tfphone.clear();
                tfstatus.clear();
                tfname.clear();
                tfnew_nic.clear();
                tfold_nic.clear();
            }
        });


        btnexit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                DBUtils.changeover(actionEvent,"M_cltmenu.fxml","ADMINISTRATOR");
            }
        });
    }
}
