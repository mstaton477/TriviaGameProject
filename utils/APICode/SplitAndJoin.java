package APICode;

/**
 * This class creates the answer array.
 * Updated 4-29-21
 *
 * @author Sengthida Lorvan
 */
public class SplitAndJoin extends Answers {

    public static String[] _answerArray = new String[_questions * 4];
    private static String[] _tempArray = new String[_questions];
    private static String[] _storeIndex = new String[_questions];

    private static void assignAnswer(int i, int j, String[] _arrayInput1, String[] _arrayInput2, String[] _arrayOutput1, String[] _arrayOutput2) {
        do {
            _arrayOutput1[j] = _arrayInput1[i].substring(0, Integer.parseInt(_arrayInput2[i]));
            _arrayOutput2[i] = _arrayInput1[i].substring(Integer.parseInt(_arrayInput2[i]));
            j += 4;
            i++;
        } while (j < _arrayOutput1.length);
    }

    public static String[] separate() {
        store(_incorrectAnswer, _temp, _questions);
        _num = 1;
        reduce(_temp, _temp.length, _num);
        _key = "\"";
        find(_temp, _index, _key);
        int i = 0;
        int j = 0;
        assignAnswer(i, j, _temp, _index, _answerArray, _tempArray);
        _num = 2;
        reduce(_tempArray, _tempArray.length, _num);
        find(_tempArray, _storeIndex, _key);
        j = 1;
        assignAnswer(i, j, _tempArray, _storeIndex, _answerArray, _tempArray);
        reduce(_tempArray, _tempArray.length, _num);
        find(_tempArray, _storeIndex, _key);
        j = 2;
        assignAnswer(i, j, _tempArray, _storeIndex, _answerArray, _tempArray);
        j = 3;
        do {
            _answerArray[j] = _correctAnswer[i];
            j += 4;
            i++;
        } while (j < _answerArray.length);
        return _answerArray;
    }
}
