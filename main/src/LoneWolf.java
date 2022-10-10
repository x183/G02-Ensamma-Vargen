import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import View.CLI;

import java.util.Objects;

public class LoneWolf extends Application{

   @Override
   public void start(Stage stage) throws Exception {
       Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("View/MainMenu.fxml")));
       Scene scene = new Scene(root);
       stage.setTitle("Lone Wolf");
       Image icon = new Image("View/images/lonewolflogo.png");
       stage.getIcons().add(icon);
       stage.setScene(scene);
       stage.setResizable(false);
       stage.show();
   }

   public static void main (String[] args)
   {
       try{
           CLI.main(args);
       }catch (Exception e){

       }

   }
   //Outcommented for testing with CLI class
    /*public static void main(String[] args) {
        /* Model model = new Model();
        ModelController modelController = new ModelController();
        launch(args);
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {
                Model.getInstance().shutDown();
            }
        }));
    }*/

}
