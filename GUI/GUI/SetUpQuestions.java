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

public class SetUpQuestions implements Initializable {
    //These items are for allowing users to choose the settings of the game.
    @FXML private ChoiceBox<String> categoryBox;
    @FXML private ChoiceBox<String> difficultyBox;
    @FXML private ChoiceBox<String> lengthBox;

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
        categoryBox.getItems().addAll("General Knowledge", "Entertainment: Music", "Entertainment: Video Games", "Science & Nature", "Science: Computers", "Science: Mathematics", "Entertainment: Japanese Anime & Manga");

        //Options for difficulty
        difficultyBox.getItems().addAll("Easy", "Medium", "Hard");

        //Options for game length
        lengthBox.getItems().addAll("Short (10)", "Medium (20)", "Long (30)");
    }
}
