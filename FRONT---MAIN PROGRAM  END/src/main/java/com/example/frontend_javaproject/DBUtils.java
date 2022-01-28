package com.example.frontend_javaproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.sql.*;
import java.util.Calendar;
import java.util.concurrent.atomic.AtomicReference;

public class DBUtils {


    public static void exit() {
        System.exit(0);
    }



    /**sdsddzxcckvvlvlvkvkkkkfffddssaaaassdddddddd
     the changover permit the tranfer from one window to another
     */
    public static void changeover(ActionEvent actionevent, String fxml,String title){
        Parent root=null;
        AtomicReference<Double> x = new AtomicReference<>((double) 0);
        AtomicReference<Double> y = new AtomicReference<>((double) 0);
        try{
            FXMLLoader loader= new FXMLLoader(DBUtils.class.getResource(fxml));
            root =loader.load();
        }catch (IOException e){
            e.printStackTrace();
        }

        Stage stage =(Stage)((Node) actionevent.getSource()).getScene().getWindow();
        stage.setTitle(title);
        stage.setScene(new Scene(root,800,550));
        root.setOnMousePressed(event ->{
            x.set(event.getSceneX());
            y.set(event.getSceneY());
        });

        root.setOnMouseDragged(event ->{
            stage.setX(event.getScreenX()- x.get());
            stage.setY(event.getScreenY()- y.get());
        });

        stage.show();

    }

    public static void changehigh(ActionEvent actionevent, String fxml,String title){
        Parent root=null;
        AtomicReference<Double> x = new AtomicReference<>((double) 0);
        AtomicReference<Double> y = new AtomicReference<>((double) 0);
        try{
            FXMLLoader loader= new FXMLLoader(DBUtils.class.getResource(fxml));
            root =loader.load();
        }catch (IOException e){
            e.printStackTrace();
        }

        Stage stage =(Stage)((Node) actionevent.getSource()).getScene().getWindow();
        stage.setTitle(title);
        stage.setScene(new Scene(root,1000,600));
        root.setOnMousePressed(event ->{
            x.set(event.getSceneX());
            y.set(event.getSceneY());
        });

        root.setOnMouseDragged(event ->{
            stage.setX(event.getScreenX()- x.get());
            stage.setY(event.getScreenY()- y.get());
        });

        stage.show();

    }

    /**
    the client info function will be use to send a client info imto the databse
     */
    public static  void clientinfo (ActionEvent actionEvent,Integer nic,String name,String nationality,Integer phone,String profession,Integer age)
    {

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sanka", "root", "");
            Statement statement = connection.createStatement();
            PreparedStatement checkUserExist = null;
            ResultSet resultSet=null;
            checkUserExist = connection.prepareStatement("SELECT * FROM client_vaccine WHERE NIC=?");
            checkUserExist.setInt(1, nic);
            resultSet = checkUserExist.executeQuery();

            if (resultSet.isBeforeFirst()) {
                System.out.println("client already Exist");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("You cannot Vaccinate some who is Already vaccinated !!!!!!!!!");
                alert.show();
            } else
            {

                // create a sql date object so we can use it in our INSERT statement
                Calendar calendar = Calendar.getInstance();
                java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());

                // the mysql insert statement
                String query = " insert into client_vaccine (NIC, name, nationality, phone, proffesion, age,vac_date)"
                        + " values (?, ?, ?, ?, ?,?,?)";

                // create the mysql insert preparedstatement
                PreparedStatement preparedStmt = connection.prepareStatement(query);
                preparedStmt.setInt(1, nic);
                preparedStmt.setString(2, name);
                preparedStmt.setString(3, nationality);
                preparedStmt.setInt(4, phone);
                preparedStmt.setString(5, profession);
                preparedStmt.setInt(6,age);
                preparedStmt.setDate(7, startDate);

                // execute the preparedstatement
                preparedStmt.execute();

                connection.close();
                //DBUtils.changeover(actionEvent,"2servicepage.fxml","CLIENT MANAGEMENT");

            }
        }
        catch (Exception e)
        {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }


    }

    public static void changeOvercard(ActionEvent actionevent, String fxml, String title, String Pidclient, String Pname, String Page, String Pnationality, String Pproffesion, String Ptel) {
        Parent root=null;
        AtomicReference<Double> x = new AtomicReference<>((double) 0);
        AtomicReference<Double> y = new AtomicReference<>((double) 0);

        Calendar calendar = Calendar.getInstance();
        java.util.Date starDate=new java.sql.Date(calendar.getTime().getTime());
        try{
            FXMLLoader loader= new FXMLLoader(DBUtils.class.getResource(fxml));
            root =loader.load();
            Vaccination_cardController vaccination_cardController=loader.getController();
<<<<<<< Updated upstream
            vaccination_cardController.setinfo(Pidclient,Pname,Page,Pnationality,Pproffesion,Ptel,starDate);
=======
            vaccination_cardController.setinfovaccination(Pidclient,Pname,Page,Pnationality,Pproffesion,Ptel,starDate);
>>>>>>> Stashed changes
            Scene scene=new Scene(root,700,480);
            Stage stage =new Stage();
            stage.setScene(scene);


            stage.show();

        }catch (IOException e){
            e.printStackTrace();
        }

       // Stage stage =(Stage)((Node) actionevent.getSource()).getScene().getWindow();


    }

<<<<<<< Updated upstream
=======

    public static void changeOvercardtest(ActionEvent actionevent, String fxml, String title, String Pidclient, String Pname, String Page, String Pnationality, String Pproffesion, String Ptel,String PgadgetNum,String Ppositive,String Pnegative) {
        Parent root=null;
        AtomicReference<Double> x = new AtomicReference<>((double) 0);
        AtomicReference<Double> y = new AtomicReference<>((double) 0);

        Calendar calendar = Calendar.getInstance();
        java.util.Date starDate=new java.sql.Date(calendar.getTime().getTime());
        try{
            FXMLLoader loader= new FXMLLoader(DBUtils.class.getResource(fxml));
            root =loader.load();
            Test_cardController test_cardController=loader.getController();
            test_cardController.setinfotest(Pidclient,Pname,Page,Pnationality,Pproffesion,Ptel,starDate,PgadgetNum,Ppositive,Pnegative);
            Scene scene=new Scene(root,700,480);
            Stage stage =new Stage();
            stage.setScene(scene);


            stage.show();

        }catch (IOException e){
            e.printStackTrace();
        }

        // Stage stage =(Stage)((Node) actionevent.getSource()).getScene().getWindow();


    }

>>>>>>> Stashed changes
    /**
     the client taste function will be use to send a client info imto the databse before a taste
     */
    public static  void clienttaste (ActionEvent actionEvent,Integer nic,String name,String nationality,Integer tel,Integer N_gadget,String status)
    {

        try {
            Connection connection = DriverManager.getConnection(  "jdbc:mysql://localhost:3306/sanka", "root" , "" );
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery( "select * from client_taste");



            // create a sql date object so we can use it in our INSERT statement
            Calendar calendar = Calendar.getInstance();
            java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());

            // the mysql insert statement
            String query = " insert into client_taste (NIC,name,nationality,tel_number,gadget_number,status,date_taste)"
                    + " values (?, ?, ?, ?, ?, ?, ?)";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt (1,nic);
            preparedStmt.setString (2,name);
            preparedStmt.setString  (3, nationality);
            preparedStmt.setInt(4, tel);
            preparedStmt.setInt   (5, N_gadget);
            preparedStmt.setString (6,status);
            preparedStmt.setDate   (7,startDate);

            // execute the preparedstatement
            preparedStmt.execute();

            DBUtils.changeover(actionEvent,"2servicepage.fxml","CLIENT MANAGEMENT");


            connection.close();
        }
        catch (Exception e)
        {


            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }


    }

    /**
     the create clinic will help us to create a clinic in the database
     */
    public static  void createclinic (ActionEvent actionEvent,Integer id,String name,Integer qty_vacc,Integer qty_taste,String hospital)
    {

        try {
            Connection connection = DriverManager.getConnection(  "jdbc:mysql://localhost:3306/sanka", "root" , "" );
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery( "select * from clinic");


            while(resultSet.next()){
                System.out.println(resultSet.getString("idclinic"));
            }
            // create a sql date object so we can use it in our INSERT statement
            Calendar calendar = Calendar.getInstance();
            java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());

            // the mysql insert statement
            String query = " insert into clinic (idclinic,name,qty_vacc,qty_taste,hospital,creation_date)"
                    + " values (?, ?, ?, ?, ?, ?)";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt (1,id);
            preparedStmt.setString (2,name);
            preparedStmt.setInt  (3,qty_vacc);
            preparedStmt.setInt(4, qty_taste);
            preparedStmt.setString   (5, hospital);
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

    /**
     the signupaddmin will help us to create an admin into the database
     */
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
                String query = " insert into administrator (admin_mat,admin_name,admin_password)" + "values (?,?,?)";

                psInsert=connection.prepareStatement(query) ;
                psInsert.setString(1,admin_mat);
                psInsert.setString(2,admin_name);
                psInsert.setString(3,pwd);
                psInsert.executeUpdate();
                Alert alert =new Alert(Alert.AlertType.CONFIRMATION);
                alert.setContentText("The admin "+admin_name+" has been successfully Created!!!!!!");
                alert.show();

                connection.close();


            }
        } catch (Exception e)
        {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }


    }

    /**
     the logInUser permit the admin to log in into the administrator setting
     */
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
                    String retrievepwd = resultSet.getString("admin_password");
                    String retrivename = resultSet.getString("admin_name");
                    if (retrievepwd.equals(pwd)) {
                        Alert alert =new Alert(Alert.AlertType.CONFIRMATION);
                        alert.setContentText("log in successfull Mr " +retrivename+".");
                        alert.show();
                        changehigh(actionEvent, "sliderAdmin_Menu.fxml","ADMINISTRATION");

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




    public static void deleteDB_client(TableView<Client> clientTable) throws SQLException {
        String query=null;
        Connection connection =  DriverManager.getConnection(  "jdbc:mysql://localhost:3306/sanka", "root" , "" );;
        PreparedStatement preparedStatement =null;
        ResultSet resultSet =null;
        Client client =null;

        try {
            client=clientTable.getSelectionModel().getSelectedItem(); // here the client will work with the row that was selected
            query="DELETE FROM client_vaccine WHERE NIC ="+client.getNicCol();// a Query is made inorder to delete it by using it nic
            preparedStatement=connection.prepareStatement(query);
            preparedStatement.execute();
            Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("The Client chosed was succesfully deleted !!!!!!!!!");
            alert.show();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    public static void deleteDB_clinic(TableView<Clinic> clinicTable) throws SQLException {
        String query=null;
        Connection connection =  DriverManager.getConnection(  "jdbc:mysql://localhost:3306/sanka", "root" , "" );;
        PreparedStatement preparedStatement =null;
        ResultSet resultSet =null;
        Clinic clinic =null;

        try {
            clinic = clinicTable.getSelectionModel().getSelectedItem(); // here the client will work with the row that was selected
            query="DELETE FROM clinic WHERE idclinic ="+clinic.getId();// a Query is made inorder to delete it by using it nic
            preparedStatement=connection.prepareStatement(query);
            preparedStatement.execute();
            Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("The Clinic chosed was succesfully deleted !!!!!!!!!");
            alert.show();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
<<<<<<< Updated upstream
=======

    public static void deleteDB_clienttaste(TableView<TClient> clientTable) throws SQLException{
        String query=null;
        Connection connection =  DriverManager.getConnection(  "jdbc:mysql://localhost:3306/sanka", "root" , "" );;
        PreparedStatement preparedStatement =null;
        ResultSet resultSet =null;
        TClient tclient =null;

        try {
            tclient=clientTable.getSelectionModel().getSelectedItem(); // here the client will work with the row that was selected
            query="DELETE FROM client_taste WHERE NIC ="+tclient.getNicCol();// a Query is made inorder to delete it by using it nic
            preparedStatement=connection.prepareStatement(query);
            preparedStatement.execute();
            Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("The Client With "+tclient.getNicCol()+" chosed was succesfully deleted !!!!!!!!!");
            alert.show();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
>>>>>>> Stashed changes
}















