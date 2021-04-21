package Models;

import APICode.*;
import Models.Player;

/*
 * Author @McKenzie
 * Last Updated: 4/21/21
 * This class holds all the information related to the quiz.
 */
public class Quiz {

    //to be used to calculate int score
    public int numCorrect;

    public void quiz() {

    }

    //checks if the answer choice exists in the correctAnswer array
    public void checkIfCorrect(String[] correctAnswers, String _choice){
        for(String s : correctAnswers){
            if(_choice.equals(s)){
                System.out.println("Correct Answer Chosen, Good Job!");
                numCorrect++;
            }
        }
    }

    public int calculateScore(int _gameLength, int _numCorrect, int _playerScore){
        _playerScore = _numCorrect/_gameLength;

        return _playerScore;
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
