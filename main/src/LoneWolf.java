import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LoneWolf extends Application{

    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader root=new FXMLLoader(getClass().getResource("MainMenu.fxml"));

        Scene scene = new Scene(root.load());

        stage.setScene(scene);
        stage.setResizable(false);   //remove if want to make window resizable again
        stage.show();
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
