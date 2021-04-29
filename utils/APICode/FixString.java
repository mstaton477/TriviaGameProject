package APICode;

/**
 * This class fix the formatting of questions and answers that includes
 * any special characters
 * Updated 4-29-21
 *
 * @author Sengthida Lorvan
 */
public class FixString extends Answers {

    private static String[] _tempArray = new String[_questions];
    private static String[] _replaceChar = {"\'", "\"", "é", "²", "&", "ô", "ó", "á", "Á", "ñ", "<", "“", "”", "…", "‎", "É", "í", "­", "ä", "ö", "å", "°", ">", "è", "\'"};
    private static String[] _messageArray = {"Question ", "Incorrect Answers for Question ", "Correct Answers for Question "};
    private static String[] _html = {"&#039;", "&quot;", "eacute;", "&sup2;", "&amp;", "&ocirc;", "&oacute;", "&aacute;", "&Aacute;", "&ntilde;", "&lt;", "&ldquo;", "&rdquo;", "&hellip;", "&lrm;", "&Eacute;", "&iacute;", "&shy;", "&auml;", "&ouml;", "&aring;", "&deg;", "&gt;", "&egrave;", "&rsquo;"};

    public static void check() {
        for (int i = 0; i < _html.length; i++) {
            _key = _html[i];
            for (int j = 0; j < _questions; j++) {
                if (_tempArray[j].contains(_key)) {
                    replaceHtml(_tempArray, _key, _replaceChar[i]);
                }
            }
        }
    }

    public static String[] replaceHtml(String[] _array, String _key, String _replace) {
        for (int i = 0; i < _questions; i++) {
            _array[i] = _array[i].replace(_key, _replace);
        }
        return _tempArray;
    }

    public static String[] fixQuestions() {
        store(_questionArray, _tempArray);
        check();
        store(_tempArray, _questionArray);
        _message = _messageArray[0];
        _num = _TWO;
        assign(_tempArray, _questionArray, _message, _num);
        return _questionArray;
    }

    public static String[] fixIncorrectAnswers() {
        store(_incorrectAnswer, _tempArray);
        check();
        store(_tempArray, _incorrectAnswer);
        _message = _messageArray[1];
        _num = _TWO;
        assign(_tempArray, _incorrectAnswer, _message, _num);
        return _incorrectAnswer;
    }

    protected static String[] fixCorrectAnswers() {
        store(_correctAnswer, _tempArray);
        check();
        store(_tempArray, _correctAnswer);
        _message = _messageArray[2];
        _num = _TWO;
        assign(_tempArray, _correctAnswer, _message, _num);
        return _correctAnswer;
    }
}
