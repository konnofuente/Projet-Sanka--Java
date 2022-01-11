package com.example.frontend_javaproject;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class M_cltmenu_control implements Initializable {

    /**
     * this are the button that will be use in the program
     * */
    @FXML private Button btnclt_status;

    @FXML private Button btnclt_modifie;

    @FXML private Button btnexit;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        btnexit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                DBUtils.changeover(actionEvent,"logged_admin","ADMINISTRATOR");
            }
        });

        /**
         * THIS Button will permit the user to check a client information in the database that
         * it status
         * */

        btnclt_status.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                DBUtils.changeover(actionEvent,"checkstatus.fxml","CLIENT STATUS");
            }

        });

        btnclt_modifie.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                DBUtils.changeover(actionEvent,"clt_modifie_info.fxml","CLIENT MODIFICATION");

            }
        });

        btnexit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                DBUtils.changeover(actionEvent,"logged_admin.fxml","CLIENT MODIFICATION");
            }
        });
    }
}
