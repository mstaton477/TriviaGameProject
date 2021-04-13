package APICode;

/**
 * Separates questions from query. Updated
 * Updated 4-13-21
 *
 * @author Sengthida Lorvan
 */

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Questions extends API {

    public static final String _BASEURL = "https://opentdb.com/api.php?";
    public static String[] questions = new String[_questions];
    public static String[] Question = new String[_questions];
    public static String[] index = new String[_questions];
    public static String[] temp = new String[_questions];


    public static String[] questions() {
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
                StringBuilder content = new StringBuilder();
                while ((_inputLine = _input.readLine()) != null) {
                    content.append(_inputLine);
                }
                _input.close();
                connect.disconnect();

                JSONObject _obj = new JSONObject(content.toString());

                // prints out questions
                var question = _obj.getJSONArray("results").opt(0);


                // Get questions
                for (int i = 0; i < _questions; i++) {
                    question = _obj.getJSONArray("results").opt(i);
                    questions[i] = question.toString();
                }
                // Remove text in front of questions
                for (int i = 0; i < _questions; i++) {
                    Question[i] = questions[i].substring(33);
                }
                // Gets index of next quotation mark
                for (int i = 0; i < _questions; i++) {
                    index[i] = String.valueOf(Question[i].indexOf("\""));
                }
                //Copy to temp
                for (int i = 0; i < _questions; i++){
                    temp[i] = Question[i];
                }
                System.out.println();
                // Assigns questions by itself to array
                for (int i = 0; i < _questions; i++) {
                    Question[i] = Question[i].substring(0, Integer.parseInt(index[i]));
                    System.out.println("Question:" + Question[i]);
                    System.out.println();
                }
            }
        } catch (Exception _ex) {
            System.out.println("Error: " + _ex);
        }
        return Question;
    }
}
