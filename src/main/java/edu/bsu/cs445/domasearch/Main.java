package edu.bsu.cs445.domasearch;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{



        //Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("resources/DOMAUI.fxml"));
        URL url = new File("../DOMASearch/src/main/resources/DOMAUI.fxml").toURI().toURL();
        System.out.println(url);
        Parent root = FXMLLoader.load(url);




        primaryStage.setTitle("Search DOMA");
        primaryStage.setScene(new Scene(root, 810, 600));

        primaryStage.show();


    }



    public static void main(String[] args) {
        launch(args);
    }
}
