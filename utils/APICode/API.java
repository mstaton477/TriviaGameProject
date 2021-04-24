package APICode;

/**
 * This class performs the API call.
 * Updated 4-24-21
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
    public static String _catName = "General Knowledge";
    public static String _difficulty = "hard";
    public static Category cat;
    public static int _category;
    public static int _questions = 10;
    public static JSONObject _obj;

    // Url Base
    public static final String _BASEURL = "https://opentdb.com/api.php?";

    // Url parts
    public static final String _CALLACTION1 = "amount=";
    public static final String _CALLACTION2 = "&category";
    public static final String _CALLACTION3 = "&difficulty=";
    public static final String _CALLACTION4 = "&type=multiple";

    // Variables for helper methods
    public static String _key;
    public static String _message;

    // Enumeration of categories
    enum Category {
        NINE, TWELVE, FIFTEEN, SEVENTEEN, EIGHTEEN, NINETEEN, THIRTYONE
    }

    // Helper method for finding given string indexes
    public static String[] find(String[] _arrayInput, String[] _arrayOutput, String _key) {
        for (int i = 0; i < _questions; i++) {
            _arrayOutput[i] = String.valueOf(_arrayInput[i].indexOf(_key));
        }
        return _arrayOutput;
    }

    // Helper method for temporary storage
    public static String[] store(String[] _arrayInput, String[] _arrayOutput) {
        for (int i = 0; i < _questions; i++) {
            _arrayOutput[i] = _arrayInput[i];
        }
        return _arrayOutput;
    }

    // Helper method for assigning wanted info into array
    public static void assign(String[] _arrayInput, String[] _arrayOutput, String _message) {
        for (int i = 0; i < _questions; i++) {
            _arrayOutput[i] = _arrayOutput[i].substring(0, Integer.parseInt(_arrayInput[i]));
            System.out.println(_message + (i + 1) + ": " + _arrayOutput[i]);
            System.out.println();
        }
    }

    // Helper method for assigning substring to array
    public static void setToSub(String[] _arrayOutput, String[] _arrayInput1, String[] _arrayInput2) {
        for (int i = 0; i < _questions; i++) {
            _arrayOutput[i] = _arrayInput1[i].substring(Integer.parseInt(_arrayInput2[i]));
        }
    }

    public static void reduce(String[] _arrayOutput, int _index) {
        for (int i = 0; i < _questions; i++) {
            _arrayOutput[i] = _arrayOutput[i].substring(_index);
        }
    }

    // Switches the category name with enumerated case
    private static Category categoryName() {
        switch (_catName) {
            case "General Knowledge":
                cat = Category.NINE;
                break;
            case "Entertainment: Video Games":
                cat = Category.FIFTEEN;
                break;
            case "Science & Nature":
                cat = Category.SEVENTEEN;
                break;
            case "Science: Computers":
                cat = Category.EIGHTEEN;
                break;
            case "Science: Mathematics":
                cat = Category.NINETEEN;
                break;
            case "Entertainment: Japanese Anime & Manga":
                cat = Category.THIRTYONE;
                break;
        }
        return cat;
    }

    // Switches enumerated case with the integer version
    private static int category() {
        switch (cat) {
            case NINE:
                _category = 9;
                break;
            case TWELVE:
                _category = 12;
                break;
            case FIFTEEN:
                _category = 15;
                break;
            case SEVENTEEN:
                _category = 17;
                break;
            case EIGHTEEN:
                _category = 18;
                break;
            case NINETEEN:
                _category = 19;
                break;
            case THIRTYONE:
                _category = 31;
                break;
        }
        return _category;
    }

    public static void makeApiCall() {
        String _urlString = _BASEURL + _CALLACTION1 + _questions + _CALLACTION2 + _category + _CALLACTION3 + _difficulty + _CALLACTION4;
        URL _url;
        try {
            _url = new URL(_urlString);
            HttpURLConnection _connect = (HttpURLConnection) _url.openConnection();
            _connect.setRequestMethod("GET");
            int _status = _connect.getResponseCode();
            if (_status != 200) {
                System.out.println("Error: Could not get questions: " + _status);
            } else {
                BufferedReader _input = new BufferedReader(new InputStreamReader(_connect.getInputStream()));
                String _inputLine;
                StringBuffer _content = new StringBuffer();
                while ((_inputLine = _input.readLine()) != null) {
                    _content.append(_inputLine);
                }
                _input.close();
                _connect.disconnect();

                // Initialize JSON object
                _obj = new JSONObject(_content.toString());
            }
        } catch (Exception _ex) {
            System.out.println("Error: " + _ex);
        }
    }
}