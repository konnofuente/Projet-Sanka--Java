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

    @FXML private TextField tfadmin_mat; String mat=tfadmin_mat.getText();

    @FXML private TextField tfadmin_name; String name=tfadmin_name.getText();

    @FXML private TextField tfadmin_pwd; String pwd=tfadmin_pwd.getText();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        btncreate_admin.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(!tfadmin_mat.getText().trim().isEmpty() && !tfadmin_pwd.getText().trim().isEmpty() ){
                    try {
                        DBUtils.signUpAdmin(actionEvent,mat,name,pwd);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else{
                    System.out.println("please neter all information");
                    Alert alert=new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Please fill all your information to get Sign Up");
                    alert.show();
                }
            }
        });
    }
}
