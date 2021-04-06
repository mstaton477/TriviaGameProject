package TriviaGameDatabase;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class Main {
    public static void main(String args[]) throws IllegalAccessException, NoSuchFieldException, InvocationTargetException {
        Player p = new Player();
        p.setCategory("1st Grade Math");
        p.setPlayerScore(12);
        p.setName("Chad");
        p.setGameDifficulty("Easy");
        p.setGameLength(100);
        p.save();
        p.delete("6f4d3598-0fa2-4b8c-8f37-49bfdd26530b");
        //p.sortTable("playerScore");
        p.loadById(2);

    }

}
