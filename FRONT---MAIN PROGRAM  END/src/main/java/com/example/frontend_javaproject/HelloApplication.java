package com.example.frontend_javaproject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class HelloApplication extends Application {
    double x,y;
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("mainpage2.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.initStyle(StageStyle.UNDECORATED);

        scene.setOnMousePressed(event ->{
            x=event.getSceneX();
            y=event.getSceneY();
        });

        scene.setOnMouseDragged(event ->{
            stage.setX(event.getScreenX()-x);
            stage.setY(event.getScreenY()-y);
            y=event.getSceneY();
        });

        stage.setTitle("Welcome");
       // stage.setScene(scene);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}