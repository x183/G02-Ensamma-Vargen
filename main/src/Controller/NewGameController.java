package Controller;

import Model.Events.EventSuper;
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
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

import java.net.URL;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class NewGameController implements Initializable {

    //EventSuper event;
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
    void selectClass() {
        this.selectedClassString = classComboBox.getSelectionModel().getSelectedItem();
    }
    @FXML
    void nameSubmit(){
        String name = playerName.getText();
        setName(name);
    }
    void setName(String name){
        this.selectedNameString = name;
    }

    @FXML
    private void continueButton(){
        if(selectedNameString.equals("") && selectedClassString.equals("")){
            setContinueWarning("You need to choose a name and pick a class!");

        } else if (!selectedNameString.equals("") && selectedClassString.equals("")){
            setContinueWarning("You need to pick a class!");

        } else if (selectedNameString.equals("")){
            setContinueWarning("You need to choose a name!");

        } else
        System.out.println(selectedNameString + " is a " + selectedClassString);
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
    }

    public void pressedExitButton() throws Exception{
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../View/MainMenu.fxml")));
        Stage aboutStage = (Stage) ExitButton.getScene().getWindow();
        aboutStage.setScene(new Scene(root));
    }

}
