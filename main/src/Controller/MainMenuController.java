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

public class MainMenuController{

        //stackpanes
        @FXML
        private StackPane mainmenuStackPane;

        //buttons

        @FXML
        private Button mainmenuAboutPageButton, mainmenuNewGameButton;

        //background images
        @FXML
        private ImageView mainmenuBG;

        public void pressedAboutPageButton() throws Exception{
                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../View/AboutPage.fxml")));
                Stage aboutStage = (Stage) mainmenuAboutPageButton.getScene().getWindow();
                aboutStage.setScene(new Scene(root));
        }
        public void pressedNewGamePageButton() throws Exception{
                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../View/NewGame.fxml")));
                Stage aboutStage = (Stage) mainmenuNewGameButton.getScene().getWindow();
                aboutStage.setScene(new Scene(root));
        }

}
