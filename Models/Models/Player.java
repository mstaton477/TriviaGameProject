package Models;
/*
 * Author @McKenzie
 * Last Updated: 4/14/21
 * This class holds all the information related to the quiz player.
 */

import APICode.*;

public class Player {

    public int playerScore;
    protected String category;
    protected int gameLength;
    protected String gameDifficulty;
    protected String playerName;


    public Player(String playerName, String gameDifficulty, int gameLength, String category, int playerScore){
        this.playerName = playerName;
        this.gameDifficulty = gameDifficulty;
        this.gameLength = gameLength;
        this.category = category;
        this.playerScore = playerScore;
    }

    // ================================ GETTERS ====================================

    public String getCategory() { return API._categoryName; }

    public int getPlayerScore() { return playerScore;}

    public int getGameLength() { return API._questions; }

    public String getGameDifficulty() { return API._difficulty; }

    public String getName(){ return playerName;}

    // ================================ SETTERS ====================================

    public void setCategory(String _category) { this.category = _category; }

    public void setPlayerScore(int _playerScore) {this.playerScore = _playerScore; }

    public void setGameLength(int _gameLength) { this.gameLength = _gameLength; }

    public void setGameDifficulty(String _gameDifficulty) { this.gameDifficulty = _gameDifficulty; }

    public void setName(String _name) { this.playerName = _name; }
}
