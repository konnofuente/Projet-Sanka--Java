package com.example.frontend_javaproject;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

import javax.swing.text.html.ImageView;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class sliderMenuController implements Initializable {
   // @FXML private ImageView exit;

    @FXML private Label menu;

    @FXML private Label menuback;

    @FXML
    private AnchorPane slider;

    @FXML
    private StackPane contentArea;

    @FXML private Button btnexit;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

             slider.setTranslateX(-220);

            btnexit.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    DBUtils.changeover(actionEvent,"admin-login.fxml","WELCOME");
                }
            });

            menu.setOnMouseClicked(event ->{
                TranslateTransition slide =new TranslateTransition();
                slide.setDuration(Duration.seconds(0.5));
                slide.setNode(slider);

                slide.setToX(0);
                slide.play();

                slider.setTranslateX(-220);

                slide.setOnFinished((ActionEvent e)->{
                    menu.setVisible(false);
                    menuback.setVisible(true);
                });
            });



        menuback.setOnMouseClicked(event ->{
            TranslateTransition slide =new TranslateTransition();
            slide.setDuration(Duration.seconds(0.5));
            slide.setNode(slider);

            slide.setToX(-220);
            slide.play();

            slider.setTranslateX(0);

            slide.setOnFinished((ActionEvent e)->{
                menu.setVisible(true);
                menuback.setVisible(false);
            });
        });

        try{
            Parent root= FXMLLoader.load(getClass().getResource("welcomeAdmin.fxml"));
            contentArea.getChildren().removeAll();
            contentArea.getChildren().setAll(root);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void exit (ActionEvent actionEvent) throws IOException {
       System.exit(0);
    }

    public void dashboard (ActionEvent actionEvent) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("welcomeAdmin.fxml"));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(root);
    }

    public void client (ActionEvent actionEvent) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("update_client.fxml"));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(root);
    }

    public void clienttasted (ActionEvent actionEvent) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("update_clienttaste.fxml"));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(root);
    }

    public void statistic(ActionEvent actionEvent) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("statistic.fxml"));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(root);
    }

    public void clinic (ActionEvent actionEvent) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("update_clinic.fxml"));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(root);
    }
}
