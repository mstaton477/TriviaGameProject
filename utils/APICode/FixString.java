package APICode;

/**
 * This class fix the formatting of questions and answers that includes
 * quotation marks and apostrophes Updated 4-27-21
 *
 * @author Sengthida Lorvan
 */

public class FixString extends Answers {

    protected static String[] _tempArray = new String[_questions];

    private static String[] replaceHtml(String _key) {
        switch (_key) {
            case "&#039;":
                for (int i = 0; i < _questions; i++) {
                    _tempArray[i] = _tempArray[i].replace(_key, "\'");
                }
                break;
            case "&quot;":
                for (int i = 0; i < _questions; i++) {
                    _tempArray[i] = _tempArray[i].replace(_key, "\"");
                }
                break;
            case "eacute;":
                for (int i = 0; i < _questions; i++) {
                    _tempArray[i] = _tempArray[i].replace(_key, "é");
                }
                break;
            case "&sup2;":
                for (int i = 0; i < _questions; i++) {
                    _tempArray[i] = _tempArray[i].replace(_key, "²");
                }
                break;
            case "&amp;":
                for (int i = 0; i < _questions; i++) {
                    _tempArray[i] = _tempArray[i].replace(_key, "&");
                }
                break;
            case "&ocirc;":
                for (int i = 0; i < _questions; i++) {
                    _tempArray[i] = _tempArray[i].replace(_key, "ô");
                }
                break;
            case "&oacute;":
                for (int i = 0; i < _questions; i++) {
                    _tempArray[i] = _tempArray[i].replace(_key, "ó");
                }
                break;
            case "&aacute;":
                for (int i = 0; i < _questions; i++) {
                    _tempArray[i] = _tempArray[i].replace(_key, "á");
                }
                break;
            case "&Aacute;":
                for (int i = 0; i < _questions; i++) {
                    _tempArray[i] = _tempArray[i].replace(_key, "Á");
                }
                break;
            case "&ntilde;":
                for (int i = 0; i < _questions; i++) {
                    _tempArray[i] = _tempArray[i].replace(_key, "ñ");
                }
                break;
            case "&lt;":
                for (int i = 0; i < _questions; i++) {
                    _tempArray[i] = _tempArray[i].replace(_key, "<");
                }
                break;
            case "&rsquo;":
                for (int i = 0; i < _questions; i++) {
                    _tempArray[i] = _tempArray[i].replace(_key, "\'");
                }
                break;
            case "&ldquo;":
                for (int i = 0; i < _questions; i++) {
                    _tempArray[i] = _tempArray[i].replace(_key, "“");
                }
                break;
            case "&rdquo;":
                for (int i = 0; i < _questions; i++) {
                    _tempArray[i] = _tempArray[i].replace(_key, "”");
                }
                break;
            case "&hellip;":
                for (int i = 0; i < _questions; i++) {
                    _tempArray[i] = _tempArray[i].replace(_key, "…");
                }
                break;
            case "&lrm;":
                for (int i = 0; i < _questions; i++) {
                    _tempArray[i] = _tempArray[i].replace(_key, "‎");
                }
                break;
            case "&Eacute;":
                for (int i = 0; i < _questions; i++) {
                    _tempArray[i] = _tempArray[i].replace(_key, "É");
                }
                break;
            case "&iacute;":
                for (int i = 0; i < _questions; i++) {
                    _tempArray[i] = _tempArray[i].replace(_key, "í");
                }
                break;
            case "&shy;":
                for (int i = 0; i < _questions; i++) {
                    _tempArray[i] = _tempArray[i].replace(_key, "­");
                }
                break;
            case "&auml;":
                for (int i = 0; i < _questions; i++) {
                    _tempArray[i] = _tempArray[i].replace(_key, "ä");
                }
                break;
            case "&ouml;":
                for (int i = 0; i < _questions; i++) {
                    _tempArray[i] = _tempArray[i].replace(_key, "ö");
                }
                break;
            case "&aring;":
                for (int i = 0; i < _questions; i++) {
                    _tempArray[i] = _tempArray[i].replace(_key, "å");
                }
                break;
            case "&deg;":
                for (int i = 0; i < _questions; i++) {
                    _tempArray[i] = _tempArray[i].replace(_key, "°");
                }
                break;
            case "&gt;":
                for (int i = 0; i < _questions; i++) {
                    _tempArray[i] = _tempArray[i].replace(_key, ">");
                }
                break;
            case "&egrave;":
                for (int i = 0; i < _questions; i++) {
                    _tempArray[i] = _tempArray[i].replace(_key, "è");
                }
                break;
        }
        return _tempArray;
    }

    protected static String[] fixQuestions() {
        store(_questionArray, _tempArray);

        for (int i = 0; i < _questions; i++) {
            if (_tempArray[i].contains("&#039;")) {
                _key = "&#039;";
                replaceHtml(_key);
            }
            if (_tempArray[i].contains("&quot;")) {
                _key = "&quot;";
                replaceHtml(_key);
            }
            if (_tempArray[i].contains("&eacute;")) {
                _key = "&eacute;";
                replaceHtml(_key);
            }
            if (_tempArray[i].contains("&sup2;")) {
                _key = "&sup2;";
                replaceHtml(_key);
            }
            if (_tempArray[i].contains("&rsquo;")) {
                _key = "&rsquo;";
                replaceHtml(_key);
            }
            if (_tempArray[i].contains("&ldquo;")) {
                _key = "&ldquo;";
                replaceHtml(_key);
            }
            if (_tempArray[i].contains("&rdquo;")) {
                _key = "&rdquo;";
                replaceHtml(_key);
            }
            if (_tempArray[i].contains("&hellip;")) {
                _key = "&hellip;";
                replaceHtml(_key);
            }
            if (_tempArray[i].contains("&shy;")) {
                _key = "&shy;";
                replaceHtml(_key);
            }
            if (_tempArray[i].contains("&amp;")) {
                _key = "&amp;";
                replaceHtml(_key);
            }
        }

        store(_tempArray, _questionArray);

        _message = "Question ";

        _num = _TWO;

        assign(_tempArray, _questionArray, _message, _num);

        return _questionArray;
    }

    protected static String[] fixIncorrectAnswers() {
        store(_incorrectAnswer, _tempArray);

        for (int i = 0; i < _questions; i++) {
            if (_tempArray[i].contains("&#039;")) {
                _key = "&#039;";
                replaceHtml(_key);
            }
            if (_tempArray[i].contains("&quot;")) {
                _key = "&quot;";
                replaceHtml(_key);
            }
            if (_tempArray[i].contains("&eacute;")) {
                _key = "&eacute;";
                replaceHtml(_key);
            }
            if (_tempArray[i].contains("&amp;")) {
                _key = "&amp;";
                replaceHtml(_key);
            }
            if (_tempArray[i].contains("&ocirc;")) {
                _key = "&ocirc;";
                replaceHtml(_key);
            }
            if (_tempArray[i].contains("&oacute;")) {
                _key = "&oacute;";
                replaceHtml(_key);
            }
            if (_tempArray[i].contains("&aacute;")) {
                _key = "&aacute;";
                replaceHtml(_key);
            }
            if (_tempArray[i].contains("&Aacute;")) {
                _key = "&Aacute;";
                replaceHtml(_key);
            }
            if (_tempArray[i].contains("&ntilde;")) {
                _key = "&ntilde;";
                replaceHtml(_key);
            }
            if (_tempArray[i].contains("&lt;")) {
                _key = "&lt;";
                replaceHtml(_key);
            }
            if (_tempArray[i].contains("&lrm;")) {
                _key = "&lrm;";
                replaceHtml(_key);
            }
            if (_tempArray[i].contains("&Eacute;")) {
                _key = "&Eacute;";
                replaceHtml(_key);
            }
            if (_tempArray[i].contains("&iacute;")) {
                _key = "&iacute;";
                replaceHtml(_key);
            }
            if (_tempArray[i].contains("&auml;")) {
                _key = "&auml;";
                replaceHtml(_key);
            }
            if (_tempArray[i].contains("&aring;")) {
                _key = "&aring;";
                replaceHtml(_key);
            }
            if (_tempArray[i].contains("&deg;")) {
                _key = "&deg;";
                replaceHtml(_key);
            }
            if (_tempArray[i].contains("&gt;")) {
                _key = "&gt;";
                replaceHtml(_key);
            }
            if (_tempArray[i].contains("&egrave;")) {
                _key = "&egrave;";
                replaceHtml(_key);
            }
        }

        store(_tempArray, _incorrectAnswer);

        _message = "Incorrect Answers for Question ";

        _num = _TWO;

        assign(_tempArray, _incorrectAnswer, _message, _num);

        return _incorrectAnswer;
    }

    protected static String[] fixCorrectAnswers() {
        store(_correctAnswer, _tempArray);

        for (int i = 0; i < _questions; i++) {
            if (_tempArray[i].contains("&#039;")) {
                _key = "&#039;";
                replaceHtml(_key);
            }
            if (_tempArray[i].contains("&amp;")) {
                _key = "&amp;";
                replaceHtml(_key);
            }
            if (_tempArray[i].contains("&oacute;")) {
                _key = "&oacute;";
                replaceHtml(_key);
            }
            if (_tempArray[i].contains("&ntilde;")) {
                _key = "&ntilde;";
                replaceHtml(_key);
            }
            if (_tempArray[i].contains("&iacute;")) {
                _key = "&iacute;";
                replaceHtml(_key);
            }
            if (_tempArray[i].contains("&ouml;")) {
                _key = "ouml;";
                replaceHtml(_key);
            }
            if (_tempArray[i].contains("&eacute;")) {
                _key = "&eacute;";
                replaceHtml(_key);
            }
            if (_tempArray[i].contains("&deg;")) {
                _key = "&deg;";
                replaceHtml(_key);
            }
            if (_tempArray[i].contains("&lt;")) {
                _key = "&lt;";
                replaceHtml(_key);
            }
            if (_tempArray[i].contains("&gt;")) {
                _key = "&gt;";
                replaceHtml(_key);
            }
            if (_tempArray[i].contains("&quot;")) {
                _key = "&quot;";
                replaceHtml(_key);
            }
        }

        store(_tempArray, _correctAnswer);

        _message = "Correct Answers for Question ";

        _num = _TWO;

        assign(_tempArray, _correctAnswer, _message, _num);

        return _correctAnswer;
    }
}
