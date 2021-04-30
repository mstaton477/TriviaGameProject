package APICode;

/**
 * This class fix the formatting of questions and answers that includes
 * any special characters
 * Updated 4-29-21
 *
 * @author Sengthida Lorvan
 */
public class FixString extends SplitAndJoin {
    // Reference Arrays and a temporary array
    private static String[] _tempArray1 = new String[_questions];
    private static String[] _tempArray2 = new String[_answerArray.length];
    private static final String[] _replaceChar = {"\'", "\"", "é", "²", "&", "ô", "ó", "á", "Á", "ñ", "<", "“", "”", "…", "‎", "É", "í", "­", "ä", "ö", "å", "°", ">", "è", "\'","ë"};
    private static final String[] _html = {"&#039;", "&quot;", "eacute;", "&sup2;", "&amp;", "&ocirc;", "&oacute;", "&aacute;", "&Aacute;", "&ntilde;", "&lt;", "&ldquo;", "&rdquo;", "&hellip;", "&lrm;", "&Eacute;", "&iacute;", "&shy;", "&auml;", "&ouml;", "&aring;", "&deg;", "&gt;", "&egrave;", "&rsquo;","&euml;"};

    // Helper method that sets the key and then calls the helper method for replacing html
    private static void check(int _loop1, int _loop2, String _key, String[] _arrayInput1, String[]_array, String[] _arrayInput2){
        for (int i = 0; i < _loop1; i++) {
            _key = _arrayInput1[i];
            for (int j = 0; j < _loop2; j++) {
                if (_array[j].contains(_key)) {
                    replaceHtml(_array, _key, _arrayInput2[i], _loop2);
                }
            }
        }
    }

    // Helper method that replaces html
    private static String[] replaceHtml(String[] _array, String _key, String _replace,int  loopNum) {
        int _loop = loopNum;
        for (int i = 0; i < _loop; i++) {
            _array[i] = _array[i].replace(_key, _replace);
        }
        return _array;
    }

    public static String[] fixQuestions() {
        store(_questionArray, _tempArray1, _questions);
        check(_html.length, _questions, _key, _html,_tempArray1, _replaceChar);
        store(_tempArray1, _questionArray, _questions);
        _num = _TWO;
        assign(_tempArray1, _questionArray, _num);
        return _questionArray;
    }

    public static String[] fixCorrectAnswers() {
        store(_correctAnswer, _tempArray1, _questions);
        check(_html.length, _questions, _key, _html,_tempArray1, _replaceChar);
        store(_tempArray1, _correctAnswer, _questions);
        _num = _TWO;
        assign(_tempArray1, _correctAnswer, _num);
        return _correctAnswer;
    }

    public static String[] fixAnswers() {
        store(_answerArray, _tempArray2, _answerArray.length);
        check(_html.length, _answerArray.length, _key, _html,_tempArray2, _replaceChar);
        store(_tempArray2, _answerArray, _answerArray.length);
        _num = _TWO;
        assign(_tempArray2, _correctAnswer, _num);
        return _answerArray;
    }
}
