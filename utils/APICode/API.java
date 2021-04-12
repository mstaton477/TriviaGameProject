package APICode;

/**
 * This application performs the API call to create a trivia game.
 * Updated 4-8-21
 * @author Sengthida Lorvan
 */

import java.util.Scanner; //Temporary
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.*;

public class API {
// Storage variables
    protected static String _categoryName;
    protected static String _difficulty;
    protected static String _gameLength;
    protected static int _category;
    protected static int _catName;
    protected static int _questions;
    protected static int _diff;
 // URL Base
    public static final String _BASEURL = "https://opentdb.com/api.php?";

//Assigns category depending on user's choice
    public static String categoryName(String _categoryName, int _catName) {
        if (_catName == 1) {
            _categoryName = "General Knowledge";
        }
        if (_catName == 2) {
            _categoryName = "Entertainment: Music";
        }
        if (_catName == 3) {
            _categoryName = "Entertainment: Video Games";
        }
        if (_catName == 4) {
            _categoryName = "Science & Nature";
        }
        if (_catName == 5) {
            _categoryName = "Science: Computers";
        }
        if (_catName == 6) {
            _categoryName = "Science: Mathematics";
        }
        if (_catName == 7) {
            _categoryName = "Entertainment: Japanese Anime & Manga";
        }
        return _categoryName;
    }

    public static int category(String _categoryName, int _category) {
        if (_categoryName == "General Knowledge") {
            _category = 9;
        }
        if (_categoryName == "Entertainment: Music") {
            _category = 12;
        }
        if (_categoryName == "Entertainment: Video Games") {
            _category = 15;
        }
        if (_categoryName == "Science & Nature") {
            _category = 17;
        }
        if (_categoryName == "Science: Computers") {
            _category = 18;
        }
        if (_categoryName == "Science: Mathematics") {
            _category = 19;
        }
        if (_categoryName == "Entertainment: Japanese Anime & Manga") {
            _category = 31;
        }
        return _category;
    }

    // Assigns difficulty
    public static String difficulty(String _difficulty, int _diff) {
        if (_diff == 1) {
            _difficulty = "easy";
        }
        if (_diff == 2) {
            _difficulty = "medium";
        }
        if (_diff == 3) {
            _difficulty = "hard";
        }
        return _difficulty;
    }

    //Assigns how long the game will last
    public static int length(String _gameLength) {
        if (_gameLength.equals("Short")) {
            _questions = 10;
        }
        if (_gameLength.equals("Medium")) {
            _questions = 20;
        }
        if (_gameLength.equals("Long")) {
            _questions = 30;
        }
        return _questions;
    }

    //Creates API URL
    public static void createGame() {
        
        String _callAction1 = "amount=";
        String _callAction2 = "&category=";
        String _callAction3 = "&difficulty=";
        String _urlString = _BASEURL + _callAction1 + _questions + _callAction2 + _category + _callAction3 + _difficulty;
        URL _url;
        try {
            _url = new URL(_urlString);
            HttpURLConnection connect = (HttpURLConnection) _url.openConnection();
            connect.setRequestMethod("GET");
            int _status = connect.getResponseCode();
            if (_status != 200) {
                System.out.println("Error: Could not get questions: " + _status);
            } else {
                BufferedReader _input = new BufferedReader(new InputStreamReader(connect.getInputStream()));
                String _inputLine;
                StringBuffer content = new StringBuffer();
                while ((_inputLine = _input.readLine()) != null) {
                    content.append(_inputLine);
                }
                _input.close();
                connect.disconnect();
                //Prints out JSON query
                System.out.println("Output: " + content.toString());
                JSONObject _obj = new JSONObject(content.toString());
            }
        } catch (Exception _ex) {
            System.out.println("Error: " + _ex);
        }
    }
}
