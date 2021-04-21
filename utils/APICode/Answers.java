package APICode;

/**
 * Separates correct answers and incorrect answers from query.
 * Updated 4-20-21
 *
 * @author Sengthida Lorvan
 */

public class Answers extends Questions {

    public static String[] _correctAnswer = new String[_questions];
    public static String[] _incorrectAnswer = new String[_questions];
    public static String[] _incorrectAnswerArray = new String[_questions * 3];

    public static String[] correctAnswers() {
        // Gets text after questions
        for (int i = 0; i < _questions; i++) {
            _correctAnswer[i] = _temp[i].substring(Integer.parseInt(_index[i]));
        }

        // Gets rid of text before
        for (int i = 0; i < _questions; i++) {
            _correctAnswer[i] = _correctAnswer[i].substring(20);
        }

        // Gets index of next comma
        for (int i = 0; i < _questions; i++) {
            _index[i] = String.valueOf(_correctAnswer[i].indexOf("\""));
        }

        //Copy to temp
        for (int i = 0; i < _questions; i++) {
            _temp[i] = _correctAnswer[i];
        }

        // Assigns correct answer by itself into array
        for (int i = 0; i < _questions; i++) {
            _correctAnswer[i] = _correctAnswer[i].substring(0, Integer.parseInt(_index[i]));
            System.out.println("Correct Answer for Question " + (i + 1) + ": " + _correctAnswer[i]);
            System.out.println();
        }
        // Sets leftover substring into this array
        for (int i = 0; i < _questions; i++) {
            _incorrectAnswer[i] = _temp[i].substring(Integer.parseInt(_index[i]));
        }

        return _correctAnswer;
    }

    public static String[] incorrectAnswers() {

        // Set array equal to temp
        for (int i = 0; i < _questions; i++) {
            _incorrectAnswer[i] = _temp[i].substring(Integer.parseInt(_index[i]));
        }

        // Get rid of text in front
        for (int i = 0; i < _questions; i++) {
            _incorrectAnswer[i] = _incorrectAnswer[i].substring(23);
        }

        // Find index of next bracket
        for (int i = 0; i < _questions; i++) {
            _index[i] = String.valueOf(_incorrectAnswer[i].indexOf("]"));
        }

        // Preliminary Array
        for (int i = 0; i < _questions; i++) {
            _incorrectAnswer[i] = _incorrectAnswer[i].substring(0, Integer.parseInt(_index[i]));
        }

        // Get rid of quotations surrounding the answers.
        for (int i = 0; i < _questions; i++){
            _incorrectAnswer[i] = _incorrectAnswer[i].replace("\"","");
            System.out.println(_incorrectAnswer[i]);
            System.out.println();
        }

        return _incorrectAnswer;
    }

    public static void main(String[] args) {
        question();
        correctAnswers();
        incorrectAnswers();
    }
}