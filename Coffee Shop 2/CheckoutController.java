import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class CheckoutController {
    @FXML
    private ListView<String> orderHistoryListView;

    @FXML
    private Label totalLabel;

    @FXML
    private Label paymentStatusLabel;

    private PreferencesController preferencesController;
    private double totalPrice;

    public void setPreferencesController(PreferencesController controller) {
        this.preferencesController = controller;
    }

    @FXML
    private void initialize() {
        String selectedPreference = preferencesController.getSelectedPreference();
        if (selectedPreference != null) {
            double price = extractPrice(selectedPreference);
            totalPrice += price;

            orderHistoryListView.getItems().add(selectedPreference);
            totalLabel.setText("Total: " + totalPrice + " USD");
        }
    }

    @FXML
    private void payButtonClicked(ActionEvent event) {
        // Perform payment processing logic
        // ...

        paymentStatusLabel.setText("Payment Successful!");
    }

    private double extractPrice(String preference) {
        String[] parts = preference.split(" ");
        String priceString = parts[parts.length - 1].replace("(", "").replace(")", "").replace("USD", "");
        return Double.parseDouble(priceString);
    }
}
