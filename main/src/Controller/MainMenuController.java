package Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.Objects;

/**
 * Controller for the main menu screen
 */
public class MainMenuController{

        /**
         * all the FXML components of the stage
         */
        @FXML
        private StackPane mainmenuStackPane;

        @FXML
        private Button mainmenuAboutPageButton, mainmenuNewGameButton;

        @FXML
        private ImageView mainmenuBG;

        /**
         * method to load the about page, called when the about button is pressed
         */
        public void pressedAboutPageButton() throws Exception{
                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../View/AboutPage.fxml")));
                Stage aboutStage = (Stage) mainmenuAboutPageButton.getScene().getWindow();
                aboutStage.setScene(new Scene(root));
        }

        /**
         * method to load the new game page, called when the new game button is pressed
         */
        public void pressedNewGamePageButton() throws Exception{
                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../View/NewGame.fxml")));
                Stage aboutStage = (Stage) mainmenuNewGameButton.getScene().getWindow();
                aboutStage.setScene(new Scene(root));
        }

}
