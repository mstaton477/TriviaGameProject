package GUI;

/**
 * @author Jayson Williamson
 * Updated 4/30/21
 * This class sets up the view users see when loading the leaderboard.
 */

import Controllers.QuizController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GameOverView implements Initializable {

    //Sets up fx:id for the player's score to link to the fxml.
    @FXML
    private Label yourScore;

    /**
     * This causes the back button to fire an event that loads the main menu and sends the user back to the main menu
     * of the game.
     * @param event
     * @throws IOException
     */
    public void returnToMenuButton(ActionEvent event) throws IOException {
        Parent mainMenuView = FXMLLoader.load(getClass().getResource("MainMenuView.fxml"));
        Scene mainMenuViewScene = new Scene(mainMenuView);

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();

        window.setScene(mainMenuViewScene);
        window.show();
    }

    /**
     * This causes the leaderboard button to fire an event that loads the leaderboard view and sends the user back to
     * the main menu of the game.
     * @param event
     * @throws IOException
     */
    public void endGameLeaderboardButton(ActionEvent event) throws IOException{
        Parent endGameLeaderboardView = FXMLLoader.load(getClass().getResource("LeaderboardView.fxml"));
        Scene endGameLeaderboardViewScene = new Scene(endGameLeaderboardView);

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();

        window.setScene(endGameLeaderboardViewScene);
        window.show();
    }

    /**
     * Initializes the player's score and places it within a label to be displayed to the user.
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        QuizController.callCalculateScore();
        yourScore.setText(QuizController.callConvertPlayerScore());

    }
}
