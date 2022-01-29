package com.example.frontend_javaproject;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class testcontroller implements Initializable {
    @FXML private Button btnpositive;

    @FXML private Button btnnegative;



    @FXML private Button btnexit;

    @FXML private Button btnreturn;

    @FXML private TextField tfnic ;

    @FXML private TextField tfname;

    @FXML private TextField tfnationality ;

    @FXML private TextField tftel ;

    @FXML private TextField tfage ;

    @FXML private TextField tfproffesion ;

    //@FXML private TextField tfprof;

    @FXML private TextField  tfgadget_num;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        //Integer.parseInt(txtcni.getText())

        btnpositive.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                DBUtils.clienttaste(actionEvent,Integer.parseInt(tfnic.getText()),tfname.getText(),tfnationality.getText(),Integer.parseInt(tftel.getText()),Integer.parseInt(tfgadget_num.getText()),"Positive");
                DBUtils.changeOvercardtest(actionEvent,"test_card.fxml","TEST CARD",tfnic.getText(),tfname.getText(),tfage.getText(),tfnationality.getText(),tfproffesion.getText(),tftel.getText(),tfgadget_num.getText(),"POSITIVE",null);
                reset();
            }
        });

        btnnegative.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                DBUtils.clienttaste(actionEvent,Integer.parseInt(tfnic.getText()),tfname.getText(),tfnationality.getText(),Integer.parseInt(tftel.getText()),Integer.parseInt(tfgadget_num.getText()),"Negative");
                DBUtils.changeOvercardtest(actionEvent,"test_card.fxml","TEST CARD",tfnic.getText(),tfname.getText(),tfage.getText(),tfnationality.getText(),tfproffesion.getText(),tftel.getText(),tfgadget_num.getText(),null,"NEGATIVE");
                reset();
            }
        });




        btnexit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                DBUtils.changeover(actionEvent,"2servicepage.fxml","CLIENT MANAGEMENT");
            }
        });


        btnreturn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                DBUtils.changeover(actionEvent,"2servicepage.fxml","CLIENT MANAGEMENT");
            }
        });

    }

    private void reset(){
        tfnic.clear();
        tfnationality.clear();
        tfname.clear();
        tfproffesion.clear();
        tfgadget_num.clear();
        tftel.clear();
    }
}
