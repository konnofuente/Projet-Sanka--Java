package com.example.frontend_javaproject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Date;
import java.util.ResourceBundle;

public class updateclientcontroller implements Initializable {

    @FXML
    private Button btnadd;

    @FXML
    private Button btnrefresh;



    @FXML
    private Button btnprint;

    @FXML
    private Button btndelete;

    @FXML private TableView<Client> clientTable;

    @FXML private TableColumn<Client, Integer> nicCol;

    @FXML private TableColumn<Client, String> nameCol;

    @FXML private TableColumn<Client, String> nationalityCol;

    @FXML private TableColumn<Client, Integer> phoneCol;

    @FXML private TableColumn<Client, String> proffesionCol;

    @FXML private TableColumn<Client, Date> dateCol;

    Date date=new Date();

    /**String query=null;
    Connection connection =  DriverManager.getConnection(  "jdbc:mysql://localhost:3306/sanka", "root" , "" );;
    PreparedStatement preparedStatement =null;
    ResultSet resultSet =null;
    Client client =null;
     */
    /**
     * the client list hold the data from the client class to the
     * */
   ObservableList<Client> clientlist= FXCollections.observableArrayList();


    public updateclientcontroller() throws SQLException {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {



        try {
            Loaddata(); // this function help us to take the infor from the client class and load it to our clientTableview
            refreshTable(); // this function help us to refreash the table
        } catch (SQLException e) {
            e.printStackTrace();
        }

        /**
         * btnadd permit use to open the vaccination winddow inorder to
         * re_vacciante some one back if his info was not found in the database
         * */
        btnadd.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    Parent parent = FXMLLoader.load(getClass().getResource("vaccination.fxml"));
                    Scene scene=new Scene(parent);
                    Stage stage=new Stage();
                    stage.setScene(scene);
                    stage.initStyle(StageStyle.UTILITY);
                    stage.setTitle("Vaccination");
                    stage.show();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        btndelete.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                try {
                    DBUtils.deleteDB_client(clientTable);
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                /**  try {
                    client=clientTable.getSelectionModel().getSelectedItem(); // here the client will work with the row that was selected
                    query="DELETE FROM client_vaccine WHERE NIC ="+client.getNicCol();// a Query is made inorder to delete it by using it nic
                    preparedStatement=connection.prepareStatement(query);
                    preparedStatement.execute();
                    refreshTable();// then we refresh back the table
                    Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setContentText("The Client chosed was succesfully deleted !!!!!!!!!");
                    alert.show();
                } catch (SQLException e) {
                    e.printStackTrace();
                }*/

            }
        });

        btnrefresh.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                refreshTable();
            }
        });


    }
    /**
     * this are the function that will be use in the progra we have the
     * REFRESHTABLE: It permit use to refresh the table view of our program
     *
     * LOADDATA: it load data from the client class to the TableView to the program
     * */

    @FXML private void refreshTable(){

        try {
            String query=null;
            Connection connection =  DriverManager.getConnection(  "jdbc:mysql://localhost:3306/sanka", "root" , "" );;
            PreparedStatement preparedStatement =null;
            ResultSet resultSet =null;
            Client client =null;

           // connection = DriverManager.getConnection(  "jdbc:mysql://localhost:3306/sanka", "root" , "" );
            clientlist.clear();
            query = "SELECT * FROM client_vaccine";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                clientlist.add(new Client(
                        resultSet.getInt("NIC"),
                        resultSet.getString("name"),
                        resultSet.getString("nationality"),
                        resultSet.getInt("phone"),
                        resultSet.getString("proffesion"),
                        resultSet.getDate("vac_date")
                ));
                clientTable.setItems(clientlist);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    private void Loaddata() throws SQLException {



        nicCol.setCellValueFactory(new PropertyValueFactory<com.example.frontend_javaproject.Client,Integer>("nicCol"));
         nameCol.setCellValueFactory(new PropertyValueFactory<com.example.frontend_javaproject.Client,String>("nameCol"));
        nationalityCol.setCellValueFactory(new PropertyValueFactory<com.example.frontend_javaproject.Client,String>("nationalityCol"));
        phoneCol.setCellValueFactory(new PropertyValueFactory<com.example.frontend_javaproject.Client,Integer>("phoneCol"));
        proffesionCol.setCellValueFactory(new PropertyValueFactory<com.example.frontend_javaproject.Client,String>("proffesionCol"));
        dateCol.setCellValueFactory(new PropertyValueFactory<com.example.frontend_javaproject.Client,Date>("dateCol"));


    }



    @FXML private void research(){
        
    }



}
