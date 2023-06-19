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
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ReceiptController implements Initializable {

    @FXML
    double item1Amount, item2Amount, item3Amount, item4Amount, item5Amount, item6Amount;

    @FXML
    Button clickMe;

    @FXML
    Label qty1, qty2, qty3, qty4, qty5, qty6, product1, product2, product3, product4, product5, product6, price1, price11, price111, price2, price22, price222, amount1, amount2, amount3, amount4, amount5, amount6, total;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        if (HomeController.hotchoco.getProductStatus()) {
            product1.setText(HomeController.hotchoco.getProductName());
            qty1.setText(Double.toString(HomeController.hotchoco.getProductQuantity()));
            price1.setText(Double.toString(HomeController.hotchoco.getProductPrice()));
            amount1.setText(Double
                    .toString(HomeController.hotchoco.getProductPrice() * HomeController.hotchoco.getProductQuantity()));

            product1.setVisible(true);
            qty1.setVisible(true);
            price1.setVisible(true);
            amount1.setVisible(true);

            item1Amount = HomeController.hotchoco.getProductPrice() * HomeController.hotchoco.getProductQuantity();

        }

        if (HomeController.espresso.getProductStatus()) {
            product2.setText(HomeController.espresso.getProductName());
            qty2.setText(Double.toString(HomeController.espresso.getProductQuantity()));
            price11.setText(Double.toString(HomeController.espresso.getProductPrice()));
            amount2.setText(Double
                    .toString(HomeController.espresso.getProductPrice() * HomeController.espresso.getProductQuantity()));

            product2.setVisible(true);
            qty2.setVisible(true);
            price11.setVisible(true);
            amount2.setVisible(true);

            item2Amount = HomeController.espresso.getProductPrice() * HomeController.espresso.getProductQuantity();
        }

        if (HomeController.strawberry.getProductStatus()) {
            product3.setText(HomeController.strawberry.getProductName());
            qty3.setText(Double.toString(HomeController.strawberry.getProductQuantity()));
            price111.setText(Double.toString(HomeController.strawberry.getProductPrice()));
            amount3.setText(Double
                    .toString(HomeController.strawberry.getProductPrice() * HomeController.strawberry.getProductQuantity()));

            product3.setVisible(true);
            qty3.setVisible(true);
            price111.setVisible(true);
            amount3.setVisible(true);

            item3Amount = HomeController.strawberry.getProductPrice() * HomeController.strawberry.getProductQuantity();

        }

        if (HomeController.fruit.getProductStatus()) {
            product4.setText(HomeController.fruit.getProductName());
            qty4.setText(Double.toString(HomeController.fruit.getProductQuantity()));
            price2.setText(Double.toString(HomeController.fruit.getProductPrice()));
            amount4.setText(Double
                    .toString(HomeController.strawberry.getProductPrice() * HomeController.fruit.getProductQuantity()));

            product4.setVisible(true);
            qty4.setVisible(true);
            price2.setVisible(true);
            amount4.setVisible(true);

            item4Amount = HomeController.fruit.getProductPrice() * HomeController.fruit.getProductQuantity();

        }

        if (HomeController.caramel.getProductStatus()) {
            product5.setText(HomeController.caramel.getProductName());
            qty5.setText(Double.toString(HomeController.caramel.getProductQuantity()));
            price22.setText(Double.toString(HomeController.caramel.getProductPrice()));
            amount5.setText(Double
                    .toString(HomeController.caramel.getProductPrice() * HomeController.caramel.getProductQuantity()));

            product5.setVisible(true);
            qty5.setVisible(true);
            price22.setVisible(true);
            amount5.setVisible(true);

            item5Amount = HomeController.caramel.getProductPrice() * HomeController.caramel.getProductQuantity();

        }

        if (HomeController.matcha.getProductStatus()) {
            product6.setText(HomeController.matcha.getProductName());
            qty6.setText(Double.toString(HomeController.matcha.getProductQuantity()));
            price222.setText(Double.toString(HomeController.matcha.getProductPrice()));
            amount6.setText(Double
                    .toString(HomeController.matcha.getProductPrice() * HomeController.matcha.getProductQuantity()));

            product6.setVisible(true);
            qty6.setVisible(true);
            price222.setVisible(true);
            amount6.setVisible(true);

            item6Amount = HomeController.strawberry.getProductPrice() * HomeController.strawberry.getProductQuantity();

        }

        double final_amount = item1Amount + item2Amount + item3Amount + item4Amount + item5Amount + item6Amount;
        total.setText(Double.toString(final_amount));

    }

    public void proceed(ActionEvent event) throws IOException {

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Satisfaction.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
    }
    
}
