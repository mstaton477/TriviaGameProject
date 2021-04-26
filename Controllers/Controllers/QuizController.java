
package Controllers;
/*
 * Author @McKenzie
 * Last Updated: 04/21/21
 * This controller connects the views: QuizView and SetUpQuestions
 *  and the models: Player and Quiz.
 */

import GUI.QuizView;
import GUI.SetUpQuestions;
import Models.*;

import static Models.Quiz.*;


public class QuizController {

    public void callCheckIfCorrect(){
        Quiz.checkIfCorrect();
    }

    public void callCalculateScore(){
        Quiz.calculateScore();
    }


    // ================================ GETTERS ====================================

    //gets the player answer choice from the quiz view to use in the
    // check if correct method

    public String getChoice(){
        return QuizView._choice;
    }

    public int getGameLength(){
        return Player.gameLength;
    }

    public String getGameDifficulty(){
        return Player.gameDifficulty;
    }

    public int getCategory(){
        return Player.category;
    }

    public String getPlayerName(){
        return Player.playerName;
    }

    // ================================ SETTERS ====================================

    public void setGameLength(int _gameLength){
      Player.gameLength = _gameLength;
    }

    public void setCategory(int _category){
        Player.category = _category;
    }


    public void setGameDifficulty(String _gameDifficulty){
        Player.gameDifficulty = _gameDifficulty;
    }


    public void setPlayerName(String _playerName){
        Player.playerName = _playerName;
    }
}
