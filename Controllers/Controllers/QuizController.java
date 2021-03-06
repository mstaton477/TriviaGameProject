
package Controllers;
/*
 * Author @McKenzie
 * Last Updated: 04/30/21
 * This controller connects the views: QuizView and SetUpQuestions
 *  and the models: Player and Quiz.
 */


import Models.*;


import static Models.Quiz.*;


public class QuizController {
    public static String[] _questionArray;
    public static String[] _answerArray;

    public static void callCheckIfCorrect() {
        Quiz.checkIfCorrect();
    }

    public static void callCalculateScore() {
        Quiz.calculateScore();
    }

    public static void callRandomizeArray(){
        Quiz.randomizeAnswerArray();
    }


    public static void callAPIRun() {
        Quiz.APIRun();
    }
    public static String callConvertPlayerScore(){
        String playerScoreString = Quiz.convertPlayerScoreToString();
        return playerScoreString;
    }


    // ================================ GETTERS ====================================

    //gets the player answer choice from the quiz view to use in the
    // check if correct method


    public static int getGameLength() {
        return Player.getGameLength();
    }

    public static String getGameDifficulty() {
        return Player.getGameDifficulty();
    }

    public static int getCategory() {
        return Player.getCategory();
    }

    public static String getPlayerName() {
        return Player.getPlayerName();
    }

    public static String[] getQuestionsArray() {
        Quiz.getQuestionArray();
        return _questionArray = questionArray;
    }

    public static String[] getAnswerArray() {
        Quiz.getAnswerArray();
        return _answerArray = answerArray;
    }

    // ================================ SETTERS ====================================


    public static void setGameLength(String _gameLength) {
        Quiz.convertGameLengthStringToIntAndSet(_gameLength);
    }

    public static void setCategory(String _category) {
        Quiz.convertCategoryStringToIntAndSet(_category);
    }


    public static void setGameDifficulty(String _gameDifficulty) {
      /* Quiz.setGameDifficulty(_gameDifficulty);*/

        Quiz.convertDifficultyToLowercaseAndSet();
    }


    public static void setPlayerName(String _playerName) {
        Player.setPlayerName(_playerName);
    }
}
