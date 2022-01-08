package com.example.frontend_javaproject;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.*;
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

                //int cni =Integer.parseInt(txtcni.getText());
                String name=txtname.getText();
                String nationality=txtnty.getText();
               //nt phone=Integer.parseInt(txtphone.getText());
                String status=txtstatus.getText();

                btnconfirm.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent actionEvent) {
                                try {
                                        Connection connection = DriverManager.getConnection(  "jdbc:mysql://localhost:3306/sanka", "root" , "" );
                                        Statement statement = connection.createStatement();
                                        ResultSet resultSet = statement.executeQuery( "select * from client");


                                        while(resultSet.next()){
                                                System.out.println(resultSet.getString("clientName"));
                                        }
                                        // create a sql date object so we can use it in our INSERT statement
                                        //alendar calendar = Calendar.getInstance();
                                        //  java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());

                                        // the mysql insert statement
                                        String query = " insert into client (idclient, clientName, nationality, phone, status)"
                                                + " values (?, ?, ?, ?, ?)";

                                        // create the mysql insert preparedstatement
                                        PreparedStatement preparedStmt = connection.prepareStatement(query);
                                        preparedStmt.setInt (1,4);
                                        preparedStmt.setString (2, name);
                                        preparedStmt.setString  (3, nationality);
                                        preparedStmt.setInt(4, 5);
                                        preparedStmt.setBoolean    (5, true);
                                        // preparedStmt.setDate   (6, startDate);

                                        // execute the preparedstatement
                                        preparedStmt.execute();

                                        connection.close();
                                }
                                catch (Exception e)
                                {
                                        System.err.println("Got an exception!");
                                        System.err.println(e.getMessage());
                                }
                        }
                });
        }
}
