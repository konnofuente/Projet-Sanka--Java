package com.example.frontend_javaproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
import java.util.Calendar;
import java.util.concurrent.atomic.AtomicReference;

public class DBUtils {

    /**
     */

    /**
     * THE EXIT FUNCTION THAT WILL BE USE TO  EXIT THE SYSTEM
     */
    public static void exit() {
        System.exit(0);
    }

    /**
     * CHANGEOVER FUNCTION IS THE FUNCTION THAT LEAD TO THE INTERCHANGE OF SCENE(INTERPHASES)
     * FROM WANT TO ANTHER WITH PARAMATER AS FOLLOW
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

    /**
     * CHANGEHIGH DOES THE THE JOB AS CHANGEOVER BUT WITH ANS INCREASE IN SIZE OF THE SCENE
     */
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
        stage.setResizable(true);
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
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sanka", "root", "1234");
            Statement statement = connection.createStatement();
            PreparedStatement checkUserExist = null;
            ResultSet resultSet=null;
            checkUserExist = connection.prepareStatement("SELECT * FROM client_vaccine WHERE NIC=?");
            checkUserExist.setInt(1, nic);
            resultSet = checkUserExist.executeQuery();
                //THIS IF CONDITION CHECK IF THE USER IS FOUND IN THE DATABASE
            if (resultSet.isBeforeFirst()) {
                System.out.println("client already Exist");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("You cannot Vaccinate some who is Already vaccinated !!!!!!!!!");
                alert.show();
            } else

            {//WE USE THE CALANDER FUNCTION ONORDER TO GET THE REAL TIME DATE OF THE VACCINATION
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
                String query2="UPDATE clinic SET qty_vacc=qty_vacc-1 WHERE (idclinic = 1)";
                PreparedStatement preparedStatement2=connection.prepareStatement(query2);
                preparedStatement2.execute();

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

    /**
     * CHANGEOVERCARD IS THE FUNCTION THAT CARRY THE INFORMATION OF A CLIENT WHEN VACCINATED AND
     * TRANSFER IT TO A SCENE THAT WILL BE USE TO GENERATE A VACCINATION CARD
     */
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
            vaccination_cardController.setinfovaccination(Pidclient,Pname,Page,Pnationality,Pproffesion,Ptel,starDate);
            Scene scene=new Scene(root,1000,600);
            Stage stage =new Stage();
            stage.setScene(scene);


            stage.show();

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * CHANGEOVERCARDTEST IS THE FUNCTION THAT CARRY THE INFORMATION OF A CLIENT WHEN TASTED AND
     * TRANSFER IT TO A SCENE THAT WILL BE USE TO GENERATE A TEST CARD
     */
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
            Scene scene=new Scene(root,1000,600);
            Stage stage =new Stage();
            stage.setScene(scene);


            stage.show();

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     the client taste function will be use to send a client info imto the databse before a taste
     */
    public static  void clienttaste (ActionEvent actionEvent,Integer nic,String name,String nationality,Integer tel,Integer N_gadget,String status)
    {

        try {
            Connection connection = DriverManager.getConnection(  "jdbc:mysql://localhost:3306/sanka", "root" , "1234" );
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery( "select * from client_taste");



            // create a sql date object so we can use it in our INSERT statement
            Calendar calendar = Calendar.getInstance();
            java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());

            // the mysql insert statement
            String query = " insert into client_taste (NIC,name,nationality,tel_number,gadget_number,status,date_taste)"
                    + " values (?, ?, ?, ?, ?, ?, ?)";

                    //UPDATE `sanka`.`clinic` SET `qty_vacc` = '3', `qty_taste` = '3' WHERE (`idclinic` = '1');
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
            String query2="UPDATE clinic SET qty_taste=qty_taste-1 WHERE (idclinic = 1)";
            PreparedStatement preparedStatement2=connection.prepareStatement(query2);
            preparedStatement2.execute();

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
            Connection connection = DriverManager.getConnection(  "jdbc:mysql://localhost:3306/sanka", "root" , "1234" );
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
            connection = DriverManager.getConnection( "jdbc:mysql://localhost:3306/sanka", "root" , "1234" );
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
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sanka", "root", "1234");
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

    /**
     * deleteDB_client IS A FUNCTION THAT GOES AND DELETE A CLIENT INTO THE VACCINATED TABLE IN
     * THE THE DATABASE
     */
    public static void deleteDB_client(TableView<Client> clientTable) throws SQLException {
        String query=null;
        Connection connection =  DriverManager.getConnection(  "jdbc:mysql://localhost:3306/sanka", "root" , "1234" );;
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

    /**
     * deleteDB_clinic IS A FUNCTION THAT GOES AND DELETE A CLINIC INTO THE CLINIC TABLE IN
     *   THE THE DATABASE
     */
    public static void deleteDB_clinic(TableView<Clinic> clinicTable) throws SQLException {
        String query=null;
        Connection connection =  DriverManager.getConnection(  "jdbc:mysql://localhost:3306/sanka", "root" , "1234" );;
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

    /**
     * deleteDB_clienttaste IS A FUNCTION THAT GOES AND DELETE A CLIENT TASTED INTO THE TASTED TABLE IN
     *   THE THE DATABASE
     */
    public static void deleteDB_clienttaste(TableView<TClient> clientTable) throws SQLException{
        String query=null;
        Connection connection =  DriverManager.getConnection(  "jdbc:mysql://localhost:3306/sanka", "root" , "1234" );;
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

    /**
     * updatestock iT WILL GO TO THE DATABASE AND INCREASE THE QUANTITY OF TASTE AND VACCINE AVAILABLE INTO
     * THE CLINIC TABLE DEPENDING ON THE CLINIC ID
     */
    public static void updatestock(ActionEvent actionEvent,Integer idclinic,Integer vaccine,Integer taste) {
        Connection connection=null;
        PreparedStatement psInsert=null;
        PreparedStatement checkUserExist=null;
        ResultSet resultSet=null;

        try{
            connection = DriverManager.getConnection( "jdbc:mysql://localhost:3306/sanka", "root" , "1234" );
            checkUserExist= connection.prepareStatement("SELECT * FROM clinic WHERE idclinic=?");
            checkUserExist.setInt(1,idclinic);
            resultSet=checkUserExist.executeQuery();
            if(!resultSet.isBeforeFirst()){
                System.out.println("Clinic does not Exist");
                Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setContentText("You cannot increase a stock of a clinic that does not exist\n Re-enter a corrrect Id");
                alert.show();
            }
            else
            {
                String query = " UPDATE clinic SET qty_vacc=qty_vacc +"+vaccine+" , qty_taste=qty_taste + "+taste+" WHERE (idclinic = "+idclinic+")";
                PreparedStatement preparedStatement=connection.prepareStatement(query);
                preparedStatement.execute();

                Alert alert =new Alert(Alert.AlertType.CONFIRMATION);
                alert.setContentText("The Clinic With ID "+idclinic+" has been successfully Editted!!!!!!");
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
     * deleteDB_clienttaste IS A FUNCTION THAT GOES AND DELETE A CLIENT TASTED INTO THE TASTED TABLE IN
     *   THE THE DATABASE
     */

    /**
     * countValue the value of row or item in the database depending on the query
     */
    public static int CountValue(String query) {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        int value = 0;
        try{
            connection = DriverManager.getConnection( "jdbc:mysql://localhost:3306/sanka", "root" , "1234" );
            preparedStatement=connection.prepareStatement(query);
            resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
                value++;
            }

        } catch (Exception e)
        {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
        return value;
    }

    public static void printTastecard(ActionEvent actionEvent,TableView<Client> clientTable) {

        Client client =null;

        client=clientTable.getSelectionModel().getSelectedItem(); // here the client will work with the row that was selected
        DBUtils.changeOvercard(actionEvent,"vaccination_card.fxml","VACCINATION CARD",client.getNicCol().toString(),client.getNameCol(),client.getAgeCol().toString(),client.getNationalityCol(),client.getProffesionCol(),client.getPhoneCol().toString());

    }
}















