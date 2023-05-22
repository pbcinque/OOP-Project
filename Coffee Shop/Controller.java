import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class CoffeeShopController {
    @FXML
    private ListView<String> preferencesListView;

    @FXML
    private Label recommendationLabel;

    @FXML
    private Label checkoutStatusLabel;

    @FXML
    private ListView<String> orderHistoryListView;

    private MultipleSelectionModel<String> preferencesSelectionModel;
    private ObservableList<String> orderHistory;

    @FXML
    private void initialize() {
        preferencesSelectionModel = preferencesListView.getSelectionModel();
        preferencesSelectionModel.setSelectionMode(SelectionMode.SINGLE);

        orderHistory = FXCollections.observableArrayList();
        orderHistoryListView.setItems(orderHistory);
    }

    @FXML
    private void checkoutButtonClicked(ActionEvent event) {
        String selectedPreference = preferencesSelectionModel.getSelectedItem();
        if (selectedPreference != null) {
            String recommendation = generateRecommendation(selectedPreference);
            recommendationLabel.setText(recommendation);

            String selectedDrink = selectedPreference.split(" ")[0];
            double price = extractPrice(selectedPreference);

            orderHistory.add(selectedDrink + " (Price: " + price + " USD)");
            checkoutStatusLabel.setText("Checkout Successful!");
        }
    }

    private String generateRecommendation(String preference) {
        String recommendation;
        switch (preference) {
            case "Espresso (2.50 USD)":
                recommendation = "We recommend trying our special Espresso with a rich and bold flavor.";
                break;
            case "Latte (3.00 USD)":
                recommendation = "Our creamy and smooth Latte is a customer favorite.";
                break;
            case "Cappuccino (2.80 USD)":
                recommendation = "Try our classic Cappuccino with its perfect balance of espresso, steamed milk, and foam.";
                break;
            case "Americano (2.20 USD)":
                recommendation = "For a strong and smooth taste, go for our Americano.";
                break;
            default:
                recommendation = "";
                break;
        }
        return recommendation;
    }

    private double extractPrice(String preference) {
        String[] parts = preference.split(" ");
        String priceString = parts[parts.length - 1].replace("(", "").replace(")", "").replace("USD", "");
        return Double.parseDouble(priceString);
    }
}
