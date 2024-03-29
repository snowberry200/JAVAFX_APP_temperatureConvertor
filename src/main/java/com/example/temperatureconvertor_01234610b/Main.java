package com.example.temperatureconvertor_01234610b;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {
    public void start(Stage stage) {
        //try to load and display the FXML FILE
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("scene.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            stage.setTitle("JAVAFX ASSIGNMENT 2 GROUP 21");
            stage.setScene(scene);
            stage.show();

        }
        //catch and print any error
        catch(Exception e){
            e.printStackTrace();

        }

    }
    //main function to launch application
    public static void main(String[] args) {
        launch();
    }
}