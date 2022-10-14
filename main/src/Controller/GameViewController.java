package Controller;

import Model.Events.Event;
import Model.Interfaces.util.IObserver;
import Model.Model;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.util.List;
import java.util.Objects;

public class GameViewController implements IObserver<Event> {
    @Override
    public void update(Event event) {
        textBox.setText(event.getEventText());
        if (event.getAmountOfActions() >= 1) {
            ChoiceButton1.setVisible(true);
            ChoiceButton1.setText(event.getActionText(0));
        } else {
            ChoiceButton1.setVisible(false);
        }
        if (event.getAmountOfActions() >= 2) {
            ChoiceButton2.setVisible(true);
            ChoiceButton2.setText(event.getActionText(1));
        } else {
            ChoiceButton2.setVisible(false);
        }
        if (event.getAmountOfActions() >= 3) {
            ChoiceButton3.setVisible(true);
            ChoiceButton3.setText(event.getActionText(2));
        } else {
            ChoiceButton3.setVisible(false);
        }
        if (event.getAmountOfActions() >= 4) {
            ChoiceButton4.setVisible(true);
            ChoiceButton4.setText(event.getActionText(3));
        } else {
            ChoiceButton4.setVisible(false);
        }
    }

    @FXML
    private TextArea textBox;

    @FXML
    private ImageView GameImage, Cross;

    @FXML
    private Button ChoiceButton1, ChoiceButton2, ChoiceButton3, ChoiceButton4, ExitButton;

    public void initialize() {
        //Model.getInstance().subscribe(this);
    }

    public void pressedExitButton() throws Exception{
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../View/MainMenu.fxml")));
        Stage aboutStage = (Stage) ExitButton.getScene().getWindow();
        aboutStage.setScene(new Scene(root));
    }

    public void pressedChoiceButton1() {
       // Model.getInstance().selectAction(0);
    }
    public void pressedChoiceButton2() {
       // Model.getInstance().selectAction(1);
    }
    public void pressedChoiceButton3() {
      //  Model.getInstance().selectAction(2);
    }
    public void pressedChoiceButton4() {
       // Model.getInstance().selectAction(3);
    }
}
