package Models;

import APICode.*;
import Controllers.QuizController;
import GUI.QuizView;
import Models.*;


public class experimentalCode {

    public static void main(String[] args) {

        Questions.question();
        Answers.correctAnswers();
        Answers.incorrectAnswers();
        FixString.fixQuestions();
        FixString.fixCorrectAnswers();
        SplitAndJoin.separate();
        FixString.fixAnswers();

      /*  for (int i = 0; i < Quiz.getQuestionArray().length; i++) {
            System.out.println(Quiz.questionArray[i]);
        }*/

        Quiz.getAnswerArray();
        for (int i = 0; i < Quiz.getAnswerArray().length; i++) {
            System.out.println(Quiz.answerArray[i]);

        }
    }
}
