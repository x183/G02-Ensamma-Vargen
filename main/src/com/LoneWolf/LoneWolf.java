package com.LoneWolf;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.File;
import java.util.Objects;

/**
 * GUI version of Lone Wolf. Uses JavaFX.
 */
public class LoneWolf extends Application{
    //static Model model = null;
    /**
     * Sets the stage for the JavaFX GUI. Loads the FXML file and sets the stage.
     * Sets the title of the stage and the icon.
     */
   @Override
   public void start(Stage stage) throws Exception {
       System.out.println(System.getProperty("user.dir") + "/main/src/com/LoneWolf/View/MainMenu.fxml");
       Parent root = FXMLLoader.load(new File(System.getProperty("user.dir") + "/main/src/com/LoneWolf/View/MainMenu.fxml").toURI().toURL());
       Scene scene = new Scene(root);
       stage.setTitle("Lone Wolf");
       Image icon = new Image("/images/lonewolflogo.png");
       stage.getIcons().add(icon);
       stage.setScene(scene);
       stage.setResizable(false);
       stage.show();
   }
    /**
     * Main method. Simply launches the app and uses JavaFX methods to launch the stage.
     * @param args
     */
    public static void main(String[] args) {

        launch(args);
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {

            }
        }));
    }

}
