package APICode;

/**
 * Separates correct answers and incorrect answers from query.
 * Updated 4-24-21
 *
 * @author Sengthida Lorvan
 */
public class Answers extends Questions {

    public static String[] _correctAnswer = new String[_questions];
    public static String[] _incorrectAnswer = new String[_questions];

    public static final int _CANSSUB = 20;
    public static final int _IANSSUB = 23;

    protected static String[] correctAnswers() {
        // Gets text after questions
        setToSub(_correctAnswer, _temp, _index);

        // Gets rid of text before
        reduce(_correctAnswer, _CANSSUB);

        // Gets index of next quotation mark
        find(_correctAnswer, _index, _key);

        //Copy to temp
        store(_correctAnswer, _temp);

        _message = "Correct Answer for Question ";
        _num = _ONE;
        // Assigns correct answer by itself into array
        assign(_index, _correctAnswer, _message,_num);


        // Sets leftover substring into this array
        for (int i = 0; i < _questions; i++) {
            _incorrectAnswer[i] = _temp[i].substring(Integer.parseInt(_index[i]));
        }

        return _correctAnswer;
    }

    protected static String[] incorrectAnswers() {

        // Set array equal to temp
        setToSub(_incorrectAnswer, _temp, _index);

        // Get rid of text in front
        reduce(_incorrectAnswer, _IANSSUB);

        // Find index of next bracket
        _key = "]";
        find(_incorrectAnswer, _index, _key);

        // Array with incorrect answers that still need to separate
        for (int i = 0; i < _questions; i++) {
            _incorrectAnswer[i] = _incorrectAnswer[i].substring(0, Integer.parseInt(_index[i]));
        }

        // Get rid of quotations surrounding the answers.
        for (int i = 0; i < _questions; i++) {
            _incorrectAnswer[i] = _incorrectAnswer[i].replace("\"", "");
        }

        return _incorrectAnswer;
    }
}
