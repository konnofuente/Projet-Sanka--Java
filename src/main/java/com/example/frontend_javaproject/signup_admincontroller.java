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

    @FXML
    private TextField tfmat;
    @FXML
    private TextField tfname;
    @FXML
    private TextField tfpwd;

    public void initialize(URL url, ResourceBundle resourceBundle) {
        btncreate_admin.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(!tfmat.getText().trim().isEmpty() && !tfpwd.getText().trim().isEmpty() ){
                    try {
                        DBUtils.signUpAdmin(event,tfmat.getText().trim(),tfname.getText().trim(),tfpwd.getText().trim());
                    } catch (SQLException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else{
                    System.out.println("please enter all information");
                    Alert alert=new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Please fill all your information to get Sign Up");
                    alert.show();
                }
            }
        });
    }
}
