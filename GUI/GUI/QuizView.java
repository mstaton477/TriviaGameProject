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

    //Variables necessary for the quiz
    @FXML private Label questionLabel;
    @FXML private Label answerALabel;
    @FXML private Label answerBLabel;
    @FXML private Label answerCLabel;
    @FXML private Label answerDLabel;

    private String labelAText;
    private String labelBText;
    private String labelCText;
    private String labelDText;

    String questionArray[] = {"Question 1: ", "Question 2: ", "Question 3: ", "Question 4: ", "Question 5: ",
            "Question 6: ", "Question 7: ","Question 8: ", "Question 9: ", "Question 10: "};

    String answerArray[] = {"Answer 1a", "Answer 1b", "Answer 1c", "Answer 1d", "Answer 2a", "Answer 2b", "Answer 2c", "Answer 2d",
            "Answer 3a", "Answer 3b", "Answer 3c", "Answer 3d", "Answer 4a", "Answer 4b", "Answer 4c", "Answer 4d",
            "Answer 5a", "Answer 5b", "Answer 5c", "Answer 5d","Answer 6a", "Answer 6b", "Answer 6c", "Answer 6d",
            "Answer 7a", "Answer 7b", "Answer 7c", "Answer 7d","Answer 8a", "Answer 8b", "Answer 8c", "Answer 8d",
            "Answer 9a", "Answer 9b", "Answer 9c", "Answer 9d","Answer 10a", "Answer 10b", "Answer 10c", "Answer 10d"};
    int i;
    int j;

    public static String _choice;

    //Some method of looping same scene with new questions/answers to be added
    public void answerAButton(ActionEvent event){
        labelAText = answerALabel.getText();
        _choice = labelAText;
        i++;
        questionLabel.setText(questionArray[i]);
        j = j + 4;
        answerALabel.setText(answerArray[j]);
        answerBLabel.setText(answerArray[j+1]);
        answerCLabel.setText(answerArray[j+2]);
        answerDLabel.setText(answerArray[j+3]);
        System.out.println("You chose: " + _choice);
    }

    public void answerBButton(ActionEvent event){
        labelBText = answerBLabel.getText();
        _choice = labelBText;
        i++;
        questionLabel.setText(questionArray[i]);
        j = j + 4;
        answerALabel.setText(answerArray[j]);
        answerBLabel.setText(answerArray[j+1]);
        answerCLabel.setText(answerArray[j+2]);
        answerDLabel.setText(answerArray[j+3]);
        System.out.println("You chose: " + _choice);
    }

    public void answerCButton(ActionEvent event){
        labelCText = answerCLabel.getText();
        _choice = labelCText;
        i++;
        questionLabel.setText(questionArray[i]);
        j = j + 4;
        answerALabel.setText(answerArray[j]);
        answerBLabel.setText(answerArray[j+1]);
        answerCLabel.setText(answerArray[j+2]);
        answerDLabel.setText(answerArray[j+3]);
        System.out.println("You chose: " + _choice);
    }

    public void answerDButton(ActionEvent event){
        labelDText = answerDLabel.getText();
        _choice = labelDText;
        i++;
        questionLabel.setText(questionArray[i]);
        j = j + 4;
        answerALabel.setText(answerArray[j]);
        answerBLabel.setText(answerArray[j+1]);
        answerCLabel.setText(answerArray[j+2]);
        answerDLabel.setText(answerArray[j+3]);
        System.out.println("You chose: " + _choice);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //Made this way for testing purposes currently, questions/answers need to be grabbed from elsewhere
        questionLabel.setText(questionArray[i]);
        answerALabel.setText(answerArray[j]);
        answerBLabel.setText(answerArray[j+1]);
        answerCLabel.setText(answerArray[j+2]);
        answerDLabel.setText(answerArray[j+3]);


    }
}