package com.example.frontend_javaproject;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import javax.swing.text.html.ImageView;
import java.net.URL;
import java.util.ResourceBundle;

public class sliderMenuController implements Initializable {
   // @FXML private ImageView exit;

    @FXML private Label menu;

    @FXML private Label menuback;

    @FXML
    private AnchorPane slider;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

            // slider.setTranslateX(-170);

            menu.setOnMouseClicked(event ->{
                TranslateTransition slide =new TranslateTransition();
                slide.setDuration(Duration.seconds(0.5));
                slide.setNode(slider);

                slide.setToX(0);
                slide.play();

                slider.setTranslateX(-200);

                slide.setOnFinished((ActionEvent e)->{
                    menu.setVisible(false);
                    menuback.setVisible(true);
                });
            });



        menuback.setOnMouseClicked(event ->{
            TranslateTransition slide =new TranslateTransition();
            slide.setDuration(Duration.seconds(0.5));
            slide.setNode(slider);

            slide.setToX(-200);
            slide.play();

            slider.setTranslateX(0);

            slide.setOnFinished((ActionEvent e)->{
                menu.setVisible(true);
                menuback.setVisible(false);
            });
        });
    }
}
