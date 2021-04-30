
package Models;

/*
 * Author @Patrick
 * Last Updated: 04/30/21
 * Models the Leaderboard for use.
 */


import TriviaGameDatabase.DataObject;


import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Leaderboard{
    private String name;
    private Integer score;
    private String category;
    private String difficulty;
    private Integer length;
    private Timestamp timestamp;

    public Leaderboard(String name, Integer score, String category, String difficulty, Integer length, Timestamp timestamp) {
        this.name = name;
        this.score = score;
        this.category = category;
        this.difficulty = difficulty;
        this.length = length;
        this.timestamp = timestamp;
    }
    public Leaderboard(String name, Integer score, String category, String difficulty, Timestamp timestamp) {
    }


    /**
     * a method that calls on the dataObject class to select given parameters from the database,
     * it then initializes the data to an arraylist of maps
     * then another list is created to put an arraylist of leaderboard objects into the list.
     * @return
     * @throws IllegalAccessException
     * @throws NoSuchFieldException
     * @throws SQLException
     */
    public static ArrayList populateLeaderboard() throws IllegalAccessException, NoSuchFieldException, SQLException {
        Player t = new Player();
        ArrayList test = t.selectAll("playerName, playerScore, category, gameDifficulty, gameLength, lastUpdated");
        ArrayList data = new ArrayList();
        for (int i = 0; i < test.size(); i++) {
            HashMap h;
            h = (HashMap) test.get(i);
            data.add(new Leaderboard((String)h.get("playerName"), (Integer) h.get("playerScore"), (String) h.get("category"), (String) h.get("gameDifficulty"),
                    (Integer) h.get("gameLength"), (Timestamp) h.get("lastUpdated")));
        }
        return data;
    }


    @Override
    public String toString() {
        return "Leaderboard{" +
                "name='" + name + '\'' +
                ", score=" + score +
                ", category='" + category + '\'' +
                ", difficulty='" + difficulty + '\'' +
                ", length=" + length +
                ", timestamp=" + timestamp +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;

    }
}
