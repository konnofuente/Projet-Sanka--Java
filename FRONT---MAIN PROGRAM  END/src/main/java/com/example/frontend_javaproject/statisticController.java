package com.example.frontend_javaproject;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import org.w3c.dom.Text;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class statisticController implements Initializable {

    @FXML
    private Label Positive;
    @FXML
    private Label Negative;
    @FXML
    private Label Tested;
    @FXML
    private Label Vaccinated;

    String queryP="SELECT * FROM client_taste where status='Positive';";
    String queryN="SELECT * FROM client_taste where status='Negative';";
    String queryT="SELECT * FROM client_taste;";
    String queryV="SELECT * FROM client_vaccine;";

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    Positive.setText(String.valueOf(DBUtils.CountValue(queryP)));
    Negative.setText(String.valueOf(DBUtils.CountValue(queryN)));
    Tested.setText(String.valueOf(DBUtils.CountValue(queryT)));
    Vaccinated.setText(String.valueOf(DBUtils.CountValue(queryV)));

    }
}
