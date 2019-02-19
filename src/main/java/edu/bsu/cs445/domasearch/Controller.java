package edu.bsu.cs445.domasearch;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;


public class Controller {
    @FXML
    ImageView PicturePane;
    @FXML
    TableView<String> TableStuff;
    @FXML
    TableColumn ArtPieceColumn;
    @FXML
    ToggleGroup SearchBy;

    public void StartQueryOnEnter(KeyEvent event ){

        if(event.getCode()==KeyCode.ENTER) {
            System.out.println("Nice Dude!");
        }
        RadioButton selectedRadioButton = (RadioButton) SearchBy.getSelectedToggle();
        System.out.println(selectedRadioButton);

        PicturePane.setImage(new Image("https://static1.squarespace.com/static/5849779420099ed16a2a2d13/5931de77bf629a03dd268401/5939734d8419c2c9745e076c/1496937349988/Terry+Crew+Final+oneXX+copy.jpg"));
        ImageHandler imageHandler=new ImageHandler();
        imageHandler.centerImage(PicturePane);


    }
    public void StartQueryOnClick( MouseEvent event){
        System.out.println("Nice Dude!");
        ArtPieceColumn.setCellFactory(new PropertyValueFactory<>("God"));
        PicturePane.setImage(new Image("http://www.ohgizmo.com/wp-content/uploads/2012/11/docomotimeline-740x3962.jpg"));

    }

    public void UpdatePicturePane(MouseEvent event){
        PicturePane.setImage(new Image("https://dishdish.us/wp-content/uploads/2015/01/dried-beans-in-large-pot.jpg"));
    }

    public void UpdateTable(KeyEvent event){
        //ArtPieceColumn.setCellFactory(new PropertyValueFactory<TableStuff,>("God"));
    }


}
