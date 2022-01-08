package com.example.frontend_javaproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class DBUtils {



    public static void changeover(ActionEvent event, String fxml){
        Parent root=null;

        try{
            FXMLLoader loader= new FXMLLoader(DBUtils.class.getResource(fxml));
            root =loader.load();
        }catch (IOException e){
            e.printStackTrace();
        }
        Stage stage =(Stage)((Node) event.getSource()).getScene().getWindow();
       // stage.setTitle();
        stage.setScene(new Scene(root));
        stage.show();

    }

    public static  void signUpAdmin(ActionEvent actionEvent,String admin_mat,String admin_name,String pwd) throws SQLException, IOException {
        Connection connection=null;
        PreparedStatement psInsert=null;
        PreparedStatement checkUserExist=null;
        ResultSet resultSet=null;

        try{
            connection = DriverManager.getConnection( "jdbc:mysql://localhost:3306/sanka", "root" , "" );
            checkUserExist= connection.prepareStatement("SELECT * FROM administrator WHERE admin_mat=?");
            checkUserExist.setString(1,admin_mat);
            resultSet=checkUserExist.executeQuery();
            if(resultSet.isBeforeFirst()){
                System.out.println("admin already Exist");
                Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setContentText("You cannot add this administrator");
                alert.show();
            }else{
                psInsert=connection.prepareStatement("INSERT INTO administrator(admin_mat,admin_name,pwd VALUES(?,?,?)");
                psInsert.setString(1,admin_mat);
                psInsert.setString(2,admin_name);
                psInsert.setString(3,pwd);
                psInsert.executeUpdate();


                changeover(actionEvent,"logged_admin.fxml");

            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try {
                if (resultSet != null || psInsert != null || checkUserExist != null) {
                    resultSet.close();
                    psInsert.close();
                    checkUserExist.close();
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        }

    }

    public static void logInUser(ActionEvent actionEvent,String admin_mat,String pwd) throws SQLException, IOException {
        Connection connection=null;
        PreparedStatement psInsert=null;
        PreparedStatement checkUserExist=null;
        ResultSet resultSet=null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root", "1430");
            checkUserExist = connection.prepareStatement("SELECT * FROM administrator WHERE Mat=?");
            checkUserExist.setString(1, admin_mat);
            resultSet = checkUserExist.executeQuery();
            if (resultSet.isBeforeFirst()) {
                System.out.println("User not found in database");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Provided credentialse are incorrect");
                alert.show();
            } else {
                while (resultSet.next()) {
                    String retrievepwd = resultSet.getString("Password");
                    String retrivename = resultSet.getString("Name");
                    if (retrievepwd.equals(pwd)) {
                        changeover(actionEvent, "logged_admin.fxml");

                    } else{
                        System.out.println("password did not match");
                        Alert alert=new Alert(Alert.AlertType.ERROR);
                        alert.setContentText("You cannot add this administrator");
                        alert.show();
                    }
                }


            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try {
                if (resultSet != null || psInsert != null || checkUserExist != null) {
                    resultSet.close();
                    psInsert.close();
                    checkUserExist.close();
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
    }
}


}
