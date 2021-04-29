package Models;
/*
 * Author @McKenzie
 * Last Updated: 4/28/21
 * This class holds all the information related to the quiz player.
 */

import APICode.*;

public class Player {

    public static int playerScore;
    protected static String categoryName;
    public static int category;
    public static int gameLength;
    public static String gameDifficulty;
    public static String playerName;


    enum NamesOfCategory {
        GENERAL_KNOWLEDGE, MUSIC, VIDEO_GAMES, SCIENCE, COMPUTERS, FILM, ANIME_AND_MANGA
    }

    public Player() {

    }

    public Player(String playerName, String gameDifficulty, int gameLength, String categoryName, int playerScore) {
        this.playerName = playerName;
        this.gameDifficulty = gameDifficulty;
        this.gameLength = gameLength;
        this.categoryName = categoryName;
        this.playerScore = playerScore;
    }

    //When saving the data to the Database category will be saved as a String not an int.
    public static String getCategoryName(int _category) {
        switch (_category) {
            case 9:
                categoryName = String.valueOf(NamesOfCategory.GENERAL_KNOWLEDGE);
                break;
            case 12:
                categoryName = String.valueOf(NamesOfCategory.MUSIC);
                break;
            case 15:
                categoryName = String.valueOf(NamesOfCategory.VIDEO_GAMES);
                break;
            case 17:
                categoryName = String.valueOf(NamesOfCategory.SCIENCE);
                break;
            case 18:
                categoryName = String.valueOf(NamesOfCategory.COMPUTERS);
                break;
            case 11:
                categoryName = String.valueOf(NamesOfCategory.FILM);
                break;
            case 31:
                categoryName = String.valueOf(NamesOfCategory.ANIME_AND_MANGA);
                break;
        }
        return categoryName;
    }

    // ================================ GETTERS ====================================

    public static int getCategory() {
        return API._category;
    }


    public static int getPlayerScore() {
        return playerScore;
    }

    public static int getGameLength() {
        return API._questions;
    }

    public static String getGameDifficulty() {
        return API._difficulty;
    }

    public static String getPlayerName() {
        return playerName;
    }

    // ================================ SETTERS ====================================

    public static void setCategory(int _category) {
        API._category = _category;
    }

    public static void setPlayerScore(int _playerScore) {
        playerScore = _playerScore;
    }

    public static void setGameLength(int _gameLength) {
        API._questions = _gameLength;
    }

    public static void setGameDifficulty(String _gameDifficulty) {
        API._difficulty = _gameDifficulty;
    }

    public static void setPlayerName(String _name) {
        playerName = _name;
    }

}
