package GUI;

/**
 * @author Jayson Williamson and Patrick Ksor
 * Updated 4/30/21
 * This class sets up the view for the leaderboard scene.
 */

import Models.Leaderboard;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ResourceBundle;

public class LeaderboardView implements Initializable {

    //Sets up fx:ids to link to the fxml
    @FXML
    private TableView<Leaderboard> LeaderBoard;
    @FXML
    private TableColumn<Leaderboard,String> col_name;
    @FXML
    private TableColumn<Leaderboard,Integer> col_playerScore;
    @FXML
    private TableColumn<Leaderboard,String> col_category;
    @FXML
    private TableColumn<Leaderboard,String> col_gameDifficulty;
    @FXML
    private TableColumn<Leaderboard,Integer> col_gameLength;
    @FXML
    private TableColumn<Leaderboard, Timestamp> col_datePlayed;

    private ObservableList<Leaderboard> data;

    /**
     * This sends the user back to the initial view of the application.
     * @param event
     * @throws IOException
     */
    public void _goBackButton(ActionEvent event) throws IOException {
        Parent backButton = FXMLLoader.load(getClass().getResource("MainMenuView.fxml"));
        Scene backButtonScene = new Scene(backButton);

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();

        window.setScene(backButtonScene);
        window.show();
    }

    /**
     * Initializes items into the table view and displays them when the scene is loaded.
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            data= FXCollections.observableArrayList(Leaderboard.populateLeaderboard());
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        col_name.setCellValueFactory((new PropertyValueFactory<>("name")));
        col_playerScore.setCellValueFactory((new PropertyValueFactory<>("score")));
        col_category.setCellValueFactory((new PropertyValueFactory<>("category")));
        col_gameDifficulty.setCellValueFactory((new PropertyValueFactory<>("difficulty")));
        col_gameLength.setCellValueFactory((new PropertyValueFactory<>("length")));
        col_datePlayed.setCellValueFactory((new PropertyValueFactory<>("timestamp")));
        LeaderBoard.setItems(null);
        LeaderBoard.setItems(data);
    }
}

