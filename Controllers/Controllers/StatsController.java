package Controllers;

import Models.Player;
import TriviaGameDatabase.*;

public class StatsController {

    public static void savePlayerData(String _playerName, String _gameDifficulty, int _gameLength, String _categoryName,
                                      int _playerScore)
    {
        Player player = new Player(_playerName,_gameDifficulty,_gameLength, _categoryName, _playerScore);

        player.save();
    }
}
