package GUI;

/**
 * @author Jayson Williamson
 * Last updated: 4/21/21
 * This class sets up the quiz view and
 */

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Label;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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

    String array[] = {"Question 1: ", "Question 2: "};

    public static String _choice;

    //Some method of looping same scene with new questions/answers to be added
    public void answerAButton(ActionEvent event){
        labelAText = answerALabel.getText();
        _choice = labelAText;
        System.out.println(labelAText);
    }

    public void answerBButton(ActionEvent event){
        labelBText = answerBLabel.getText();
        System.out.println(labelBText);
    }

    public void answerCButton(ActionEvent event){
        labelCText = answerCLabel.getText();
        System.out.println(labelCText);
    }

    public void answerDButton(ActionEvent event){
        labelDText = answerDLabel.getText();
        System.out.println(labelDText);
    }

    public void looper(){

    }

    public void displayQuestion(String _question, ArrayList<String> _choices){

        //Should have question object that contains information about question and answers
        questionLabel.setText(_question);
        answerALabel.setText(_choices.get(0));
        answerBLabel.setText("This is the answer for B");
        answerCLabel.setText("This is the answer for C");
        answerDLabel.setText("This is the answer for D");

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //Made this way for testing purposes currently, questions/answers need to be grabbed from elsewhere
        questionLabel.setText("Question 1: Choose any answer");
        answerALabel.setText("This is the answer for A");
        answerBLabel.setText("This is the answer for B");
        answerCLabel.setText("This is the answer for C");
        answerDLabel.setText("This is the answer for D");


    }
}