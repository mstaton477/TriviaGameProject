package Models;

import APICode.API;
import Controllers.QuizController;

import static APICode.Answers._correctAnswer;
import static GUI.QuizView._choice;

/*
 * Author @McKenzie
 * Last Updated: 4/21/21
 * This class holds all the information related to the quiz.
 */
public class Quiz {

    //to be used to calculate int score
    public static int numCorrect;

    private static final int gameLengthShort = 10;
    private static final int gameLengthMedium = 20;
    private static final int gameLengthLong = 30;

    //multipliers for different game lengths
    private static final int multiLong = 3;
    private static final int multiMedium = 2;
    private static final int multiShort = 1;

    private static final String specialPlayerName = "Ike";
    private static final int specialMulti = 1000;


    public void quiz() {

    }

    //checks if the answer choice exists in the correctAnswer array
    public static void checkIfCorrect(String[]  _correctAnswer, String _choice) {
        for (String s :  _correctAnswer) {
            if (_choice.equals(s)) {
                System.out.println("Correct Answer Chosen, Good Job!");
                numCorrect++;
            }
        }
    }
    //helper method for checkIfCorrect
    public static void checkIfCorrect(){
        checkIfCorrect( _correctAnswer, _choice);
    }

    //calculates the player Score based on number correct and game length
    // each game length has its own multiplyer.
    public static int calculateScore(int _gameLength, int _numCorrect, int _playerScore) {
        _playerScore = _numCorrect / _gameLength;

        if (_gameLength == gameLengthLong) {
            return _playerScore * multiLong;

        } else if (_gameLength == gameLengthMedium) {
            return _playerScore * multiMedium;
        } else if (_gameLength == gameLengthShort) {
            return _playerScore * multiShort;
        }

        if (checkIfSpecialPlayer()) {
            return _playerScore * specialMulti;
        }

        return _playerScore;
    }

    public static void calculateScore(){
        calculateScore(Player.gameLength, Quiz.numCorrect, Player.playerScore);
    }

    //helper method for checkIfSpecialPlayer
    private static boolean checkIfSpecialPlayer() {
        if (checkIfSpecialPlayer(Player.playerName, Player.playerScore)) {
            return true;
        }
        return false;

    }

    //checks if the player's name is Ike.
    public static boolean checkIfSpecialPlayer(String _playerName, int _playerScore) {
        if (_playerName == specialPlayerName) {
            return true;
        }
        return false;
    }

    public static void convertCategoryStringToInt(){
        String conversion = QuizController.getCategoryChoice();

    }



    // ================================ GETTERS ====================================
    public int getNumCorrect() {
        return numCorrect;
    }
    // ================================ SETTERS ====================================

    public void setNumCorrect(int _numCorrect) {
        this.numCorrect = _numCorrect;
    }
}
