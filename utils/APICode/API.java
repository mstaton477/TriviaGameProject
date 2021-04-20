package APICode;

/**
 * This performs the API Call.
 * Updated 4-19-21
 *
 * @author Sengthida Lorvan
 */

import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class API {
    // Storage variables
    public static String _categoryName;
    public static String _difficulty = "easy";
    public static int _category = 9;
    public static int _questions = 10;
    public static JSONObject _obj;
<<<<<<< HEAD
    public static int _diff;
=======
>>>>>>> parent of aa1518b (Reduced code and parsed answers)

    // URL Base
    public static final String _BASEURL = "https://opentdb.com/api.php?";

    public static int category() {
        switch (_categoryName){
            case "General Knowledge":
                _category = 9;
                break;
            case "Entertainment: Music":
                _category = 12;
                break;
            case "Entertainment: Video Games":
                _category = 15;
                break;
            case  "Science & Nature":
                _category = 17;
                break;
            case "Science: Computers":
                _category = 18;
                break;
            case "Science: Mathematics":
                _category = 19;
                break;
            case "Entertainment: Japanese Anime & Manga":
                _category = 31;
<<<<<<< HEAD
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
            public static void makeAPICall() {
                public static void createGame() {

                    String _callAction1 = "amount=";
                    String _callAction2 = "&category=";
                    String _callAction3 = "&difficulty=";
                    String _urlString = _BASEURL + _callAction1 + _questions + _callAction2 + _category + _callAction3 + _difficulty + "&type=multiple";
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

                            //Initialize JSON object
                            _obj = new JSONObject(content.toString());
                            //Prints out JSON query
                            System.out.println("Output: " + content.toString());
                            JSONObject _obj = new JSONObject(content.toString());
                        }
                    } catch (Exception _ex) {
                        System.out.println("Error: " + _ex);
                    }
                }
            }

=======
        }
        return _category;
    }

    //Creates API URL
    public static void makeAPICall() {
        String _callAction1 = "amount=";
        String _callAction2 = "&category=";
        String _callAction3 = "&difficulty=";
        String _urlString = _BASEURL + _callAction1 + _questions + _callAction2 + _category + _callAction3 + _difficulty + "&type=multiple";
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

                //Initialize JSON object
                _obj = new JSONObject(content.toString());
            }
        } catch (Exception _ex) {
            System.out.println("Error: " + _ex);
        }
    }
}
>>>>>>> parent of aa1518b (Reduced code and parsed answers)
