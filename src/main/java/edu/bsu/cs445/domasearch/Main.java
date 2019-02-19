package edu.bsu.cs445.domasearch;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        Font.loadFont(getClass().getResourceAsStream("/Images/HelveticaNeueLTStd-Cn.otf"), 14);
        Parent root = FXMLLoader.load(getClass().getResource("../../../DOMASearch/src/main/java/edu/bsu/cs445/domasearch/DOMAUI.fxml"));
        primaryStage.setTitle("Search DOMA");
        primaryStage.setScene(new Scene(root, 810, 600));

        primaryStage.show();


    }



    public static void main(String[] args) {
        launch(args);
    }
}
