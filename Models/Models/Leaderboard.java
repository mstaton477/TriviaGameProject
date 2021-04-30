
package Models;
<<<<<<< Updated upstream

/*
 * Author @Patrick
 * Last Updated: 04/30/21
 * Models the Leaderboard for use.
 */

=======
import TriviaGameDatabase.DataObject;
>>>>>>> Stashed changes

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

<<<<<<< Updated upstream
public class Leaderboard {
    public static List<String> _nameColumn = new ArrayList<>();
    public static List<Integer> _scoreColumn = new ArrayList<>();
    public static List<String> _categoryColumn = new ArrayList<>();
    public static List<String> _difficultyColumn = new ArrayList<>();
    public static List<Integer> _lengthColumn = new ArrayList<>();
    public static List<Timestamp> _datePlayedColumn = new ArrayList<>();

    public Leaderboard() throws IllegalAccessException, NoSuchFieldException, SQLException {
        Player t = new Player();
        ArrayList test = t.sortTable("playerScore");
        for (int i = 0; i < test.size(); i++) {
            HashMap h;
            h = (HashMap) test.get(i);
            _nameColumn.add((String) h.get("name"));
            _scoreColumn.add((Integer) h.get("playerScore"));
            _categoryColumn.add((String) h.get("category"));
            _difficultyColumn.add((String) h.get("gameDifficulty"));
            _lengthColumn.add((Integer) h.get("gameLength"));
            _datePlayedColumn.add((Timestamp) h.get("lastUpdated"));

        }
    }

    public String toString() {
        return "Leaderboard{" +
                " nameColumn=" + _nameColumn +
                ", scoreColumn='" + _scoreColumn + '\'' +
                ", categoryColumn='" + _categoryColumn + '\'' +
                ", difficultyColumn='" + _difficultyColumn + '\'' +
                ", lengthColumn='" + _lengthColumn + '\'' +
                ", datePlayedColumn=" + _datePlayedColumn +
                '}';
    }


    // ================================ GETTERS ====================================

    public List<String> get_nameColumn() {
        return this._nameColumn;
    }

    public List<Integer> get_scoreColumn() {
        return this._scoreColumn;
    }

    public List<String> get_categoryColumn() {
        return this._categoryColumn;
    }

    public List<String> get_difficultyColumn() {
        return this._difficultyColumn;
    }

    public List<Integer> get_lengthColumn() {
        return this._lengthColumn;
    }

    public List<Timestamp> get_datePlayedColumn() {
        return this._datePlayedColumn;
    }


    // ================================ SETTERS ====================================


    public void set_nameColumn(List<String> _nameColumn) {
        this._nameColumn = _nameColumn;
    }

    public void set_scoreColumn(List<Integer> _scoreColumn) {
        this._scoreColumn = _scoreColumn;
    }

    public void set_categoryColumn(List<String> _categoryColumn) {
        this._categoryColumn = _categoryColumn;
    }

    public void set_difficultyColumn(List<String> _difficultyColumn) {
        this._difficultyColumn = _difficultyColumn;
    }

    public void set_lengthColumn(List<Integer> _lengthColumn) {
        this._lengthColumn = _lengthColumn;
    }

    public void set_datePlayedColumn(List<Timestamp> _datePlayedColumn) {
        this._datePlayedColumn = _datePlayedColumn;
=======
import java.sql.Timestamp;

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
        return "LeaderboardEntry{" +
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
>>>>>>> Stashed changes
    }
}


