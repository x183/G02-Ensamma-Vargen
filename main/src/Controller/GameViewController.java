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
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import javafx.stage.Stage;

import java.net.URL;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

/**
 * Controller for the game screen
 */
public class GameViewController implements IObserver<Event>, Initializable {
    private Model gameModel;
    private NewGameController parentController;

    /**
     * all the FXML components of the stage
     */
    @FXML
    private Pane mainPane;
    @FXML
    private TextArea textBox;

    @FXML
    private TextFlow eventTextFlow;

    @FXML
    private Label eventLabel;

    @FXML
    private ImageView GameImage, Cross;

    @FXML
    private Button ChoiceButton1, ChoiceButton2, ChoiceButton3, ChoiceButton4, ExitButton;
    /**
     * updates the game screen when the model is updated
     */
    @Override
    public void update(Event event) {
        updateEventText(event);
        Background background = BackgroundParser.ParseBackground(Model.getInstance().getCurrentEvent().getPathToThisEvent());
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

    /**
     * updates the text on the screen
     */
    void updateEventText(Event event) {
        eventLabel.setText(event.getEventText());
      /*  eventTextFlow.getChildren().clear();
        Text text = new Text(event.getEventText());
        eventTextFlow.getChildren().add(text); */
    }


    /**
     * sets the model for the controller and the background of the mainPane
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Model.getInstance().subscribe(this);
        Model.getInstance().subscribe(this);
        Background background = BackgroundParser.ParseBackground(Model.getInstance().getCurrentEvent().getPathToThisEvent());
        mainPane.setBackground(background);

    }

    /**
     * returns to the main menu when back button is pressed
     */
    public void pressedExitButton() throws Exception{
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../View/MainMenu.fxml")));
        Stage aboutStage = (Stage) ExitButton.getScene().getWindow();
        aboutStage.setScene(new Scene(root));
    }

    /**
     * Pressed the choice 1 button
     * @throws Exception if the button is pressed when there is no choice 1
     */
    public void pressedChoiceButton1() throws Exception {
        if(Model.getInstance().getActionName(0).equals(" Restart")){
            Model.getInstance().resetPlayer();
        } else if(Model.getInstance().getActionName(0).equals(" Back to main menu")){
            pressedExitButton();
        }
        Model.getInstance().selectAction(0);
    }

    /**
     * Pressed the choice 2 button
     * @throws Exception if the button is pressed when there is no choice 2
     */
    public void pressedChoiceButton2() throws Exception {
        if(Model.getInstance().getActionName(1).equals(" Quit Game")){
            pressedExitButton();
        } else
        Model.getInstance().selectAction(1);
    }

    /**
     * Pressed the choice 3 button
     * @throws Exception if the button is pressed when there is no choice 3
     */
    public void pressedChoiceButton3() {
        Model.getInstance().selectAction(2);
    }

    /**
     * Pressed the choice 4 button
     * @throws Exception if the button is pressed when there is no choice 4
     */
    public void pressedChoiceButton4() {
        Model.getInstance().selectAction(3);
    }

}
