package APICode;

/**
 * This class performs the API call
 * Updated 4-20-21
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
    public static String _difficulty = "medium";
    public static int _category = 9;
    public static int _questions = 10;
    public static JSONObject _obj;

    // Url Base
    public static final String _BASEURL = "https://opentdb.com/api.php?";

    // Url parts
    public static final String _CALLACTION1 = "amount=";
    public static final String _CALLACTION2 = "&category";
    public static final String _CALLACTION3 = "&difficulty=";
    public static final String _CALLACTION4 = "&type=multiple";

    public static int category() {
        switch (_categoryName) {
            case "General Knowledge":
                _category = 9;
                break;
            case "Entertainment: Music":
                _category = 12;
                break;
            case "Entertainment: Video Games":
                _category = 15;
                break;
            case "Science & Nature":
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