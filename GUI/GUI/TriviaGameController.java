package GUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class TriviaGameController {


    /**
     * This is for changing the scene to the view used for setting up the questions of the game.
     * @param event
     * @throws IOException
     */
    public void setUpButton(ActionEvent event) throws IOException {
        Parent setUpQuestionsView = FXMLLoader.load(getClass().getResource("SetUpQuestions.fxml"));
        Scene setUpQuestionsViewScene = new Scene(setUpQuestionsView);

        //Gets the stage information
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();

        window.setScene(setUpQuestionsViewScene);
        window.show();
    }

    public void leaderboardButton(ActionEvent event){
        System.out.println("Leaderboard under construction...");
    }
    public void quitButton(ActionEvent event){
        System.out.println("Quit clicked, please click the X button in the corner for now.");
    }

}
