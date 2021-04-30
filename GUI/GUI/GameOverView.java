package GUI;

import Controllers.QuizController;
import Controllers.StatsController;
import Models.Player;
import Models.Quiz;
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

    @FXML private Label yourScore;

    public void returnToMenuButton(ActionEvent event) throws IOException {
        Parent mainMenuView = FXMLLoader.load(getClass().getResource("TriviaGameMainView.fxml"));
        Scene mainMenuViewScene = new Scene(mainMenuView);

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();

        window.setScene(mainMenuViewScene);
        window.show();
    }

    public void endGameLeaderboardButton(ActionEvent event) throws IOException{
        Parent endGameLeaderboardView = FXMLLoader.load(getClass().getResource("LeaderboardView.fxml"));
        Scene endGameLeaderboardViewScene = new Scene(endGameLeaderboardView);

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();

        window.setScene(endGameLeaderboardViewScene);
        window.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        QuizController.callCalculateScore();
        StatsController.savePlayerData(Player.getPlayerName(),Player.getGameDifficulty(),Player.getGameLength(),Player.getCategoryName(),Player.getPlayerScore());
        yourScore.setText(QuizController.callConvertPlayerScore());

    }
}
