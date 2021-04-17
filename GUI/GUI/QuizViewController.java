package GUI;

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
import java.util.ResourceBundle;

public class QuizViewController implements Initializable {
    @FXML private Label questionLabel;
    @FXML private Label answerALabel;
    @FXML private Label answerBLabel;
    @FXML private Label answerCLabel;
    @FXML private Label answerDLabel;

    public void answerAButton(ActionEvent event){
        System.out.println("Answer A Pressed");
    }

    public void answerBButton(ActionEvent event){
        System.out.println("Answer B Pressed");
    }

    public void answerCButton(ActionEvent event){
        System.out.println("Answer C Pressed");
    }

    public void answerDButton(ActionEvent event){
        System.out.println("Answer D Pressed");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        questionLabel.setText("Question 1: ");
        answerALabel.setText("This is an answer");
        answerBLabel.setText("This is an answer");
        answerCLabel.setText("This is an answer");
        answerDLabel.setText("This is an answer");


    }
}
