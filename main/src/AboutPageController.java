import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

import java.io.IOException;

public class AboutPageController extends AnchorPane {

        @FXML
        private StackPane aboutpageAnchorPane;
        @FXML
        private Button aboutpageBackButton;

        public AboutPageController(){
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AboutPage.fxml"));
                fxmlLoader.setRoot(this);
                fxmlLoader.setController(this);

                try {
                        fxmlLoader.load();
                } catch (IOException exception) {
                        throw new RuntimeException(exception);
                }

        }
}
