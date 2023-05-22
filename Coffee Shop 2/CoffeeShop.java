import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CoffeeShopApp extends Application {
    private Stage primaryStage;
    private PreferencesController preferencesController;
    private CheckoutController checkoutController;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;

        // Load the preferences scene
        FXMLLoader preferencesLoader = new FXMLLoader(getClass().getResource("preferences.fxml"));
        Parent preferencesRoot = preferencesLoader.load();
        preferencesController = preferencesLoader.getController();

        // Load the checkout scene
        FXMLLoader checkoutLoader = new FXMLLoader(getClass().getResource("checkout.fxml"));
        Parent checkoutRoot = checkoutLoader.load();
        checkoutController = checkoutLoader.getController();
        checkoutController.setPreferencesController(preferencesController);

        // Set the initial scene
        Scene preferencesScene = new Scene(preferencesRoot);
        primaryStage.setScene(preferencesScene);
        primaryStage.show();
    }
}
