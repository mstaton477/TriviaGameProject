package APICode;

public class Randomize extends Answers {
    public static String[] _AnswerArray = new String[_questions * 4];

    protected static void separate() {
        store(_incorrectAnswer, _temp);
        // Find index of next comma
        _key = ",";
        find(_temp, _index, _key);

        //working on this currently
        for(int i = 0; i < 4; i++){
            _AnswerArray[i] = _temp[i].substring(0,Integer.parseInt(_index[i]));
            System.out.println(_AnswerArray[i]);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        question();
        correctAnswers();
        incorrectAnswers();
        separate();
    }
}
