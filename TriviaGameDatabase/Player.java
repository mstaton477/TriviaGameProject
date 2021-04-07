package TriviaGameDatabase;


import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;

public class Player extends DataObject{

    protected final String dataTable = "player_data";
    protected int playerScore= 0;
    protected String category= "";
    protected int gameLength = 0;
    protected String gameDifficulty = "";

    public void displayTop10Scores() throws NoSuchFieldException, IllegalAccessException, SQLException {
        //returns hashmap of top 10 scores
        HashMap<String,Object> top10Scores = new HashMap<>();
        top10Scores=this.sortTable("playerScore");
        System.out.println(Arrays.asList(top10Scores));
    }



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


    @Override
    public String toString() {
        return "Player{" +
                " id=" + id +
                ", uuid='" + uuid + '\'' +
                ", name='" + name + '\'' +
                ", active='" + active + '\'' +
                ", Category='" + category + '\'' +
                ", PlayerScore='" + playerScore + '\'' +
                ", GameLength='" + gameLength + '\'' +
                ", gameDifficulty='" + gameDifficulty + '\'' +
                '}';
    }
}
