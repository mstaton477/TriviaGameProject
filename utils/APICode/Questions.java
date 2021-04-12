package APICode;

/**
 * Separates questions from query. Updated 4-8-21
 *
 * @author scarl
 */
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

public class Questions extends API {

    public static final String _BASEURL = "https://opentdb.com/api.php?";

    public static void Questions() {
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
                
                JSONObject _obj = new JSONObject(content.toString());
                
                // prints out questions
                var question = _obj.getJSONArray("results").opt(0);
                String questions[] = new String[10];

                for (int i = 0; i < _questions; i++) {
                    question = _obj.getJSONArray("results").opt(i);
                    questions[i] = question.toString();
                    System.out.println(question);
                    System.out.println();
                }
            }
        } catch (Exception _ex) {
            System.out.println("Error: " + _ex);
        }
    }

    public static void main(String[] args) {
        _category = 9;
        _difficulty = "easy";
        _questions = 10;
        Questions();
    }
}
