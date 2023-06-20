package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

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

        b1.setOnMouseEntered(event -> {
            image1.setVisible(true); image2.setVisible(false); image3.setVisible(false);});

        b2.setOnMouseEntered(event -> {
            image2.setVisible(true); image1.setVisible(false); image3.setVisible(false);});

        b1.setOnMouseExited(event -> {
            image1.setVisible(false); image2.setVisible(false); image3.setVisible(true);
        });

        b2.setOnMouseExited(event -> {
            image1.setVisible(false); image2.setVisible(false); image3.setVisible(true);
        });
        
    }

    public void satisfied(ActionEvent event) throws IOException {

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/ThankYou.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

    }

    public void unsatisfied (ActionEvent event) throws IOException {

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/ThankYou.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

    }


        } 
