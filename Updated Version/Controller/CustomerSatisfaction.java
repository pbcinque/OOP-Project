package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class CustomerSatisfaction {

    @FXML
    private ImageView image1;

    @FXML
    private ImageView image2;

    @FXML
    private ImageView image3;

    @FXML
    private RadioButton r1;

    @FXML
    private RadioButton r2;

    @FXML
    void pick(ActionEvent event) {

        if (r1.isSelected()) {
            image1.setVisible(true);

        } else {
            image1.setVisible(false);

        } 

    }

     @FXML
    void pick2(ActionEvent event) {

        if (r2.isSelected()) {
            image2.setVisible(true);

        } else {
            image2.setVisible(false);

        } 


    }

    @FXML
    void point(MouseEvent event) {
        image1.setVisible(true);
        image2.setVisible(false);

    }

    @FXML
    void point2(MouseEvent event) {
        image2.setVisible(true);
        image1.setVisible(false);

    }

}
