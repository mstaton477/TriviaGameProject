package Models;

import APICode.*;
import Controllers.QuizController;
import GUI.QuizView;
import GUI.SetUpQuestions;

import java.util.Arrays;
import java.util.Collections;
import java.util.Locale;

import static APICode.Answers._correctAnswer;
import static GUI.QuizView._choice;

/*
 * Author @McKenzie
 * Last Updated: 4/30/21
 * This class holds all the information related to the quiz.
 */
public class Quiz {

    //to be used to calculate int score
    public static int numCorrect;
    public static String stringPlayerScore;

    private static final int gameLengthShort = 10;
    private static final int gameLengthMedium = 20;
    private static final int gameLengthLong = 30;

    //multipliers for different game lengths
    private static final int multiLong = 3;
    private static final int multiMedium = 2;
    private static final int multiShort = 1;

    private static final String specialPlayerName = "Ike";
    private static final int specialMulti = 1000;

    //stores the question and answer arrays in the quiz model to use in the Quiz Controller.
    public static String[] questionArray;
    public static String[] answerArray;

    //enumeration for categories and the integers used to call them in the API.
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

    //enumeration of game lengths
    private static final String shortGameLength = "10";
    private static final String medGameLength = "20";
    private static final String longGameLength = "30";


    //checks if the answer choice exists in the correctAnswer array
    private static void checkIfCorrect(String[] _correctAnswer, String _choice) {

        boolean found = Arrays.asList(_correctAnswer).contains(_choice);
        if (found) {
            System.out.println("Correct Answer Chosen, Good Job!");
            numCorrect++;
        } else {
            System.out.println("Incorrect Answer Chose :(");
        }
    }

    //helper method for checkIfCorrect
    public static void checkIfCorrect() {
        checkIfCorrect(_correctAnswer, _choice);
    }

    //calculates the player Score based on number correct and game length

    // each game length has its own multiplier.

    public static void calculateScore(int _gameLength, int _numCorrect, int _playerScore) {
        _gameLength = QuizController.getGameLength();

        if (_gameLength == gameLengthLong) {
            _playerScore = numCorrect * multiLong;

        } else if (_gameLength == gameLengthMedium) {
            _playerScore = numCorrect * multiMedium;
        } else if (_gameLength == gameLengthShort) {
            _playerScore = numCorrect * multiShort;
        }

        if (checkIfSpecialPlayer()) {
            _playerScore = numCorrect * specialMulti;
        }

        Player.setPlayerScore(_playerScore);
    }

    //helper method for calculate score.
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

    //Gets the category string from the Set Up Questions View,
    //and then converts to its associated integer for the API call.
    public static void convertCategoryStringToIntAndSet(String _conversion) {
        if (_conversion.equals(generalKnowledge)) {
            Player.setCategory(generalKnowledgeInt);
        } else if (_conversion.equals(science)) {
            Player.setCategory(scienceInt);
        } else if (_conversion.equals(computers)) {
            Player.setCategory(computersInt);
        } else if (_conversion.equals(music)) {
            Player.setCategory(musicInt);
        } else if (_conversion.equals(videoGames)) {
            Player.setCategory(videoGamesInt);
        } else if (_conversion.equals(film)) {
            Player.setCategory(filmInt);
        } else if (_conversion.equals(anime)) {
            Player.setCategory(animeInt);
        }
    }


    public static String convertPlayerScoreToString() {
        String stringPlayerScore = String.valueOf(Player.playerScore);
        return stringPlayerScore;
    }


    //Coverts the difficulty string received from the GUI to lower case, because
    //of API call format.
    public static void convertDifficultyToLowercaseAndSet() {
        String _difficulty = SetUpQuestions._difficultyChoice;
        Player.setGameDifficulty(_difficulty.toLowerCase(Locale.ENGLISH));
    }

    //Converts the length string received from the GUI, and converts it to its
    //associated integer.
    public static void convertGameLengthStringToIntAndSet(String _length) {

        if (_length.equals(shortGameLength)) {
            Player.setGameLength(gameLengthShort);
        } else if (_length.equals(medGameLength)) {
            Player.setGameLength(gameLengthMedium);
        } else if (_length.equals(longGameLength)) {
            Player.setGameLength(gameLengthLong);
        }
    }

    //Calls all the necessary methods from the APICode package to make the API call, and format the
    //questions and answers accordingly.
    public static void APIRun() {
        API.makeApiCall();
        Questions.question();
        Answers.correctAnswers();
        Answers.incorrectAnswers();
        FixString.fixQuestions();
        FixString.fixCorrectAnswers();
        FixString.fixIncorrectAnswers();
        SplitAndJoin.separate();
    }



    public static void randomizeAnswerArray() {
        String[] _answerArray = Quiz.getAnswerArray();
        int gameLength = Player.getGameLength();
        int k = 0;
        int j = 4;
        for (int i = 0; i < gameLength; i++) {
            Collections.shuffle(Arrays.asList(_answerArray).subList(k, j));
            k += 4;
            j += 4;
        }
    }

    // ================================ GETTERS ====================================


    public static String[] getQuestionArray() {
        return questionArray = FixString._questionArray;
    }

    public static String[] getAnswerArray() {
        return answerArray = SplitAndJoin._answerArray;
    }


    // ================================ SETTERS ====================================


}
