package GUI;

/**
 * @author Jayson Williamson
 * Updated 4/30/21
 * This class sets up the view for the settings page and allows users to choose different settings for the quiz to have
 * and then sets those values accordingly.
 */

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import Controllers.*;

public class SettingsView implements Initializable {

    //Sets up fx:ids to link to the fxml
    @FXML
    private ChoiceBox<String> _categoryBox;
    @FXML
    private ChoiceBox<String> _difficultyBox;
    @FXML
    private ChoiceBox<String> _lengthBox;
    @FXML
    private TextField _nameTextField;

    //Creates variables to be used later in code.
    public static String _categoryChoice;
    public static String _difficultyChoice;
    public static String _lengthChoice;
    private static String _name;

    /**
     * This causes the back button to fire an event that sends the user back to the main menu of the application.
     * @param event
     * @throws IOException
     */
    public void backButton(ActionEvent event) throws IOException {
        Parent backButton = FXMLLoader.load(getClass().getResource("MainMenuView.fxml"));
        Scene backButtonScene = new Scene(backButton);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(backButtonScene);
        window.show();
    }

    /**
     * This causes the begin game button to fire an event that loads the settings view and allows the user to
     * choose how they play the game. Grabs info from choice boxes for each setting to send to controller.
     * @param event
     * @throws IOException
     */
    public void beginGameButton(ActionEvent event) throws IOException {

        //Gets the value from each different choice box for use later
        _categoryChoice = _categoryBox.getValue();
        _difficultyChoice = _difficultyBox.getValue();
        _lengthChoice = _lengthBox.getValue();

        //Gets the value from the name text area for use later
        _name = _nameTextField.getText();

        //Sets each of the player's choices by calling the quiz controller.
        QuizController.setGameDifficulty(_difficultyChoice);
        QuizController.setGameLength(_lengthChoice);
        QuizController.setCategory(_categoryChoice);
        QuizController.setPlayerName(_name);

        //Displays the choices the player has made.
        System.out.println(QuizController.getCategory());
        System.out.println(QuizController.getGameDifficulty());
        System.out.println(QuizController.getGameLength());
        System.out.println(QuizController.getPlayerName());

        //Calls a method to set up the API and also calls a method that randomizes the array of answers.
        QuizController.callAPIRun();
        QuizController.callRandomizeArray();

        //Loads the QuizView scene
        Parent beginGameView = FXMLLoader.load(getClass().getResource("QuizView.fxml"));
        Scene beginGameViewScene = new Scene(beginGameView);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(beginGameViewScene);
        window.show();
    }

    /**
     * Sets up what goes into each choice box when this view is loaded.
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //Options for Categories
        _categoryBox.getItems().addAll("General Knowledge", "Science & Nature", "Science: Computers",
                "Entertainment: Music", "Entertainment: Video Games", "Entertainment: Film",
                "Entertainment: Japanese Anime & Manga");

        //Options for difficulty
        _difficultyBox.getItems().addAll("Easy", "Medium", "Hard");

        //Options for game length
        _lengthBox.getItems().addAll("10", "20", "30");

    }
}
