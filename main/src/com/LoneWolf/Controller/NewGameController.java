package com.LoneWolf.Controller;

import com.LoneWolf.Model.Events.Event;
import com.LoneWolf.Model.Factories.PlayerFactory;
import com.LoneWolf.Model.Model;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

/**
 * Controller for the new game screen
 */
public class NewGameController implements Initializable {

    private Model gameModel;

    protected Text createCharacterText = new Text("Create your character");
    private String selectedClassString = "";
    private String selectedNameString = "";

    /**
     * all the FXML components of the stage
     */
    @FXML
    private TextFlow createCharacter;
    @FXML
    private ImageView GameImage, Cross;
    @FXML
    private Button ExitButton, submitNameButton;
    @FXML
    private ComboBox<String> classComboBox;
    @FXML
    private TextField playerName;
    @FXML
    private Label continueWarning;
    @FXML
    private Spinner<Double> strengthSpinner, armourSpinner;
    @FXML
    private StackPane createClassMain, createYourOwnClass;

    /**
     * selectClass(), connected to the classComboBox, sets the selectedClassString to the selected class
     */
    @FXML
    void selectClass() {
        if(classComboBox.getSelectionModel().getSelectedItem() == null) {
            return;
        }
        this.selectedClassString = classComboBox.getSelectionModel().getSelectedItem();
        if(selectedClassString.equals("Create your own")){
            createYourOwnClass.toFront();
        } else
            createYourOwnClass.toBack();
    }

    /**
     * nameSubmit(), connected to the submitNameButton, gets the input from the textBox then calls on setName() to set the name
     */
    @FXML
    void nameSubmit(){
        String name = playerName.getText();
        setName(name);
    }

    /**
     * setName(), sets the selectedNameString to the name provided by nameSubmit()
     */
    void setName(String name){
        this.selectedNameString = name;
    }

    /**
     * getGameModel(), returns the gameModel
     * @return the gameModel
     */
    Model getGameModel(){
        return gameModel;
    }

    /**
     * continueButton(), connected to the continue button, checks if the player has selected a class and name, if so
     * it calls on the createPlayer() method and then loads the game screen by calling on startGameView()
     * @throws Exception if the game screen cannot be loaded
     */
    @FXML
    private void continueButton() throws Exception {
        if(selectedNameString.equals("") && selectedClassString.equals("")){
            setContinueWarning("You need to choose a name and pick a class!");

        } else if (!selectedNameString.equals("") && selectedClassString.equals("")){
            setContinueWarning("You need to pick a class!");

        } else if (selectedNameString.equals("")){
            setContinueWarning("You need to choose a name!");

        } else {
            System.out.println(selectedNameString + " is a " + selectedClassString);
            if (selectedClassString.equals("Warrior")) {
                gameModel = new Model(PlayerFactory.createWarriorPlayer(selectedNameString), Event.getEvent("assets/allEvents/startEvent.xml"));
            } else if (selectedClassString.equals("Hunter")) {
                gameModel = new Model(PlayerFactory.createHunterPlayer(selectedNameString), Event.getEvent("assets/allEvents/startEvent.xml"));
            } else {
                gameModel = new Model(PlayerFactory.createPlayer(strengthSpinner.getValue(), 10, armourSpinner.getValue(), selectedNameString), Event.getEvent("assets/allEvents/startEvent.xml"));
            }
            System.out.println(gameModel.getPlayerStrength());
            System.out.println(gameModel.getPlayerArmour());
            Model.setGameModel(gameModel);
            startGameView(Model.getInstance());
        }
    }

    /**
     * startGameView(), loads the game screen
     * @param gameModel the model of the game
     * @throws Exception if the game screen cannot be loaded
     */
    public void startGameView(Model gameModel) throws Exception{
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../View/GameView.fxml")));
        Stage aboutStage = (Stage) ExitButton.getScene().getWindow();
        aboutStage.setScene(new Scene(root));
    }

    /**
     * setContinueWarning(), sets the continueWarning label to the provided string
     * shows error message if user hasn't selected a class or name
     * @param warning the string to be set to the continueWarning label
     */
    private void setContinueWarning(String warning){
        continueWarning.setText(warning);
        continueWarning.setAlignment(Pos.CENTER);
    }


    /**
     * initialize(), sets up the stage for creating your player
     * @param url required
     * @param rb required
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        createCharacter = new TextFlow(createCharacterText);
        ObservableList<String> selectClassList = FXCollections.observableArrayList("Warrior", "Hunter", "Create your own");
        classComboBox.setItems(selectClassList);
        spinnerSetup();

    }

    /**
     * spinnerSetup(), sets up the spinners for the create your own class
     */
    private void spinnerSetup(){
        SpinnerValueFactory<Double> valueFactoryStrength = new SpinnerValueFactory.DoubleSpinnerValueFactory(0, 10, 0, 1);
        SpinnerValueFactory<Double> valueFactoryArmour = new SpinnerValueFactory.DoubleSpinnerValueFactory(0, 10, 0, 1);
        strengthSpinner.setValueFactory(valueFactoryStrength);
        armourSpinner.setValueFactory(valueFactoryArmour);
    }

    /**
     * exitButton(), connected to the exit button, closes the stage
     */
    public void pressedExitButton() throws Exception{
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../View/MainMenu.fxml")));
        Stage aboutStage = (Stage) ExitButton.getScene().getWindow();
        aboutStage.setScene(new Scene(root));
    }

}
