package APICode;

/**
 * Separates correct answers and incorrect answers from query.
 * Updated 4-13-21
 *
 * @author Sengthida Lorvan
 */

public class Answers extends Questions {
    public static String[] correctAnswer = new String[_questions];

    public static String[] correctAnswers() {
        // Gets text after questions
        for (int i = 0; i < _questions; i++) {
            correctAnswer[i] = temp[i].substring(Integer.parseInt(index[i]));
            //    System.out.println(correctAnswers[i]);
        }
        // Gets rid of text before
        for (int i = 0; i < _questions; i++) {
            correctAnswer[i] = correctAnswer[i].substring(20);
            System.out.println(correctAnswer[i]);
            System.out.println();
        }

        for (int i = 0; i < _questions; i++) {
            index[i] = String.valueOf(correctAnswer[i].indexOf("\""));
        }

        for(int j = 0; j < _questions; j++){
            correctAnswer[j] = correctAnswer[j].substring(Integer.parseInt(index[j]));
            //System.out.println(correctAnswer[j]);
            //System.out.println();
        }
        return correctAnswer;
    }

    public static void main(String[] args) {
        questions();
        correctAnswers();
    }

}
