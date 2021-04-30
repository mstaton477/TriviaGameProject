package GUI;

/**
 * @author Jayson Williamson
 * Updated 4/30/21
 * This class sets up the initial view users see when launching the trivia game.
 */

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class MainMenuView {

    /**
     * Creates an action event that happens when the settings button is pressed that loads the leaderboard view.
     * @param event
     * @throws IOException
     */
    public void setUpButton(ActionEvent event) throws IOException {
        Parent setUpQuestionsView = FXMLLoader.load(getClass().getResource("SettingsView.fxml"));
        Scene setUpQuestionsViewScene = new Scene(setUpQuestionsView);

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();

        window.setScene(setUpQuestionsViewScene);
        window.show();
    }

    /**
     * Creates an action event that happens when the leaderboard button is pressed that loads the leaderboard view.
     * @param event
     * @throws IOException
     */
    public void leaderboardButton(ActionEvent event) throws IOException{
        Parent leaderboardView = FXMLLoader.load(getClass().getResource("LeaderboardView.fxml"));
        Scene leaderboardViewScene = new Scene(leaderboardView);

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();

        window.setScene(leaderboardViewScene);
        window.show();
    }

    /**
     * Creates an action event that happens when the quit button is pressed that closes the program.
     * @param event
     */
    public void quitButton(ActionEvent event){
        ((Stage)(((Node)event.getSource()).getScene().getWindow())).close();
    }

}
