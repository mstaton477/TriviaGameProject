package APICode;

/**
 * This class creates the answer array Updated 4-28-21
 *
 * @author Sengthida Lorvan
 */
public class SplitAndJoin extends FixString {

    public static String[] _answerArray = new String[_questions * 4];
    protected static String[] _tempArray = new String[_questions];
    protected static String[] _storeIndex = new String[_questions];

    public static void sub(String[] _array, int _num) {
        for (int i = 0; i < _array.length; i++) {
            _array[i] = _array[i].substring(_num);
        }
    }

    public static String[] separate() {
        store(_incorrectAnswer, _temp);
        _num = 1;
        sub(_temp, _num);
        // Find index of next quotation mark
        _key = "\"";
        find(_temp, _index, _key);
        int i = 0;
        int j = 0;
        do {
            _answerArray[j] = _temp[i].substring(0, Integer.parseInt(_index[i]));
            _tempArray[i] = _temp[i].substring(Integer.parseInt(_index[i]));
            j += 4;
            i++;
        } while (j < _answerArray.length);
        _num = 2;
        sub(_tempArray, _num);
        find(_tempArray, _storeIndex, _key);
        i = 0;
        j = 1;
        do {
            _answerArray[j] = _tempArray[i].substring(0, Integer.parseInt(_storeIndex[i]));
            _tempArray[i] = _tempArray[i].substring(Integer.parseInt(_storeIndex[i]));
            j += 4;
            i++;
        } while (j < _answerArray.length);
        sub(_tempArray, _num);
        find(_tempArray, _storeIndex, _key);
        i = 0;
        j = 2;
        do {
            _answerArray[j] = _tempArray[i].substring(0, Integer.parseInt(_storeIndex[i]));
            _tempArray[i] = _tempArray[i].substring(Integer.parseInt(_storeIndex[i]));
            j += 4;
            i++;
        } while (j < _answerArray.length);
        i = 0;
        j = 3;
        do {
            _answerArray[j] = _correctAnswer[i];
            j += 4;
            i++;
        } while (j < _answerArray.length);

        return _answerArray;
    }
}
