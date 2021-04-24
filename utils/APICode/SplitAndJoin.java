package APICode;

/**
 * This class creates the Answer Array
 * Updated 4-24-21
 *
 * @author Sengthida Lorvan
 */

public class SplitAndJoin extends Answers {
    public static String[] _AnswerArray = new String[_questions * 4];
    public static String _tempArray;
    public static String _storeIndex;

    protected static void separate() {
        store(_incorrectAnswer, _temp);
        // Find index of next comma
        _key = ",";
        find(_temp, _index, _key);

        int i = 0;
        // Split incorrect answers and add correct answers
        do {
            _AnswerArray[i] = _temp[i].substring(0, Integer.parseInt(_index[i]));
            _tempArray = _temp[i].substring(Integer.parseInt(_index[i]) + 1);
            _storeIndex = String.valueOf(_tempArray.indexOf(_key));
            _AnswerArray[i + 1] = _tempArray.substring(0, Integer.parseInt(_storeIndex));
            _AnswerArray[i + 2] = _tempArray.substring(Integer.parseInt(_storeIndex) + 1);
            _AnswerArray[i + 3] = _correctAnswer[i];

            // Print out to console
            System.out.println(_AnswerArray[i]);
            System.out.println(_AnswerArray[i+1]);
            System.out.println(_AnswerArray[i+2]);
            System.out.println(_AnswerArray[i+3]);
            System.out.println();
            i++;
        } while (i < _questions);
    }

    public static void main(String[] args) {
        question();
        correctAnswers();
        incorrectAnswers();
        separate();
    }
}
