package com.example.frontend_javaproject;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class Vaccination_cardController implements Initializable {
    @FXML private Label idclient ;

    @FXML private Label name;

    @FXML private Label age;

    @FXML private Label nationality;

    @FXML private Label proffesion ;

    @FXML private Label tel;

    @FXML private Label date;





    @FXML private AnchorPane vacc_card;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {



    }
    //Method to print a Anchor




    public  void setinfovaccination(String Pidclient, String Pname, String Page, String Pnationality, String Pproffesion, String Ptel,Date Pdate)
    {
        idclient.setText(Pidclient);
        name.setText(Pname);
        age.setText(Page);
        nationality.setText(Pnationality);
        proffesion.setText(Pproffesion);
        tel.setText(Ptel);
        date.setText(String.valueOf(Pdate));

    }
}
