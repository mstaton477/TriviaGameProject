package APICode;

/**
 * Separates correct answers and incorrect answers from query.
 * Updated 4-27-21
 *
 * @author Sengthida Lorvan
 */
public class Answers extends Questions {
    // Arrays to hold the respective answers
    public static String[] _correctAnswer = new String[_questions];
    protected static String[] _incorrectAnswer = new String[_questions];

    // Substring number for the respective answers
    private static final int _CANSSUB = 20;
    private static final int _IANSSUB = 23;

    public static String[] correctAnswers() {
        // Gets text after questions
        setToSub(_correctAnswer, _temp, _index);

        // Gets rid of text before
        reduce(_correctAnswer,_questions, _CANSSUB);

        // Gets index of next quotation mark
        find(_correctAnswer, _index, _key);

        //Copy to temp
        store(_correctAnswer, _temp, _questions);

        _num = _ONE;
        // Assigns correct answer by itself into array
        assign(_index, _correctAnswer, _num);
        for (int i = 0; i < _questions; i++){
            if (_correctAnswer[i].contains(" Tracker")){
                _correctAnswer[i] = _correctAnswer[i].replace(" Tracker", "Tracker");
            }
            if(_correctAnswer[i].contains("\\tH")){
                _correctAnswer[i] = _correctAnswer[i].replace("\\tH", "H");
            }
        }
        // Sets leftover substring into this array
        for (int i = 0; i < _questions; i++) {
            _incorrectAnswer[i] = _temp[i].substring(Integer.parseInt(_index[i]));
        }
        return _correctAnswer;
    }

    public static String[] incorrectAnswers() {

        // Set array equal to temp
        setToSub(_incorrectAnswer, _temp, _index);

        // Get rid of text in front
        reduce(_incorrectAnswer,_questions, _IANSSUB);

        // Find index of next bracket
        _key = "]";
        find(_incorrectAnswer, _index, _key);

        // Array with incorrect answers that still need to separate
        for (int i = 0; i < _questions; i++) {
            _incorrectAnswer[i] = _incorrectAnswer[i].substring(0, Integer.parseInt(_index[i]));
        }

        // Get rid of commas.
        for (int i = 0; i < _questions; i++) {
            _incorrectAnswer[i] = _incorrectAnswer[i].replace(",", "");
            if (_incorrectAnswer[i].contains("\" ")) {
                _incorrectAnswer[i] = _incorrectAnswer[i].replace("\" ", "\"");
            }
            if(_incorrectAnswer[i].contains("\\tN")){
                _incorrectAnswer[i] = _incorrectAnswer[i].replace("\\tN", "N");
            }
        }
        return _incorrectAnswer;
    }
}
