package APICode;

/**
 * This class creates the answer array Updated 4-27-21
 *
 * @author Sengthida Lorvan
 */
public class SplitAndJoin extends FixString {

    public static String[] _answerArray = new String[_questions * 4];
    protected static String[] _tempArray = new String[_questions];
    protected static String[] _storeIndex = new String[_questions];

    protected static void separate() {
        store(_incorrectAnswer, _temp);
        for (int i = 0; i < _questions; i++) {
            _temp[i] = _temp[i].substring(1);
        }
        // Find index of next quotation mark
        _key = "\"";
        find(_temp, _index, _key);

        for (int i = 0; i < _questions; i++) {
            _tempArray[i] = _temp[i].substring(Integer.parseInt(_index[i]));
            _tempArray[i] = _tempArray[i].substring(2);
        }
        for (int i = 0; i < _questions; i++) {
            _answerArray[i] = _temp[i].substring(0, Integer.parseInt(_index[i]));
            _storeIndex[i] = String.valueOf(_tempArray[i].indexOf(_key));
            _answerArray[i + 1] = _tempArray[i].substring(0, Integer.parseInt(_storeIndex[i]));
            _tempArray[i] = _tempArray[i].substring(Integer.parseInt(_storeIndex[i]));
            _tempArray[i] = _tempArray[i].substring(2);
            _tempArray[i] = _tempArray[i].replace(_key, "");
            _answerArray[i + 2] = _tempArray[i];
            _answerArray[i + 3] = _correctAnswer[i];
            System.out.println(_answerArray[i]);
            System.out.println(_answerArray[i + 1]);
            System.out.println(_answerArray[i + 2]);
            System.out.println(_answerArray[i + 3]);
            System.out.println();

        }
    }
}
