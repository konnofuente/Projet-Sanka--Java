package com.example.frontend_javaproject;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.awt.*;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
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

    @FXML private Button btn_print;

    @FXML private AnchorPane vacc_card;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        btn_print.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                printAnchore(vacc_card);
            }


        });
    }
    //Method to print a Anchor
    private void printAnchore(AnchorPane anchorPane) {
        //we create  a printer Job class
        PrinterJob printerJob=PrinterJob.getPrinterJob();
        //we set printer job name
        printerJob.setJobName("Print Vaccination Card");
        printerJob.setPrintable(new Printable() {
            @Override
            public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
                //check if no printable content
                if(pageIndex>0){
                    return Printable.NO_SUCH_PAGE;}
                //make 2D Graphic to map content
                Graphics2D graphics2D=(Graphics2D) graphics;
                //set graphic transaltion
                graphics2D.translate(pageFormat.getImageableX()*2,pageFormat.getImageableY()*2);

                //set graphic scale
                graphics2D.scale(0.5,0.5);

               // anchorPane.paint(graphics2D);
            return 0;
            }
        });

    }



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
