package GUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SetUpQuestionsController implements Initializable {
    //These items are for allowing users to choose the settings of the game.
    @FXML private ChoiceBox categoryBox;
    @FXML private ChoiceBox difficultyBox;
    @FXML private ChoiceBox lengthBox;

    /**
     * This sends the user back to the main view of the application.
     * @param event
     * @throws IOException
     */
    public void backButton(ActionEvent event) throws IOException {
        Parent backButton = FXMLLoader.load(getClass().getResource("TriviaGameMainView.fxml"));
        Scene backButtonScene = new Scene(backButton);

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();

        window.setScene(backButtonScene);
        window.show();
    }

    /**
     * This sends the user to the next page and allows them to play the game.
     * @param event
     * @throws IOException
     */
    public void beginGameButton(ActionEvent event)throws IOException{
        Parent beginGameView = FXMLLoader.load(getClass().getResource("QuizView.fxml"));
        Scene beginGameViewScene = new Scene(beginGameView);

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();

        window.setScene(beginGameViewScene);
        window.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //Options for Categories
        categoryBox.getItems().add("General Knowledge");
        categoryBox.getItems().add("Entertainment: Music");
        categoryBox.getItems().add("Entertainment: Video Games");
        categoryBox.getItems().add("Science & Nature");
        categoryBox.getItems().add("Science: Computers");
        categoryBox.getItems().add("Science: Mathematics");
        categoryBox.getItems().add("Entertainment: Japanese Anime & Manga");

        //Options for difficulty
        difficultyBox.getItems().add("Easy");
        difficultyBox.getItems().add("Medium");
        difficultyBox.getItems().add("Hard");

        //Options for game length
        lengthBox.getItems().add("Short (10)");
        lengthBox.getItems().add("Medium (20)");
        lengthBox.getItems().add("Long (30)");
    }
}
