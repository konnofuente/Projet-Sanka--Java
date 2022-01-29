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
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.swing.text.TabableView;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Date;
import java.util.ResourceBundle;

public class updatecliniController implements Initializable {

    @FXML private Button btnadd;



    @FXML private Button btndelete;

    @FXML private Button btnrefresh;

    @FXML private TableView<Clinic> clinicTable;

    @FXML private TableColumn<Clinic,Integer> idCol;

    @FXML private TableColumn<Clinic,String> nameCol;

    @FXML private TableColumn<Clinic,Integer> qtyvaccCol;

    @FXML private TableColumn<Clinic,Integer> qtytasteCol;

    @FXML private TableColumn<Clinic,String> hospitalCol;

    @FXML private TableColumn<Clinic, Date> dateCol;

    @FXML
    private TextField tfsearch;

    ObservableList<Clinic> cliniclist = FXCollections.observableArrayList();

    /**Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/sanka", "root" , "" );
    PreparedStatement preparedStatement=null;
    ResultSet resultSet=null;
    String query=null;
    Clinic clinic=null;*/

    public updatecliniController() throws SQLException {
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        refresh();

        btnrefresh.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                refresh();
            }
        });

        btnadd.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    Parent parent = FXMLLoader.load(getClass().getResource("create_clinic.fxml"));
                    Scene scene=new Scene(parent);
                    Stage stage=new Stage();
                    stage.setScene(scene);
                    stage.initStyle(StageStyle.UTILITY);
                    stage.setTitle("Create Clinic");
                    stage.show();

                } catch (IOException e) {
                    e.printStackTrace();
                }
                refresh();
            }
        });

        btndelete.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                try {
                    DBUtils.deleteDB_clinic(clinicTable);
                } catch (SQLException e) {
<<<<<<< HEAD
                    e.printStackTrace();
                }
=======
<<<<<<< Updated upstream
                    e.printStackTrace();
                }
                /** try {
                    clinic = clinicTable.getSelectionModel().getSelectedItem();
                    query = "DELETE FROM clinic WHERE idclinic =" + clinic.getId();
                    preparedStatement = connection.prepareStatement(query);
                    preparedStatement.execute();
                    Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setContentText("The clinic chosed was succesfully deleted !!!!!!!!!");
                    alert.show();

                }catch (SQLException e){
=======
>>>>>>> Stashed changes
                    e.printStackTrace();
                }*/
>>>>>>> 162d297c6ea7460c30fec7a649bb8ed136d3a261

                refresh();
            }
        });



    }



    private void refresh()  {
        try{

            Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/sanka", "root" , "" );
            PreparedStatement preparedStatement=null;
            ResultSet resultSet=null;
            String query=null;
            Clinic clinic=null;

            cliniclist.clear();
        query="SELECT * FROM clinic";
        preparedStatement = connection.prepareStatement(query);
        resultSet=preparedStatement.executeQuery();

        while(resultSet.next()){
            cliniclist.add( new Clinic(
                    resultSet.getInt("idclinic"),
                    resultSet.getString("name"),
                    resultSet.getInt("qty_vacc"),
                    resultSet.getInt("qty_taste"),
                    resultSet.getString("hospital"),
                    resultSet.getDate("creation_date")
            ));

            clinicTable.setItems(cliniclist);
        }
        }catch (SQLException e){
            e.printStackTrace();
        }

        idCol.setCellValueFactory(new PropertyValueFactory<Clinic,Integer>("id"));
        nameCol.setCellValueFactory(new PropertyValueFactory<Clinic,String>("name"));
        qtyvaccCol.setCellValueFactory(new PropertyValueFactory<Clinic,Integer>("qtyvacc"));
        qtytasteCol.setCellValueFactory(new PropertyValueFactory<Clinic,Integer>("qtytaste"));
        hospitalCol.setCellValueFactory(new PropertyValueFactory<Clinic,String>("hospital"));
        dateCol.setCellValueFactory(new PropertyValueFactory<Clinic,Date>("date"));

        FilteredList<Clinic> filteredData =new FilteredList<>(cliniclist, b ->true);

        tfsearch.textProperty().addListener((observable,oldValue,newValue)->{
            filteredData.setPredicate(clinic -> {
                if (newValue.isEmpty() || newValue.isBlank() || newValue == null) {
                    return true;
                }
                String searchKeyword = newValue.toLowerCase();

                if(clinic.getId().toString().indexOf(searchKeyword)> -1) {
                    return true;//mean we found id
                }
                else
                    return false;//no match found
            });
        });

        SortedList<Clinic> sortData=new SortedList<>(filteredData);

        //bind sorted result with table
        sortData.comparatorProperty().bind(clinicTable.comparatorProperty());

        //apply filtered and sorted data to Table view
        clinicTable.setItems(sortData);

    }



}
