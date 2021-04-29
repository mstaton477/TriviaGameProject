package Models;

import APICode.*;
import Controllers.QuizController;
import GUI.QuizView;
import Models.*;


public class experimentalCode {

    public static void main(String[] args) {

        QuizController.setGameDifficulty("easy");
        QuizController.setGameLength(10);
        QuizController.setCategory(31);


        Questions.question();
        Answers.correctAnswers();
        Answers.incorrectAnswers();
        FixString.fixQuestions();
        FixString.fixCorrectAnswers();
        FixString.fixIncorrectAnswers();
        SplitAndJoin.separate();

        for (int i = 0; i < Quiz.getQuestionArray().length; i++) {
            System.out.println(Quiz.questionArray[i]);
        }


        for (int i = 0; i < Quiz.getAnswerArray().length; i++) {
            System.out.println(Quiz.answerArray[i]);
        }
    }
}
