package Models;
/*
 * Author @McKenzie
 * Last Updated: 4/21/21
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
                categoryName =String.valueOf(NamesOfCategory.VIDEO_GAMES);
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

    public int getCategory() {
        return API._category;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public int getGameLength() {
        return API._questions;
    }

    public String getGameDifficulty() {
        return API._difficulty;
    }

    public String getName() {
        return playerName;
    }

    // ================================ SETTERS ====================================

    public void setCategory(int _category) {
        this.category = _category;
    }

    public void setPlayerScore(int _playerScore) {
        this.playerScore = _playerScore;
    }

    public void setGameLength(int _gameLength) {
        this.gameLength = _gameLength;
    }

    public void setGameDifficulty(String _gameDifficulty) {
        this.gameDifficulty = _gameDifficulty;
    }

    public void setName(String _name) {
        this.playerName = _name;
    }
}
