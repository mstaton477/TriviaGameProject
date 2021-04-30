package GUI;

/**
 * @author Jayson Williamson
 * Updated 4/28/21
 * This class sets up the view for the settings page and allows users to choose different settings for the quiz to have
 * and then sets those values accordingly.
 */

import Models.experimentalCode;
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


public class SetUpQuestions implements Initializable {

    //Sets up fx:ids to link to the fxml
    @FXML
    private ChoiceBox<String> _categoryBox;
    @FXML
    private ChoiceBox<String> _difficultyBox;
    @FXML
    private ChoiceBox<String> _lengthBox;
    @FXML
    private TextField _nameTextField;

    //Additional items for choices users make on this scene.
    public static String _categoryChoice;
    public static String _difficultyChoice;
    public static String _lengthChoice;
    private static String _name;

    /**
     * This sends the user back to the initial view of the application.
     *
     * @param event
     * @throws IOException
     */
    public void backButton(ActionEvent event) throws IOException {
        Parent backButton = FXMLLoader.load(getClass().getResource("TriviaGameMainView.fxml"));
        Scene backButtonScene = new Scene(backButton);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(backButtonScene);
        window.show();
    }

    /**
     * This sends the user to the next page and allows them to play the game. Will grab
     * info from choice boxes for each setting to send to controller accordingly.
     *
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


        QuizController.setGameDifficulty(_difficultyChoice);
        QuizController.setGameLength(_lengthChoice);
        QuizController.setCategory(_categoryChoice);
        QuizController.setPlayerName(_name);


        System.out.println(QuizController.getCategory());
        System.out.println(QuizController.getGameDifficulty());
        System.out.println(QuizController.getGameLength());
        System.out.println(QuizController.getPlayerName());


        QuizController.callAPIRun();
        QuizController.getQuestionsArray();
        for (int i = 0; i < QuizController._questionArray.length; i++) {
            System.out.println(QuizController._questionArray[i]);
        }

        QuizController.getAnswerArray();
        for (int i = 0; i < QuizController._answerArray.length; i++) {
            System.out.println(QuizController._answerArray[i]);
        }



        //Loads the QuizView scene
        Parent beginGameView = FXMLLoader.load(getClass().getResource("QuizView.fxml"));
        Scene beginGameViewScene = new Scene(beginGameView);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(beginGameViewScene);
        window.show();



        /*
        System.out.println(_categoryChoice);
        System.out.println(_difficultyChoice);
        System.out.println(_lengthChoice);
        System.out.println(_name);
         */

    }

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
