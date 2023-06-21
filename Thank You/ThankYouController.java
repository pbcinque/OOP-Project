package controller;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class ThankYouController {

	 @FXML
	    Button mybutton;
	 
	 public void gohome(ActionEvent event) throws IOException {

	        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Home.fxml"));
	            Parent root = loader.load();
	            Scene scene = new Scene(root);
	            stage.setScene(scene);
	            stage.show();
}
}
