package Models;
/*
 * Author @McKenzie
 * Last Updated: 4/21/21
 * This class holds all the information related to the quiz player.
 */

import APICode.*;

public class Player {

    public static int playerScore;
    protected String categoryName;
    public static int category;
    public static int gameLength;
    public static String gameDifficulty;
    public static String playerName;


    public Player(String playerName, String gameDifficulty, int gameLength, String categoryName, int playerScore) {
        this.playerName = playerName;
        this.gameDifficulty = gameDifficulty;
        this.gameLength = gameLength;
        this.categoryName = categoryName;
        this.playerScore = playerScore;
    }

    //When saving the data to the Database category will be saved as a String not an int.
    public String getCategoryName(int _category) {
        switch (_category) {
            case 9:
                categoryName = "General Knowledge";
                break;
            case 12:
                categoryName = "Entertainment: Music";
                break;
            case 15:
                categoryName = "Entertainment: Video Games";
                break;
            case 17:
                categoryName = "Science & Nature";
                break;
            case 18:
                categoryName = "Science: Computers";
                break;
            case 19:
                categoryName = "Science: Mathematics";
                break;
            case 31:
                categoryName = "Entertainment: Japanese Anime & Manga";
                break;
        }
        return categoryName;
    }

    // ================================ GETTERS ====================================

    public String getCategory() {
        return API._categoryName;
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
