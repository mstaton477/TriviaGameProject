package DataBasePrototype;

public class main {
    public static void main(String[] args) {
        PlayerData test = new PlayerData();
        test.setPlayerName("Patrick");
        test.setPlayerScore("200");
        test.setCategory("Entertainment: Japanese Anime & Manga");
        test.save();
    }
}

