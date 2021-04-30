
package Models;

/*
 * Author @Patrick
 * Last Updated: 04/30/21
 * Models the Leaderboard for use.
 */


import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
    }
}


