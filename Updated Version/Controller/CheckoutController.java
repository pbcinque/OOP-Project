package controller;

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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CheckoutController implements Initializable {

    @FXML
    Pane pane1, pane2, pane3, pane4, pane5, pane6;

    @FXML
    VBox myvbox1, myvbox2;

    @FXML
    Button checkoutButton;

    @FXML
    Label name1, name11, name111, name2, name22, name222, price1, price11, price111, price2, price22, price222, total;

    @FXML
    ImageView img1, img11, img111, img2, img22, img222;

    @FXML
    private ChoiceBox<String> choicebox1, choicebox2, choicebox3, choicebox4, choicebox5, choicebox6;

    private String[] quantity = { "1", "2", "3"};

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        name1.setText(HomeController.hotchoco.getProductName());
        price1.setText(Double.toString(HomeController.hotchoco.getProductPrice()));
        Image hotchocolateImage = new Image(HomeController.hotchoco.getProductImage());
        img1.setImage(hotchocolateImage);

        name11.setText(HomeController.espresso.getProductName());
        price11.setText(Double.toString(HomeController.espresso.getProductPrice()));
        Image espressoImage = new Image(HomeController.espresso.getProductImage());
        img11.setImage(espressoImage);

        name111.setText(HomeController.strawberry.getProductName());
        price111.setText(Double.toString(HomeController.strawberry.getProductPrice()));
        Image berryImage = new Image(HomeController.strawberry.getProductImage());
        img111.setImage(berryImage);

        name2.setText(HomeController.fruit.getProductName());
        price2.setText(Double.toString(HomeController.fruit.getProductPrice()));
        Image fruitImage = new Image(HomeController.fruit.getProductImage());
        img2.setImage(fruitImage);

        name22.setText(HomeController.caramel.getProductName());
        price22.setText(Double.toString(HomeController.caramel.getProductPrice()));
        Image caramelImage = new Image(HomeController.caramel.getProductImage());
        img22.setImage(caramelImage);

        name222.setText(HomeController.matcha.getProductName());
        price222.setText(Double.toString(HomeController.matcha.getProductPrice()));
        Image matchImage = new Image(HomeController.matcha.getProductImage());
        img222.setImage(matchImage);

        // Set default quantities in choicebox to 1
        choicebox1.setValue("1");
        choicebox2.setValue("1");
        choicebox3.setValue("1");
        choicebox4.setValue("1");
        choicebox5.setValue("1");
        choicebox6.setValue("1");

        // Insert quantity array to choicebox
        choicebox1.getItems().addAll(quantity);
        choicebox2.getItems().addAll(quantity);
        choicebox3.getItems().addAll(quantity);
        choicebox4.getItems().addAll(quantity);
        choicebox5.getItems().addAll(quantity);
        choicebox6.getItems().addAll(quantity);

        // Add event handler on all choiceboxes
        choicebox1.setOnAction(this::computeTotal);
        choicebox2.setOnAction(this::computeTotal);
        choicebox3.setOnAction(this::computeTotal);
        choicebox4.setOnAction(this::computeTotal);
        choicebox5.setOnAction(this::computeTotal);
        choicebox6.setOnAction(this::computeTotal);
        
    }

    public void addItem(Pane pane) {
        myvbox1.getChildren().add(pane);

    }

    public void addItem1(Pane pane) {
        myvbox2.getChildren().add(pane);

    }

    public void computeTotal(ActionEvent event) {

        double totalAmount = 0;
        double item1Amount = 0;
        double item2Amount = 0;
        double item3Amount = 0;
        double item4Amount = 0;
        double item5Amount = 0;
        double item6Amount = 0;


        ChoiceBox source = (ChoiceBox) event.getSource();

        // If product is chosen, compute item amount
        if (HomeController.hotchoco.getProductStatus()) {

            double qty = Double.parseDouble(choicebox1.getValue());
            HomeController.hotchoco.setProductQuantity(qty);
            item1Amount = HomeController.hotchoco.getProductPrice() * qty;

            if (source == choicebox1) {
                item1Amount = HomeController.hotchoco.getProductPrice() * qty;
            }
        }

        if (HomeController.espresso.getProductStatus()) {

            double qty = Double.parseDouble(choicebox2.getValue());
            HomeController.espresso.setProductQuantity(qty);
            item2Amount = HomeController.espresso.getProductPrice() * qty;

            if (source == choicebox2) {
                item2Amount = HomeController.espresso.getProductPrice() * qty;
            }
        }

        if (HomeController.strawberry.getProductStatus()) {

            double qty = Double.parseDouble(choicebox3.getValue());
            HomeController.strawberry.setProductQuantity(qty);
            item3Amount = HomeController.strawberry.getProductPrice() * qty;

            if (source == choicebox3) {
                item3Amount = HomeController.strawberry.getProductPrice() * qty;
            }
        }

         if (HomeController.fruit.getProductStatus()) {

            double qty = Double.parseDouble(choicebox4.getValue());
            HomeController.fruit.setProductQuantity(qty);
            item4Amount = HomeController.fruit.getProductPrice() * qty;

            if (source == choicebox4) {
                item4Amount = HomeController.fruit.getProductPrice() * qty;
            }
        }

         if (HomeController.caramel.getProductStatus()) {

            double qty = Double.parseDouble(choicebox5.getValue());
            HomeController.caramel.setProductQuantity(qty);
            item5Amount = HomeController.caramel.getProductPrice() * qty;

            if (source == choicebox5) {
                item5Amount = HomeController.caramel.getProductPrice() * qty;
            }
        }

         if (HomeController.matcha.getProductStatus()) {

            double qty = Double.parseDouble(choicebox6.getValue());
            HomeController.matcha.setProductQuantity(qty);
            item6Amount = HomeController.matcha.getProductPrice() * qty;

            if (source == choicebox6) {
                item6Amount = HomeController.matcha.getProductPrice() * qty;
            }
        }

        // Compute total amount for all items chosen
        totalAmount = item1Amount + item2Amount + item3Amount + item4Amount + item5Amount + item6Amount;
        
        // Display total amount in total label
        total.setText(Double.toString(totalAmount));
    }

    public void getInitialAmount() {

        double totalAmount = 0.00;

        if (HomeController.hotchoco.getProductStatus()) {
            totalAmount += HomeController.hotchoco.getProductPrice();
        }

        if (HomeController.espresso.getProductStatus()) {
            totalAmount += HomeController.espresso.getProductPrice();
        }

        if (HomeController.strawberry.getProductStatus()) {
            totalAmount += HomeController.strawberry.getProductPrice();
        }

        if (HomeController.fruit.getProductStatus()) {
            totalAmount += HomeController.fruit.getProductPrice();
        }

        if (HomeController.caramel.getProductStatus()) {
            totalAmount += HomeController.caramel.getProductPrice();
        }

        if (HomeController.matcha.getProductStatus()) {
            totalAmount += HomeController.matcha.getProductPrice();
        }

        total.setText(Double.toString(totalAmount));
    }

     public void checkout(ActionEvent event) throws IOException {

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Receipt.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
}
}
