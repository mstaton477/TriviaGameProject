package Models;

import APICode.*;
import Models.Player;

/*
 * Author @McKenzie
 * Last Updated: 4/14/21
 * This class holds all the information related to the quiz.
 */
public class Quiz {
    public void quiz(){

    }

   public int getGameLength(){
        return API._questions;

        //set by the GUI
   }

   public String chooseCategory(){
        return API._categoryName;

        //set by GUI
   }

   public String getDifficulty(){
        return API._difficulty;
   }

//   public int getScore(){
//         int gameLength = getGameLength();
//         int correctAnswers; //figure
//
//       return Player.playerScore;
//   }
}
