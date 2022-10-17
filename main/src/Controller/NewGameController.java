package Controller;

import Model.Entities.Player;
import Model.Events.Event;
import Model.Events.EventSuper;
import Model.Factories.PlayerFactory;
import Model.Model;
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
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class NewGameController implements Initializable {

    private Model gameModel;

    protected Text createCharacterText = new Text("Create your character");
    private String selectedClassString = "";
    private String selectedNameString = "";

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


    @FXML
    void selectClass() {
        this.selectedClassString = classComboBox.getSelectionModel().getSelectedItem();
        if(selectedClassString.equals("Create your own")){
            createYourOwnClass.toFront();
        } else
            createYourOwnClass.toBack();
    }
    @FXML
    void nameSubmit(){
        String name = playerName.getText();
        setName(name);
    }
    void setName(String name){
        this.selectedNameString = name;
    }
    Model getGameModel(){
        return gameModel;
    }

    @FXML
    private void continueButton() throws Exception {
        if(selectedNameString.equals("") && selectedClassString.equals("")){
            setContinueWarning("You need to choose a name and pick a class!");

        } else if (!selectedNameString.equals("") && selectedClassString.equals("")){
            setContinueWarning("You need to pick a class!");

        } else if (selectedNameString.equals("")){
            setContinueWarning("You need to choose a name!");

        } else
        System.out.println(selectedNameString + " is a " + selectedClassString);
        if(selectedClassString.equals("Warrior")){
            gameModel = new Model(PlayerFactory.createWarriorPlayer(selectedNameString), Event.getEvent("assets/allEvents/startEvent.xml"));
        } else if (selectedClassString.equals("Hunter")){
            gameModel = new Model(PlayerFactory.createHunterPlayer(selectedNameString), Event.getEvent("assets/allEvents/startEvent.xml"));
        } else {
            gameModel = new Model(PlayerFactory.createPlayer(strengthSpinner.getValue(), 10, armourSpinner.getValue(), selectedNameString), Event.getEvent("assets/allEvents/startEvent.xml"));
        }
        System.out.println(gameModel.getPlayerStrength());
        System.out.println(gameModel.getPlayerArmour());
        Model.gameModel = gameModel;
        startGameView(gameModel);
    }
    public void startGameView(Model gameModel) throws Exception{
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../View/GameView.fxml")));
        Stage aboutStage = (Stage) ExitButton.getScene().getWindow();
        aboutStage.setScene(new Scene(root));
    }

    private void setContinueWarning(String warning){
        continueWarning.setText(warning);
        continueWarning.setAlignment(Pos.CENTER);
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        createCharacter = new TextFlow(createCharacterText);
        ObservableList<String> selectClassList = FXCollections.observableArrayList("Warrior", "Hunter", "Create your own");
        classComboBox.setItems(selectClassList);
        spinnerSetup();

    }

    private void spinnerSetup(){
        SpinnerValueFactory<Double> valueFactoryStrength = new SpinnerValueFactory.DoubleSpinnerValueFactory(0, 10, 0, 1);
        SpinnerValueFactory<Double> valueFactoryArmour = new SpinnerValueFactory.DoubleSpinnerValueFactory(0, 10, 0, 1);
        strengthSpinner.setValueFactory(valueFactoryStrength);
        armourSpinner.setValueFactory(valueFactoryArmour);
    }

    public void pressedExitButton() throws Exception{
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../View/MainMenu.fxml")));
        Stage aboutStage = (Stage) ExitButton.getScene().getWindow();
        aboutStage.setScene(new Scene(root));
    }

}
