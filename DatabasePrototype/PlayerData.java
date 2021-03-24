package DataBasePrototype;

public class PlayerData extends DataBasePrototype.DataObject {
    protected final String dataTable = "new_player_data";
    public PlayerData(){}

    protected String playerName;
    protected String playerScore;
    protected String category;




    // ================================ GETTERS ====================================
    public String getCategory() {
        return category;
    }
    public String getPlayerName() {
        return playerName;
    }
    public String getPlayerScore() {

        return playerScore;
    }
    // ================================ SETTERS ====================================

    public void setCategory(String _category) {
        this.category = _category;
    }
    public void setPlayerScore(String _playerScore) {
        this.playerScore = _playerScore;
    }
    public void setPlayerName(String _playerName) {
        this.playerName = _playerName;
    }


}
