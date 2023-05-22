import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class PreferencesController {
    @FXML
    private ListView<String> preferencesListView;

    @FXML
    private Label recommendationLabel;

    private MultipleSelectionModel<String> preferencesSelectionModel;
    private String selectedPreference;

    @FXML
    private void initialize() {
        preferencesSelectionModel = preferencesListView.getSelectionModel();
        preferencesSelectionModel.setSelectionMode(SelectionMode.SINGLE);
    }

    @FXML
    private void nextButtonClicked(ActionEvent event) {
        selectedPreference = preferencesSelectionModel.getSelectedItem();
        if (selectedPreference != null) {
            String recommendation = generateRecommendation(selectedPreference);
            recommendationLabel.setText(recommendation);

            // Load the checkout scene
            // ...
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

    public String getSelectedPreference() {
        return selectedPreference;
    }
}
