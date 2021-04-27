package APICode;

/**
 * This class creates the answer array
 * Updated 4-27-21
 *
 * @author Sengthida Lorvan
 */

public class SplitAndJoin extends FixString {
    protected static String[] _answerArray = new String[_questions * 4];
    protected static String _tempString;
    protected static String _storeIndex;

    protected static void separate() {
        store(_incorrectAnswer, _temp);
        // Find index of next comma
        _key = ",";
        find(_temp, _index, _key);

        int i = 0;
        // Split incorrect answers and add correct answers
        do {
            _answerArray[i] = _temp[i].substring(0, Integer.parseInt(_index[i]));
            _tempString = _temp[i].substring(Integer.parseInt(_index[i]) + 1);
            _storeIndex = String.valueOf(_tempString.indexOf(_key));
            _answerArray[i + 1] = _tempString.substring(0, Integer.parseInt(_storeIndex));
            _answerArray[i + 2] = _tempString.substring(Integer.parseInt(_storeIndex) + 1);
            _answerArray[i + 3] = _correctAnswer[i];

            // Print out to console
            System.out.println(_answerArray[i]);
            System.out.println(_answerArray[i+1]);
            System.out.println(_answerArray[i+2]);
            System.out.println(_answerArray[i+3]);
            System.out.println();
            i++;
        } while (i < _questions);
    }
}
