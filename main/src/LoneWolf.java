import Model.Events.Event;
import Model.Events.EventParser;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.Objects;

public class LoneWolf extends Application{
    //static Model model = null;

   @Override
   public void start(Stage stage) throws Exception {
       Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("View/MainMenu.fxml")));
       Scene scene = new Scene(root);
       stage.setTitle("Lone Wolf");
       Image icon = new Image(System.getProperty("user.dir")+"/assets/images/lonewolflogo.png");
       stage.getIcons().add(icon);
       stage.setScene(scene);
       stage.setResizable(false);
       stage.show();
   }

    public static void main(String[] args) {
        //only to instantiate the model. replace with actual player and event when starting a new game/continuing old save
        Event emptyLaunchEventGUI = EventParser.parse("assets/AllEvents/emptyLaunchEventGUI.xml");
        //model = new Model(new Player(1,1,1,"launchInstance"), emptyLaunchEventGUI);
        launch(args);
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {
                //model.shutDown();
            }
        }));
    }

}
