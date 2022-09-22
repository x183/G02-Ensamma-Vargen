import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;

public class LoneWolf extends Application{

   /* @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader root = new FXMLLoader(getClass().getResource("MainMenu.fxml"));
        Scene scene = new Scene(root.load());
        MainMenuController mainMenuController = root.getController();
        stage.setScene(scene);
        stage.setResizable(false);   //remove if want to make window resizable again
        mainMenuController.setScene();
        stage.show();
    } */
   @Override
   public void start(Stage stage) throws Exception {
       FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MainMenu.fxml"));
       fxmlLoader.setBuilderFactory(new JavaFXBuilderFactory());
       Parent root = (Parent) fxmlLoader.load();
       Scene scene = new Scene(root);
       stage.setScene(scene);
       MainMenuController mainController = fxmlLoader.getController();
       mainController.setStage(stage);
       mainController.showStage();
   }
    public static void main(String[] args) {
        launch(args);
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {
                Model.getInstance().shutDown();
            }
        }));
    }
}
