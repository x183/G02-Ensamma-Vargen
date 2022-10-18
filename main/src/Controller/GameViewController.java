package Controller;

import Model.Events.Event;
import Model.Interfaces.util.IObserver;
import Model.Model;
import View.BackgroundParser;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class GameViewController implements IObserver<Event>, Initializable {
    private Model gameModel;
    private NewGameController parentController;
    @FXML
    private Pane mainPane;
    @Override
    public void update(Event event) {
        textBox.setText(event.getEventText());
        Background background = BackgroundParser.ParseBackground(gameModel.getCurrentEvent().getPathToThisEvent());
        mainPane.setBackground(background);
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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Model.getInstance().subscribe(this);
        gameModel = Model.gameModel;
        Model.gameModel.subscribe(this);
        Background background = BackgroundParser.ParseBackground(gameModel.getCurrentEvent().getPathToThisEvent());
        mainPane.setBackground(background);
    }

    public void pressedExitButton() throws Exception{
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../View/MainMenu.fxml")));
        Stage aboutStage = (Stage) ExitButton.getScene().getWindow();
        aboutStage.setScene(new Scene(root));
    }

    public void pressedChoiceButton1() throws Exception {
        if(Model.gameModel.getActionName(0).equals(" Restart")){
            Model.gameModel.resetPlayer();
        }
        Model.gameModel.selectAction(0);
    }
    public void pressedChoiceButton2() throws Exception {
        if(Model.gameModel.getActionName(1).equals(" Quit Game")){
            pressedExitButton();
        } else
        Model.gameModel.selectAction(1);
    }
    public void pressedChoiceButton3() {
        Model.gameModel.selectAction(2);
    }
    public void pressedChoiceButton4() {
        Model.gameModel.selectAction(3);
    }

}
