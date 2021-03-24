package DataBasePrototype;

public class PlayerData extends DataBasePrototype.DataObject {
    protected final String dataTable = "new_player_data";
    public PlayerData(){}

    protected String playerName;
    protected String playerScore;

    public String getPlayerScore() {
        return playerScore;
    }

    public void setPlayerScore(String _playerScore) {
        this.playerScore = _playerScore;
    }

    public void setPlayerName(String _playerName) {
        this.playerName = _playerName;
    }

    public String getPlayerName() {
        return playerName;
    }
}
