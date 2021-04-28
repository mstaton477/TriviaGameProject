
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

    public static String getChoice(){
        return QuizView._choice;
    }

    public static String getCategoryChoice(){
        return SetUpQuestions._categoryChoice;
    }

    public static int getGameLength(){
        return Player.gameLength;
    }

    public static String getGameDifficulty(){
        return Player.gameDifficulty;
    }

    public static int getCategory(){
        return Player.category;
    }

    public static String getPlayerName(){
        return Player.playerName;
    }

    // ================================ SETTERS ====================================

    public static void setGameLength(int _gameLength){
      Player.gameLength = _gameLength;
    }

    public static void setCategory(int _category){
        Player.category = _category;
    }


    public static void setGameDifficulty(String _gameDifficulty){
        Player.gameDifficulty = _gameDifficulty;
    }


    public static void setPlayerName(String _playerName){
        Player.playerName = _playerName;
    }
}
