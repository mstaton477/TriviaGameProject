
package GUI;


/**
 * @author Jayson Williamson
 * Updated 4/21/21
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
<<<<<<< Updated upstream
=======
import javafx.scene.control.Label;
>>>>>>> Stashed changes
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
<<<<<<< Updated upstream
import java.time.LocalDate;
import java.util.ResourceBundle;

public class LeaderboardView implements Initializable {


    //Sets up fx:ids to link to the fxml
    @FXML private TableView<Leaderboard> _tableView;
    @FXML private TableColumn<Leaderboard, String> _nameColumn;
    @FXML private TableColumn<Leaderboard, Integer> _scoreColumn;
    @FXML private TableColumn<Leaderboard, String> _categoryColumn;
    @FXML private TableColumn<Leaderboard, String> _difficultyColumn;
    @FXML private TableColumn<Leaderboard, Integer> _lengthColumn;
    @FXML private TableColumn<Leaderboard, LocalDate> _datePlayedColumn;

    ObservableList<Leaderboard> _observableList = FXCollections.observableArrayList();


/**
=======
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ResourceBundle;



public class LeaderboardView implements Initializable {
    /**
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        _nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        _scoreColumn.setCellValueFactory(new PropertyValueFactory<>("score"));
        _categoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));
        _difficultyColumn.setCellValueFactory(new PropertyValueFactory<>("difficulty"));
        _lengthColumn.setCellValueFactory(new PropertyValueFactory<>("length"));
        _datePlayedColumn.setCellValueFactory(new PropertyValueFactory<>("datePlayed"));

        _tableView.setItems(_observableList);
    }

=======
    @FXML
    private Label label;
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
>>>>>>> Stashed changes
}

