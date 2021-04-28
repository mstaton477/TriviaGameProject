package Models;

import APICode.API;
import APICode.Answers;
import APICode.Questions;
import APICode.SplitAndJoin;
import Controllers.QuizController;
import GUI.QuizView;

import java.util.Locale;

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
    public static String[] questionArray;
    public static String[] answerArray;


    private static final String generalKnowledge = "General Knowledge";
    private static final String science = "Science & Nature";
    private static final String computers = "Science: Computers";
    private static final String music = "Entertainment: Music";
    private static final String videoGames = "Entertainment: Video Games";
    private static final String film = "Entertainment: Film";
    private static final String anime = "Entertainment: Japanese Anime & Manga";

    private static final int generalKnowledgeInt = 9;
    private static final int scienceInt = 17;
    private static final int computersInt = 18;
    private static final int musicInt = 12;
    private static final int videoGamesInt = 15;
    private static final int filmInt = 11;
    private static final int animeInt = 31;

    private static final String shortGameLength = "10";
    private static final String medGameLength = "20";
    private static final String longGameLength = "30";


    public void quiz() {

    }

    //checks if the answer choice exists in the correctAnswer array
    public static void checkIfCorrect(String[] _correctAnswer, String _choice) {
        for (String s : _correctAnswer) {
            if (_choice.equals(s)) {
                System.out.println("Correct Answer Chosen, Good Job!");
                numCorrect++;
            }
        }
    }

    //helper method for checkIfCorrect
    public static void checkIfCorrect() {
        checkIfCorrect(_correctAnswer, _choice);
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

    public static void calculateScore() {
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

    public static void convertCategoryStringToIntAndSet() {
        String conversion = QuizController.getCategoryChoice();
        if (conversion.equals(generalKnowledge)) {
            QuizController.setCategory(generalKnowledgeInt);
        } else if (conversion.equals(science)) {
            QuizController.setCategory(scienceInt);
        } else if (conversion.equals(computers)) {
            QuizController.setCategory(computersInt);
        } else if (conversion.equals(music)) {
            QuizController.setCategory(musicInt);
        } else if (conversion.equals(videoGames)) {
            QuizController.setCategory(videoGamesInt);
        } else if (conversion.equals(film)) {
            QuizController.setCategory(filmInt);
        } else if (conversion.equals(anime)) {
            QuizController.setCategory(animeInt);
        }
    }

    public static void convertDifficultyToLowercaseAndSet() {
        String difficulty = QuizController.getGameDifficulty();
        difficulty.toLowerCase();
        QuizController.setGameDifficulty(difficulty);
    }

    public static void convertGameLengthStringToIntAndSet() {
        String length = QuizController.getGameLength();
        if(length.equals(shortGameLength)){
            QuizController.setGameLength(gameLengthShort);
        }else if(length.equals(medGameLength)){
            QuizController.setGameLength(gameLengthMedium);
        }else if(length.equals(longGameLength)){
            QuizController.setGameLength(gameLengthLong);
        }
    }


    // ================================ GETTERS ====================================
    public int getNumCorrect() {
        return numCorrect;
    }

    public static String[] getQuestionArray() {
        Questions.question();
        return questionArray = Questions._questionArray;
    }

    public static String[] getAnswerArray() {


        return answerArray = SplitAndJoin._answerArray;
    }
    // ================================ SETTERS ====================================

    public void setNumCorrect(int _numCorrect) {
        this.numCorrect = _numCorrect;
    }
}
