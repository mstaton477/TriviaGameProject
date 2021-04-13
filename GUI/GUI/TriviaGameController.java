package GUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class TriviaGameController {
    public void setUpButton(ActionEvent event) throws IOException {
        Parent setUpQuestionsView = FXMLLoader.load(getClass().getResource("SetUpQuestions.fxml"));
        Scene setUpQuestionsViewScene = new Scene(setUpQuestionsView);

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();

        window.setScene(setUpQuestionsViewScene);
        window.show();
    }

    public void backButton(ActionEvent event) throws IOException {
        Parent backButtonView = FXMLLoader.load(getClass().getResource("TriviaGameMainView.fxml"));
        Scene backButtonViewScene = new Scene(backButtonView);

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();

        window.setScene(backButtonViewScene);
        window.show();
    }

    public void leaderboardButton(ActionEvent event){
        System.out.println("Leaderboard under construction...");
    }
    public void quitButton(ActionEvent event){
        System.out.println("Quit clicked, please click the X button in the corner for now.");
    }
    public void beginGameButton(ActionEvent event){
        System.out.println("Game still in development, please look forward to the finished product!");
    }
}
