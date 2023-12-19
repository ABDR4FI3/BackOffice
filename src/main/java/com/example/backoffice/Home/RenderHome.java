package com.example.backoffice.Home;

import com.example.backoffice.DbConnection;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class RenderHome extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(com.example.backoffice.HelloApplication.class.getResource("Home.fxml"));
        //Change The icon of the Application
        Scene scene = new Scene(fxmlLoader.load());
        Image icon = new Image("file:C:/Users/Elgue/OneDrive/Documents/JAVA PROJECT/BackOffice/src/main/resources/src/icon.png");
        stage.getIcons().add(icon);
        stage.setTitle("DashBoard");
        stage.setScene(scene);
        stage.show();

    }
    public static void main(String[] args) {
        //Connect to the data Base
        DbConnection MyConnection = new DbConnection();
        launch();
    }
}