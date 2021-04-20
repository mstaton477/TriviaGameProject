package APICode;

/**
 * Separates correct answers and incorrect answers from query.
 * Updated 4-19-21
 *
 * @author Sengthida Lorvan
 */

public class Answers extends Questions {
    public static String[] correctAnswer = new String[_questions];
    public static String[] incorrectAnswer = new String[_questions];

    public static String[] correctAnswers() {
        // Gets text after questions
        for (int i = 0; i < _questions; i++) {
            correctAnswer[i] = temp[i].substring(Integer.parseInt(index[i]));
        }

        // Gets rid of text before
        for (int i = 0; i < _questions; i++) {
            correctAnswer[i] = correctAnswer[i].substring(20);
        }

        // Gets index of next quotation mark
        for (int i = 0; i < _questions; i++) {
            index[i] = String.valueOf(correctAnswer[i].indexOf("\""));
        }

        //Copy to temp
        for (int i = 0; i < _questions; i++) {
            temp[i] = correctAnswer[i];
        }

        // Assigns correct answer by itself into array
        for(int i = 0; i < _questions; i++){
            correctAnswer[i] = correctAnswer[i].substring(0, Integer.parseInt(index[i]));
            System.out.println("Correct Answer " + (i + 1) +": " + correctAnswer[i]);
            System.out.println();
        }
        // Sets leftover substring into this array
        for (int j = 0; j < _questions; j++) {
            incorrectAnswer[j] = temp[j].substring(Integer.parseInt(index[j]));
        }
        return correctAnswer;
    }
    public static String[] incorrectAnswers() {
        // Gets text after correct answer
        for (int i = 0; i < _questions; i++) {
            incorrectAnswer[i] = temp[i].substring(Integer.parseInt(index[i]));
        }
        // Remove text in front of incorrect answers
        for (int i = 0; i < _questions; i++) {
            incorrectAnswer[i] = incorrectAnswer[i].substring(23);
        }

        // Gets index of next quotation mark
        for (int i = 0; i < _questions; i++) {
            index[i] = String.valueOf(incorrectAnswer[i].indexOf("]"));
        }

        // Assigns incorrect answer by itself into array
        for(int i = 0; i < _questions; i++){
            incorrectAnswer[i] = incorrectAnswer[i].substring(0, Integer.parseInt(index[i]));
            System.out.println("incorrect Answers for Question " + (i + 1) +": " + incorrectAnswer[i]);
            System.out.println();
        }
        return incorrectAnswer;
    }

    public static void main(String[] args) {
        questions();
        correctAnswers();
        incorrectAnswers();
    }

}
