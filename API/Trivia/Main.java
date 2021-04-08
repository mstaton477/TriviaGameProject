package Trivia;

/**
 * Main Class
 * Updated: 4-8-21
 * @author Sengthida Lorvan
 */

import java.util.Scanner;

public class Main extends API{
    public static void main(String[] args) {
        //Temporary use for assigning values to test
        Scanner input = new Scanner(System.in);
        System.out.println("Categories: ");
        System.out.println("General Knowledge - 9");
        System.out.println("Entertainment: Music - 12");
        System.out.println("Entertainment: Video Games - 15");
        System.out.println("Science & Nature - 17");
        System.out.println("Science: Computers - 18");
        System.out.println("Science: Mathematics - 19");
        System.out.println("Entertainment: Japanese Anime & Manga - 31");
        System.out.println();
        System.out.println("Enter category number: ");
        _category = input.nextInt();
        System.out.println();
        System.out.println("Difficulties: ");
        System.out.println("easy");
        System.out.println("medium");
        System.out.println("hard");
        System.out.println();
        System.out.println("Enter difficulty: ");
        _difficulty = input.next();
        System.out.println();
        System.out.println("Game lengths: ");
        System.out.println("Short: 10 questions");
        System.out.println("Medium: 20 questions");
        System.out.println("Long: 30 questions");
        System.out.println("Enter game length number: ");
        _questions = input.nextInt();
        //Call method
        createGame();
    }
    
}
