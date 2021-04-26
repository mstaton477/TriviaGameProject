package GUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class LeaderboardView {
    /**
     * This sends the user back to the initial view of the application.
     * @param event
     * @throws IOException
     */
    public void _goBackButton(ActionEvent event) throws IOException {
        Parent backButton = FXMLLoader.load(getClass().getResource("TriviaGameMainView.fxml"));
        Scene backButtonScene = new Scene(backButton);

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();

        window.setScene(backButtonScene);
        window.show();
    }
}
