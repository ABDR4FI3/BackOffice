package com.example.backoffice;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        //Change The icon of the Application
        Scene scene = new Scene(fxmlLoader.load());
        Image icon = new Image("file:C:/Users/Elgue/OneDrive/Documents/JAVA PROJECT/BackOffice/src/main/resources/src/icon.png");
        stage.getIcons().add(icon);
        stage.setTitle("Welcome To ABA43 Hotel!");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        //Connect to the data Base
        DbConnection MyConnection = new DbConnection();
        launch();
    }
}