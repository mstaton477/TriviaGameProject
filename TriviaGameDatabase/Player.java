package TriviaGameDatabase;



public class Player extends DataObject{

    protected final String dataTable = "player_data";
    protected int playerScore= 0;
    protected String category= "";
    protected int gameLength = 0;
    protected String gameDifficulty = "";



    // ================================ GETTERS ====================================

    public String getCategory() {
        return category;
    }

    public int getPlayerScore() { return playerScore;}

    public int getGameLength() { return gameLength; }

    public String getGameDifficulty() { return gameDifficulty; }

    // ================================ SETTERS ====================================

    public void setCategory(String _category) { this.category = _category; }

    public void setPlayerScore(int _playerScore) {this.playerScore = _playerScore; }

    public void setGameLength(int _gameLength) { this.gameLength = _gameLength; }

    public void setGameDifficulty(String _gameDifficulty) { this.gameDifficulty = _gameDifficulty; }
}
