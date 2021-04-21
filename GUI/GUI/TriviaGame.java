package GUI;

/**
 * @author Jayson Williamson
 * Updated 4/21/21
 * This class sets up the initial view users see when launching the trivia game.
 */

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class TriviaGame {


    /**
     * This is for changing the scene to the view used for setting up the questions of the game.
     * @param event
     * @throws IOException
     */
    public void setUpButton(ActionEvent event) throws IOException {
        Parent setUpQuestionsView = FXMLLoader.load(getClass().getResource("SetUpQuestions.fxml"));
        Scene setUpQuestionsViewScene = new Scene(setUpQuestionsView);

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();

        window.setScene(setUpQuestionsViewScene);
        window.show();
    }

    public void leaderboardButton(ActionEvent event){
        System.out.println("Leaderboard under construction...");
    }

    //Closes the program.
    @FXML
    public void quitButton(ActionEvent event){
        ((Stage)(((Node)event.getSource()).getScene().getWindow())).close();
    }

}
