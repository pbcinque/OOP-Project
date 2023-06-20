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
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CustomerFeedback implements Initializable {

    @FXML
    private ImageView image1;

    @FXML
    private ImageView image2;

    @FXML
    private ImageView image3;

    @FXML
    private Button b1, b2;

    @FXML
    private Text text1;

    @FXML
    private Text text2;

    @FXML
    private Text text3;

    @FXML
    private Text text4;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        b1.setOnMouseEntered(event -> {
            image1.setVisible(true); image2.setVisible(false); image3.setVisible(false);
            text1.setVisible(false); text2.setVisible(false); text3.setVisible(true); text4.setVisible(false);});

        b2.setOnMouseEntered(event -> {
            image2.setVisible(true); image1.setVisible(false); image3.setVisible(false);
            text1.setVisible(false); text2.setVisible(false); text3.setVisible(false); text4.setVisible(true);});

        b1.setOnMouseExited(event -> {
            image1.setVisible(false); image2.setVisible(false); image3.setVisible(true);
            text1.setVisible(true); text2.setVisible(true); text3.setVisible(false); text4.setVisible(false);});

        b2.setOnMouseExited(event -> {
            image1.setVisible(false); image2.setVisible(false); image3.setVisible(true);
            text1.setVisible(true); text2.setVisible(true); text3.setVisible(false); text4.setVisible(false);});
        
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
