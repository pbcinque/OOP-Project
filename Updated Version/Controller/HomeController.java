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
    Label name1, name11, name111, name2, name22, name222, price1, price11, price111, price2, price22, price222;

    @FXML
    ImageView img1, img11, img111, img2, img22, img222;

    @FXML
    Button button1, button11, button111, button2, button22, button222, cartbutton;

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
    static FruitTea fruit = new FruitTea();
    static Frappe caramel = new Frappe();
    static Latte matcha = new Latte();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // ============== HOTCHOCO ==================//
        hotchoco.setProductName("Hot Chocolate");
        name1.setText(hotchoco.getProductName());

        hotchoco.setProductPrice(1.77);
        price1.setText(Double.toString(hotchoco.getProductPrice()));

        hotchoco.setProductImage("image/hotchoco.jpg");
        Image hotchocolateImage = new Image(hotchoco.getProductImage());
        img1.setImage(hotchocolateImage);

        // ============== ESPRESSO ==================//
        espresso.setProductName("Espresso");
        name11.setText(espresso.getProductName());

        espresso.setProductPrice(1.79);
        price11.setText(Double.toString(espresso.getProductPrice()));

        espresso.setProductImage("image/espresso.jpg");
        Image espressoImage = new Image(espresso.getProductImage());
        img11.setImage(espressoImage);

        // ============== SMOOTHIE ==================//
        strawberry.setProductName("Smoothie");
        name111.setText(strawberry.getProductName());

        strawberry.setProductPrice(2.68);
        price111.setText(Double.toString(strawberry.getProductPrice()));

        strawberry.setProductImage("image/strawberry.jpg");
        Image berryImage = new Image(strawberry.getProductImage());
        img111.setImage(berryImage);

        // ============== FRUIT TEA ==================//
        fruit.setProductName("Fruit Tea");
        name2.setText(fruit.getProductName());

        fruit.setProductPrice(2.23);
        price2.setText(Double.toString(fruit.getProductPrice()));

        fruit.setProductImage("image/fruittea.jpg");
        Image fruitImage = new Image(fruit.getProductImage());
        img2.setImage(fruitImage);

        // ============== FRAPPE ==================//
        caramel.setProductName("Caramel Frappe");
        name22.setText(caramel.getProductName());

        caramel.setProductPrice(2.75);
        price22.setText(Double.toString(caramel.getProductPrice()));

        caramel.setProductImage("image/caramelfrappe.jpg");
        Image caramelImage = new Image(caramel.getProductImage());
        img22.setImage(caramelImage);

        // ============== MATCHA ==================//
        matcha.setProductName("Matcha Latte");
        name222.setText(matcha.getProductName());

        matcha.setProductPrice(1.79);
        price222.setText(Double.toString(matcha.getProductPrice()));

        matcha.setProductImage("image/matchalatte.jpg");
        Image matchImage = new Image(matcha.getProductImage());
        img222.setImage(matchImage);

        try {
            loader = new FXMLLoader(getClass().getResource("/view/Checkout.fxml"));
            root = loader.load();
        } catch (Exception e) {
            // TODO: handle exception
        }

        // Clears all items in Checkout.fxml
        checkoutController = loader.getController();
        checkoutController.myvbox1.getChildren().removeAll(checkoutController.myvbox1.getChildren());
        checkoutController.myvbox2.getChildren().removeAll(checkoutController.myvbox2.getChildren());

    }

    public void buy(ActionEvent event) throws IOException {

        AlertMaker.showSimpleAlert("Yehey !", "Item successfully added to cart !");

        Button sourceButton = (Button) event.getSource();

        // If addtocart button is pressed, set product status to true
        if (sourceButton == button1) {
            hotchoco.setProductStatus(true);
            HomeController.hotchoco.setProductQuantity(1.0);
            checkoutController.addItem(checkoutController.pane1);
        }

        else if (sourceButton == button11) {
            espresso.setProductStatus(true);
            HomeController.espresso.setProductQuantity(1.0);
            checkoutController.addItem(checkoutController.pane2);
        }

        else if (sourceButton == button111) {
            strawberry.setProductStatus(true);
            HomeController.strawberry.setProductQuantity(1.0);
            checkoutController.addItem(checkoutController.pane3);
        }

        else if (sourceButton == button2) {
            fruit.setProductStatus(true);
            HomeController.fruit.setProductQuantity(1.0);
            checkoutController.addItem1(checkoutController.pane4);
        }

        else if (sourceButton == button22) {
            caramel.setProductStatus(true);
            HomeController.caramel.setProductQuantity(1.0);
            checkoutController.addItem1(checkoutController.pane5);
        }

        else if (sourceButton == button222) {
            matcha.setProductStatus(true);
            HomeController.matcha.setProductQuantity(1.0);
            checkoutController.addItem1(checkoutController.pane6);
        }
    }

    // Goes to Checkout.fxml
    public void gotocart(ActionEvent event) throws IOException {

        checkoutController.getInitialAmount();

        Scene scene = new Scene(root);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

}

