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

public class AboutPageController extends AnchorPane {

        @FXML
        private StackPane aboutpageAnchorPane;
        @FXML
        private Button aboutPageBackButton;

        public void pressedAboutPageBackButton() throws Exception{
                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../View/MainMenu.fxml")));
                Stage aboutStage = (Stage) aboutPageBackButton.getScene().getWindow();
                aboutStage.setScene(new Scene(root));
        }
}
