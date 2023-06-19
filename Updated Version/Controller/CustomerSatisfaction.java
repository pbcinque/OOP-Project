package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class CustomerSatisfaction implements Initializable {

    @FXML
    private ImageView image1;

    @FXML
    private ImageView image2;

    @FXML
    private ImageView image3;

    @FXML
    private Button b1, b2;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        image3.setVisible(true);

        b1.setOnMouseClicked(event -> {
            image1.setVisible(true); image2.setVisible(false); image3.setVisible(false);});

        b2.setOnMouseClicked(event -> {
            image2.setVisible(true); image1.setVisible(false); image3.setVisible(false);});
        
    }


        } 

