package TriviaGameDatabase;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main(String args[]) throws IllegalAccessException, NoSuchFieldException, InvocationTargetException, SQLException {
        Player p = new Player();
        p.setCategory("1st Grade Math");
        p.setPlayerScore(12);
        p.setName("Chad");
        p.setGameDifficulty("Easy");
        p.setGameLength(100);
        //p.save();
        //p.delete("1");
        //System.out.println(p.loadById(3));
        System.out.println(p.loadById(4));
        //p.displayTop10Scores();



    }

}
