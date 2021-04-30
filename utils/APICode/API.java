package APICode;

/*
 * This class performs the API call. Updated 4-27-21
 *
 * @author Sengthida Lorvan
 */
import static APICode.Answers.correctAnswers;
import static APICode.Answers.incorrectAnswers;
import static APICode.FixString.fixQuestions;
import static APICode.FixString.fixAnswers;
import static APICode.Questions.question;
import static APICode.SplitAndJoin.separate;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class API {

    // Storage variables

    public static String _difficulty;
    public static int _category;
    public static int _questions;
    public static JSONObject _obj;

    // Url Base
    public static final String _BASEURL = "https://opentdb.com/api.php?";

    // Url parts
    public static final String _CALLACTION1 = "amount=";
    public static final String _CALLACTION2 = "&category=";
    public static final String _CALLACTION3 = "&difficulty=";
    public static final String _CALLACTION4 = "&type=multiple";

    // Variables for helper methods
    public static String _key;
    public static String _message;
    public static int _num;
    public static final int _ONE = 1;
    public static final int _TWO = 2;



    // Helper method for finding given string indexes
    protected static String[] find(String[] _arrayInput, String[] _arrayOutput, String _key) {
        for (int i = 0; i < _questions; i++) {
            _arrayOutput[i] = String.valueOf(_arrayInput[i].indexOf(_key));
        }
        return _arrayOutput;
    }

    // Helper method for temporary storage
    protected static String[] store(String[] _arrayInput, String[] _arrayOutput, int _loop) {
        for (int i = 0; i < _loop; i++) {
            _arrayOutput[i] = _arrayInput[i];
        }
        return _arrayOutput;
    }

    // Helper method for assigning wanted info into array
    protected static void assign(String[] _arrayInput, String[] _arrayOutput, int _num) {
        switch (_num) {
            case 1:
                for (int i = 0; i < _questions; i++) {
                    _arrayOutput[i] = _arrayOutput[i].substring(0, Integer.parseInt(_arrayInput[i]));
                }
                break;
            case 2:
                for (int i = 0; i < _questions; i++) {
                    _arrayOutput[i] = _arrayInput[i];
                }
                break;
        }
    }

    // Helper method for assigning substring to array
    protected static void setToSub(String[] _arrayOutput, String[] _arrayInput1, String[] _arrayInput2) {
        for (int i = 0; i < _questions; i++) {
            _arrayOutput[i] = _arrayInput1[i].substring(Integer.parseInt(_arrayInput2[i]));
        }
    }

    protected static void reduce(String[] _array,int _loop,int _index) {
        for (int i = 0; i < _loop; i++) {
            _array[i] = _array[i].substring(_index);
        }
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

    public static void run(){
        Questions.question();
        Answers.correctAnswers();
        Answers.incorrectAnswers();
        FixString.fixQuestions();
        FixString.fixCorrectAnswers();
        SplitAndJoin.separate();
        FixString.fixAnswers();
    }

    public static void main(String[] args) {
        run();
    }
}
