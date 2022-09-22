import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import javax.swing.*;

public class MainMenuController{

        //stackpanes
        @FXML
        private StackPane mainmenuStackPane;
        /* @FXML
        private StackPane aboutpageStackPane; */

        //buttons
        @FXML
        private Button aboutpageBackButton;
        @FXML
        private Button mainmenuAboutPageButton;

        //background images
        @FXML
        private ImageView mainmenuBG;

       // private AboutPageController aboutPageController = new AboutPageController();

        Stage thisStage;

        public void setStage (Stage stage){
                thisStage = stage;
        }

        public void showStage(){
                //thisStage.setTitle("");
                thisStage.show();
        }

        public void openAboutPage() {


        }


        /* public void aboutpageToButton(){
                aboutpageStackPane.toFront();
        }

        public void aboutpageBackButton(){
                mainmenuStackPane.toFront();
        } */
}
