package controller;

import model.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import alert.AlertMaker;

public class HomeController implements Initializable {

    @FXML
    Label name1, name11, name111, price1, price11, price111;

    @FXML
    ImageView img1, img11, img111;

    @FXML
    Button button1, button11, button111, cartbutton;

    @FXML
    private Stage stage;

    @FXML
    private Scene scene;

    @FXML
    private Parent root = null;

    FXMLLoader loader;

    @FXML
    CheckoutController checkoutController = null;

    static HotChocolate hotchoco = new HotChocolate();
    static Espresso espresso = new Espresso();
    static Strawberry strawberry = new Strawberry();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // ============== HOTCHOCO ==================//
        hotchoco.setProductName("Hot Chocolate");
        name1.setText(hotchoco.getProductName());

        hotchoco.setProductPrice(5.00);
        price1.setText(Double.toString(hotchoco.getProductPrice()));

        hotchoco.setProductImage("images/hotchoco.jpeg");
        Image hotchocolate = new Image(hotchoco.getProductImage());
        img1.setImage(hotchocolate);

        // ============== ESPRESSO ==================//

        espresso.setProductName("     Espresso");
        name11.setText(espresso.getProductName());

        espresso.setProductPrice(10.00);
        price11.setText(Double.toString(espresso.getProductPrice()));

        espresso.setProductImage("images/espresso.jpeg");
        Image espressoImage = new Image(espresso.getProductImage());
        img11.setImage(espressoImage);

        // ============== STRAWBERRY ==================//
        strawberry.setProductName("   Smoothie");
        name111.setText(strawberry.getProductName());

        strawberry.setProductPrice(15.00);
        price111.setText(Double.toString(strawberry.getProductPrice()));

        strawberry.setProductImage("images/strawberry.jpeg");
        Image berryImage = new Image(strawberry.getProductImage());
        img111.setImage(berryImage);

        try {
            loader = new FXMLLoader(getClass().getResource("/view/Checkout.fxml"));
            root = loader.load();
        } catch (Exception e) {
            // TODO: handle exception
        }

        // Clears all items in Checkout.fxml
        checkoutController = loader.getController();
        checkoutController.myvbox.getChildren().removeAll(checkoutController.myvbox.getChildren());
    }

    public void buy(ActionEvent event) throws IOException {

        AlertMaker.showSimpleAlert("hello", "item added");

        Button sourceButton = (Button) event.getSource();

        // If addtocart button is pressed, set product status to true
        if (sourceButton.equals(button1)) {
            hotchoco.setProductStatus(true);
            checkoutController.addItem(checkoutController.pane1);
        }

        else if (sourceButton == button11) {
            espresso.setProductStatus(true);
            checkoutController.addItem(checkoutController.pane2);
        }

        else if (sourceButton == button111) {
            strawberry.setProductStatus(true);
            checkoutController.addItem(checkoutController.pane3);
        }
    }

    // Goes to Checkout.fxml
    public void gotocart(ActionEvent event) throws IOException {

        Scene scene = new Scene(root);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

}


