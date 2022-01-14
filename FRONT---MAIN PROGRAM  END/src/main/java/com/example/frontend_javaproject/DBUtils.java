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
import java.util.Calendar;

public class DBUtils {


    private static ActionEvent actionEvent;
    private static Integer cni;
    private static String name;
    private static String nationality;
    private static Integer phone;
    private static String status;

    public static void changeover(ActionEvent event, String fxml,String title){
        Parent root=null;

        try{
            FXMLLoader loader= new FXMLLoader(DBUtils.class.getResource(fxml));
            root =loader.load();
        }catch (IOException e){
            e.printStackTrace();
        }
        Stage stage =(Stage)((Node) event.getSource()).getScene().getWindow();
        stage.setTitle(title);
        stage.setScene(new Scene(root,800,550));
        stage.show();

    }




    /**
    the client info function will be use to send a client info imto the databse
     */
    public static  void clientinfo (ActionEvent actionEvent,Integer cni,String name,String nationality,Integer phone,String status)
    {

        try {
            Connection connection = DriverManager.getConnection(  "jdbc:mysql://localhost:3306/sanka", "root" , "" );
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery( "select * from client");


            while(resultSet.next()){
                System.out.println(resultSet.getString("clientName"));
            }
            // create a sql date object so we can use it in our INSERT statement
            Calendar calendar = Calendar.getInstance();
            java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());

            // the mysql insert statement
            String query = " insert into client (idclient, clientName, nationality, phone, status,vac_date)"
                    + " values (?, ?, ?, ?, ?,?)";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt (1,cni);
            preparedStmt.setString (2,name);
            preparedStmt.setString  (3, nationality);
            preparedStmt.setInt(4, phone);
            preparedStmt.setString    (5, status);
            preparedStmt.setDate   (6,startDate);

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

    public static  void signUpAdmin(ActionEvent actionEvent,String admin_mat,String admin_name,String pwd)  {
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
                alert.setContentText("You cannot add this administrator\n An admin already Exist with Same Matriculation!!!!!!!!!");
                alert.show();
            }
            else
            {
                String query = " insert into administrator (admin_mat,admin_name,password)" + "values (?,?,?)";

                psInsert=connection.prepareStatement(query) ;
                psInsert.setString(1,admin_mat);
                psInsert.setString(2,admin_name);
                psInsert.setString(3,pwd);
                psInsert.executeUpdate();

                connection.close();


            }
        } catch (Exception e)
        {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }


    }




    public static void logInUser(ActionEvent actionEvent,String admin_mat,String pwd) throws SQLException, IOException {
        Connection connection=null;
        PreparedStatement psInsert=null;
        PreparedStatement checkUserExist=null;
        ResultSet resultSet=null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sanka", "root", "");
            checkUserExist = connection.prepareStatement("SELECT * FROM administrator WHERE admin_mat =?");
            checkUserExist.setString(1, admin_mat);
            resultSet = checkUserExist.executeQuery();
            if (!resultSet.isBeforeFirst()) {
                System.out.println("User not found in database");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Provided credentialse are incorrect \n User not Found in program");
                alert.show();
            } else {
                while (resultSet.next()) {
                    String retrievepwd = resultSet.getString("password");
                    String retrivename = resultSet.getString("admin_name");
                    if (retrievepwd.equals(pwd)) {
                        Alert alert =new Alert(Alert.AlertType.CONFIRMATION);
                        alert.setContentText("log in successfull Mr " +retrivename+".");
                        alert.show();
                        changeover(actionEvent, "logged_admin.fxml","ADMINISTRATION");

                    } else{
                        System.out.println("password did not match");
                        Alert alert=new Alert(Alert.AlertType.ERROR);
                        alert.setContentText("Sorry password did not match \n Re-Enter Password!!!!!");
                        alert.show();
                    }
                }


            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try {
                if (resultSet != null /* || psInsert != null*/ || checkUserExist != null) {
                    resultSet.close();
                    //psInsert.close();
                    checkUserExist.close();
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
    }
}


}