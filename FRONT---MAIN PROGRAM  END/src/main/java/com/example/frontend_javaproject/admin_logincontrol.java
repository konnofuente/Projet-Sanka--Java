package com.example.frontend_javaproject;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
//
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class admin_logincontrol implements Initializable {

    @FXML private Button btnadd_admin;

    @FXML private Button btn_reset;

    @FXML private Button btnlogin_admin;

    @FXML private Button btnreturn;

    @FXML private TextField tfadmin_mat;

    @FXML private TextField tfadmin_pwd;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        btn_reset.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                tfadmin_pwd.clear();
                tfadmin_mat.clear();

            }
        });

        btnreturn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                DBUtils.changeover(actionEvent,"mainpage.fxml","WELCOME TO MAIN PAGE");
            }
        });


        btnlogin_admin.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (tfadmin_mat.getText().trim().isEmpty() || tfadmin_pwd.getText().trim().isEmpty()) {


                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setContentText("Please enter the Matricule and password");
                    alert.show();

                } else {

                    //  DBUtils.logInUser(actionEvent,tfadmin_mat.getText(),tfadmin_pwd.getText());
                    DBUtils.changeover(actionEvent, "logged_admin.fxml", "ADMINISTRATION");


                }
            }
        });

        btnadd_admin.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
                alert.setContentText("You Be directed to Creat Admin");
                alert.show();

                DBUtils.changeover(actionEvent,"signup_admin.fxml","SIGN UP PAGE");
            }
        });

    }
}