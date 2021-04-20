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


    // URL Base
    public static final String _BASEURL = "https://opentdb.com/api.php?";

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
