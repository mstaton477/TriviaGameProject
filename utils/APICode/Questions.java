package APICode;

/*
 * Separates questions from query.
 * Updated 4-19-21
 *
 * @author Sengthida Lorvan
 */

public class Questions extends API {
    //arrays to store parsed parts
    public static String[] questions = new String[_questions];
    public static String[] Question = new String[_questions];
    public static String[] index = new String[_questions];
    public static String[] temp = new String[_questions];

    public static String[] questions() {
        makeAPICall();

        try {
            // prints out questions
            var question = _obj.getJSONArray("results").opt(0);

            // Get questions
            for (int i = 0; i < _questions; i++) {
                question = _obj.getJSONArray("results").opt(i);
                questions[i] = question.toString();
            }
            // Remove text in front of questions
            for (int i = 0; i < _questions; i++) {
                Question[i] = questions[i].substring(33);
            }
            // Gets index of next quotation mark
            for (int i = 0; i < _questions; i++) {
                index[i] = String.valueOf(Question[i].indexOf("\""));
            }
            //Copy to temp
            for (int i = 0; i < _questions; i++) {
                temp[i] = Question[i];
            }
            System.out.println();
            // Assigns questions by itself to array
            for (int i = 0; i < _questions; i++) {
                Question[i] = Question[i].substring(0, Integer.parseInt(index[i]));
                System.out.println("Question:" + Question[i]);
                System.out.println();
            }
        } catch (Exception _ex) {
            System.out.println("Error: " + _ex);
        }
        return Question;
    }
}
