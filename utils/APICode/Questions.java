package APICode;

/**
 * This class separates the questions from the query Updated 4-21-21
 *
 * @author Sengthida Lorvan
 */
public class Questions extends API {

    // Arrays to store parsed parts
    public static String[] _questionArray = new String[_questions];
    public static String[] _index = new String[_questions];
    public static String[] _temp = new String[_questions];

    // Final int for shifting through substring query
    public static final int _FOURLETTERS = 33;
    public static final int _MEDIUM = 35;

    protected static String[] question() {
        // Call method to get questions from API
        makeApiCall();

        try {
            Object _getQuestionJSONArray;

            // Get questions
            for (int i = 0; i < _questions; i++) {
                _getQuestionJSONArray = _obj.getJSONArray("results").opt(i);
                _questionArray[i] = _getQuestionJSONArray.toString();
            }

            // Removes text in front of question
            for (int i = 0; i < _questions; i++) {
                if (_difficulty.equals("easy") || _difficulty.equals("hard")) {
                    _questionArray[i] = _questionArray[i].substring(_FOURLETTERS);
                } else if (_difficulty.equals("medium")) {
                    _questionArray[i] = _questionArray[i].substring(_MEDIUM);
                }
            }

            _key = "\"";
            // Gets index of next quotation mark
            find(_questionArray, _index, _key);

            // Copy array to temp array
            store(_questionArray, _temp);

            _message = "Question ";
            // Assign separated questions into array
            assign(_index, _questionArray, _message);
        } catch (Exception _ex) {
            System.out.println("Error: " + _ex);
        }
        return _questionArray;
    }
}
