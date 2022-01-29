package com.example.frontend_javaproject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Date;
import java.util.ResourceBundle;

public class updateclientTaste implements Initializable {
    @FXML
    private Button btnadd;

    @FXML
    private Button btnrefresh;

    @FXML
    private Button btnprint;

    @FXML
    private Button btnsearch;

    @FXML
    private TextField tfsearch;

    @FXML
    private Button btndelete;

    @FXML private TableView<TClient> clientTable;

    @FXML private TableColumn<TClient, Integer> nicCol;

    @FXML private TableColumn<TClient, String> nameCol;

    @FXML private TableColumn<TClient, String> nationalityCol;

    @FXML private TableColumn<TClient, Integer> phoneCol;

    @FXML private TableColumn<TClient, Integer> gadgetCol;

    @FXML private TableColumn<TClient, String> statusCol;

    @FXML private TableColumn<TClient, Date> dateCol;

    Date date=new Date();


    ObservableList<TClient> clientlist= FXCollections.observableArrayList();


    public updateclientTaste() throws SQLException {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {





            refreshTable(); // this function help us to refreash the table


        /**
         * btnadd permit use to open the vaccination winddow inorder to
         * re_vacciante some one back if his info was not found in the database
         * */
        btnadd.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    Parent parent = FXMLLoader.load(getClass().getResource("test.fxml"));
                    Scene scene=new Scene(parent);
                    Stage stage=new Stage();
                    stage.setScene(scene);
                    stage.initStyle(StageStyle.UTILITY);

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
                    DBUtils.deleteDB_clienttaste(clientTable);
                } catch (SQLException e) {
                    e.printStackTrace();
                }

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
            query = "SELECT * FROM client_taste";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                clientlist.add(new TClient(
                        resultSet.getInt("NIC"),
                        resultSet.getString("name"),
                        resultSet.getString("nationality"),
                        resultSet.getInt("tel_number"),
                        resultSet.getInt("gadget_number"),
                        resultSet.getString("status"),
                        resultSet.getDate("date_taste")
                ));
                clientTable.setItems(clientlist);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        nicCol.setCellValueFactory(new PropertyValueFactory<com.example.frontend_javaproject.TClient,Integer>("nicCol"));
        nameCol.setCellValueFactory(new PropertyValueFactory<com.example.frontend_javaproject.TClient,String>("nameCol"));
        nationalityCol.setCellValueFactory(new PropertyValueFactory<com.example.frontend_javaproject.TClient,String>("nationalityCol"));
        phoneCol.setCellValueFactory(new PropertyValueFactory<com.example.frontend_javaproject.TClient,Integer>("phoneCol"));
        gadgetCol.setCellValueFactory(new PropertyValueFactory<com.example.frontend_javaproject.TClient,Integer>("gadgetCol"));
        statusCol.setCellValueFactory(new PropertyValueFactory<com.example.frontend_javaproject.TClient,String>("statusCol"));
        dateCol.setCellValueFactory(new PropertyValueFactory<com.example.frontend_javaproject.TClient,Date>("dateCol"));

        //initialise listenner for filtered the list
        FilteredList<TClient> filteredData =new FilteredList<>(clientlist, b ->true);

        tfsearch.textProperty().addListener((observable,oldValue,newValue)->{
            filteredData.setPredicate(client -> {
                if (newValue.isEmpty() || newValue.isBlank() || newValue == null) {
                    return true;
                }
                String searchKeyword = newValue.toLowerCase();

                if(client.getNicCol().toString().indexOf(searchKeyword)> -1){
                    return true;//mean we found id

                }else if(client.getNameCol().toLowerCase().indexOf(searchKeyword) > -1){
                    return true;//mean we found name
                }else if(client.getNationalityCol().toLowerCase().indexOf(searchKeyword) > -1){
                    return true;//mean we found name
                }
                else if(client.getGadgetCol().toString().indexOf(searchKeyword)> -1){
                    return true;//mean we found name
                }
                else if(client.getPhoneCol().toString().indexOf(searchKeyword) > -1){
                    return true;//mean we found name
                }
                else
                    return false;//no match found
            });
        });

        SortedList<TClient> sortData=new SortedList<>(filteredData);

        //bind sorted result with table
        sortData.comparatorProperty().bind(clientTable.comparatorProperty());

        //apply filtered and sorted data to Table view
        clientTable.setItems(sortData);

    }



}
