package APICode;

/**
 * Separates correct answers and incorrect answers from query.
 * Updated 4-13-21
 *
 * @author Sengthida Lorvan
 */

public class Answers extends Questions {
    public static String[] correctAnswer;
    public static String[] incorrectAnswer;

    public Answers() {
    }

    public static String[] correctAnswers() {
        int j;
        for(j = 0; j < _questions; ++j) {
            correctAnswer[j] = temp[j].substring(Integer.parseInt(index[j]));
        }

        for(j = 0; j < _questions; ++j) {
            correctAnswer[j] = correctAnswer[j].substring(20);
        }

        for(j = 0; j < _questions; ++j) {
            index[j] = String.valueOf(correctAnswer[j].indexOf("\""));
        }

        for(j = 0; j < _questions; ++j) {
            temp[j] = correctAnswer[j];
        }

        for(j = 0; j < _questions; ++j) {
            correctAnswer[j] = correctAnswer[j].substring(0, Integer.parseInt(index[j]));
            System.out.println("Correct Answer " + (j + 1) + ": " + correctAnswer[j]);
            System.out.println();
        }

        for(j = 0; j < _questions; ++j) {
            incorrectAnswer[j] = temp[j].substring(Integer.parseInt(index[j]));
        }

        return correctAnswer;
    }

    public static String[] incorrectAnswers() {
        int i;
        for(i = 0; i < _questions; ++i) {
            incorrectAnswer[i] = temp[i].substring(Integer.parseInt(index[i]));
        }

        for(i = 0; i < _questions; ++i) {
            incorrectAnswer[i] = incorrectAnswer[i].substring(23);
        }

        for(i = 0; i < _questions; ++i) {
            index[i] = String.valueOf(incorrectAnswer[i].indexOf("]"));
        }

        for(i = 0; i < _questions; ++i) {
            incorrectAnswer[i] = incorrectAnswer[i].substring(0, Integer.parseInt(index[i]));
            System.out.println("incorrect Answers for Question " + (i + 1) + ": " + incorrectAnswer[i]);
            System.out.println();
        }

        return incorrectAnswer;
    }

    public static void main(String[] args) {
        questions();
        correctAnswers();
        incorrectAnswers();
    }

    static {
        correctAnswer = new String[_questions];
        incorrectAnswer = new String[_questions];
    }
}