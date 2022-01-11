package com.example.frontend_javaproject;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class signup_admincontroller implements Initializable {

    @FXML private Button btncreate_admin;

    @FXML private Button btnlogin; // this button will be serve to go to the login page

    @FXML private Button btnreturn;

    @FXML
    private TextField tfmat;
    @FXML
    private TextField tfname;
    @FXML
    private TextField tfpwd;

    public void initialize(URL url, ResourceBundle resourceBundle) {

        /**
         *  this action event handler will permit the user to go empty the textfield
         * */
        btnreturn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                tfmat.clear();
                tfname.clear();
                tfpwd.clear();
            }
        });


        /**
         *  this action event handler will permit the user to go the log in page
         * */
        btnlogin.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                DBUtils.changeover(actionEvent,"admin-login.fxml","LOG IN");
            }
        });

        /**
         *  this action event handler will permit ANd admit to create a new Administrator in the
         *  database
         * */
        btncreate_admin.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                if(!tfmat.getText().trim().isEmpty() && !tfpwd.getText().trim().isEmpty() ){
                    DBUtils.signUpAdmin(event,tfmat.getText(),tfname.getText(),tfpwd.getText());

                } else{
                    System.out.println("please enter all information");
                    Alert alert=new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("please fill in your information inorder to create adminstrator account  MR "+tfname.getText() +". !!!!");
                    alert.show();
                }
            }
        });
    }
}
