package Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.Objects;

/**
 * Controller for the about page screen
 */
public class AboutPageController extends AnchorPane {

        /**
         * all the FXML components of the stage
         */
        @FXML
        private StackPane aboutpageAnchorPane;
        @FXML
        private Button aboutPageBackButton;

        /**
         * method to load the main menu page, called when the back button is pressed
         */
        public void pressedAboutPageBackButton() throws Exception{
                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../View/MainMenu.fxml")));
                Stage aboutStage = (Stage) aboutPageBackButton.getScene().getWindow();
                aboutStage.setScene(new Scene(root));
        }
}
