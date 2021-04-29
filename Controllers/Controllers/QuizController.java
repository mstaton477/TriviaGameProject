
package Controllers;
/*
 * Author @McKenzie
 * Last Updated: 04/28/21
 * This controller connects the views: QuizView and SetUpQuestions
 *  and the models: Player and Quiz.
 */

import GUI.QuizView;
import GUI.SetUpQuestions;
import Models.*;

import java.util.Set;

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

    public static String getGameLength(){
        return SetUpQuestions._lengthChoice;
    }

    public static String getGameDifficulty(){
        return SetUpQuestions._difficultyChoice;
    }

    public static int getCategory(){
        return Player.getCategory();
    }

    public static String getPlayerName(){
            return Player.getPlayerName();
    }

    public static String[] getQuestionsArray(){
        return questionArray;
    }

    // ================================ SETTERS ====================================

    public static void setGameLength(String _gameLength) { Quiz.convertGameLengthStringToIntAndSet(_gameLength);
    }

    public static void setCategory(String _category){
        Quiz.convertCategoryStringToIntAndSet(_category);
    }



    public static void setGameDifficulty(String _gameDifficulty){
        Quiz.convertDifficultyToLowercaseAndSet(_gameDifficulty);
    }


    public static void setPlayerName(String _playerName){
       Player.setPlayerName(_playerName);
    }
}
