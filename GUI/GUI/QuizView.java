package GUI;

/**
 * @author Jayson Williamson
 * Last updated: 4/21/21
 * This class sets up the quiz view and reloads the view again with different variables
 */

import Controllers.QuizController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class QuizView implements Initializable {

    //Sets up fx:ids to link to the fxml
    @FXML private Label questionLabel;
    @FXML private Label answerALabel;
    @FXML private Label answerBLabel;
    @FXML private Label answerCLabel;
    @FXML private Label answerDLabel;

    private String labelAText;
    private String labelBText;
    private String labelCText;
    private String labelDText;

    String questionArray[] = QuizController.getQuestionsArray();
    String answerArray[] = QuizController.getAnswerArray();
    int _iIndex;
    int _jIndex;

    public static String _choice;

    /**
     * Button methods check what the user has chosen for their answer, check if it is the correct answer, and then sets
     * text of the labels to the ones used in the next question.
     * @param event
     * @throws IOException
     */
    public void answerAButton(ActionEvent event) throws IOException{
        labelAText = answerALabel.getText();
        _choice = labelAText;
        System.out.println("You chose: " + _choice);
        if (_iIndex + 2 > questionArray.length){
            QuizController.callCheckIfCorrect();
                Parent endGameLeaderboardView = FXMLLoader.load(getClass().getResource("GameOverView.fxml"));
                Scene endGameLeaderboardViewScene = new Scene(endGameLeaderboardView);

                Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();

                window.setScene(endGameLeaderboardViewScene);
                window.show();
        }
        else {
            QuizController.callCheckIfCorrect();
        _iIndex++;
        questionLabel.setText(questionArray[_iIndex]);
        _jIndex = _jIndex + 4;
        answerALabel.setText(answerArray[_jIndex]);
        answerBLabel.setText(answerArray[_jIndex+1]);
        answerCLabel.setText(answerArray[_jIndex+2]);
        answerDLabel.setText(answerArray[_jIndex+3]);
        }
    }

    /**
     * Button method that checks what the user has chosen for their answer, checks if it is the correct answer, and
     * then sets text of the labels to the ones used in the next question.
     * @param event
     * @throws IOException
     */
    public void answerBButton(ActionEvent event) throws IOException{
        labelBText = answerBLabel.getText();
        _choice = labelBText;
        System.out.println("You chose: " + _choice);
        if (_iIndex + 2 > questionArray.length){
            QuizController.callCheckIfCorrect();
            Parent endGameLeaderboardView = FXMLLoader.load(getClass().getResource("GameOverView.fxml"));
            Scene endGameLeaderboardViewScene = new Scene(endGameLeaderboardView);

            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();

            window.setScene(endGameLeaderboardViewScene);
            window.show();
        }
        else {
            QuizController.callCheckIfCorrect();
            _iIndex++;
            questionLabel.setText(questionArray[_iIndex]);
            _jIndex = _jIndex + 4;
            answerALabel.setText(answerArray[_jIndex]);
            answerBLabel.setText(answerArray[_jIndex + 1]);
            answerCLabel.setText(answerArray[_jIndex + 2]);
            answerDLabel.setText(answerArray[_jIndex + 3]);
        }
    }

    /**
     * Button method that checks what the user has chosen for their answer, checks if it is the correct answer, and
     * then sets text of the labels to the ones used in the next question.
     * @param event
     * @throws IOException
     */
    public void answerCButton(ActionEvent event) throws IOException{
        labelCText = answerCLabel.getText();
        _choice = labelCText;
        System.out.println("You chose: " + _choice);
        if (_iIndex + 2 > questionArray.length){
            QuizController.callCheckIfCorrect();
            Parent endGameLeaderboardView = FXMLLoader.load(getClass().getResource("GameOverView.fxml"));
            Scene endGameLeaderboardViewScene = new Scene(endGameLeaderboardView);

            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();

            window.setScene(endGameLeaderboardViewScene);
            window.show();
        }
        else {
            QuizController.callCheckIfCorrect();
            _iIndex++;
            questionLabel.setText(questionArray[_iIndex]);
            _jIndex = _jIndex + 4;
            answerALabel.setText(answerArray[_jIndex]);
            answerBLabel.setText(answerArray[_jIndex + 1]);
            answerCLabel.setText(answerArray[_jIndex + 2]);
            answerDLabel.setText(answerArray[_jIndex + 3]);
        }
    }

    /**
     * Button method that checks what the user has chosen for their answer, checks if it is the correct answer, and
     * then sets text of the labels to the ones used in the next question.
     * @param event
     * @throws IOException
     */
    public void answerDButton(ActionEvent event) throws IOException{
        labelDText = answerDLabel.getText();
        _choice = labelDText;
        System.out.println("You chose: " + _choice);
        if (_iIndex + 2 > questionArray.length){
            QuizController.callCheckIfCorrect();
            Parent endGameLeaderboardView = FXMLLoader.load(getClass().getResource("GameOverView.fxml"));
            Scene endGameLeaderboardViewScene = new Scene(endGameLeaderboardView);

            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();

            window.setScene(endGameLeaderboardViewScene);
            window.show();
        }
        else {
            QuizController.callCheckIfCorrect();
            _iIndex++;
            questionLabel.setText(questionArray[_iIndex]);
            _jIndex = _jIndex + 4;
            answerALabel.setText(answerArray[_jIndex]);
            answerBLabel.setText(answerArray[_jIndex + 1]);
            answerCLabel.setText(answerArray[_jIndex + 2]);
            answerDLabel.setText(answerArray[_jIndex + 3]);
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //Made this way for testing purposes currently, questions/answers need to be grabbed from elsewhere
        questionLabel.setText(questionArray[_iIndex]);
        answerALabel.setText(answerArray[_jIndex]);
        answerBLabel.setText(answerArray[_jIndex+1]);
        answerCLabel.setText(answerArray[_jIndex+2]);
        answerDLabel.setText(answerArray[_jIndex+3]);


    }
}