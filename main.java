import java.util.*;
import java.io.*;

public class main {
   public static void main (String[] args) {
   
      Scanner in = new Scanner(System.in);
      int loop = 0;
      
      
      System.out.println("Welcome to my word search program!");
      System.out.println("**********************************");
      while (loop == 0) {
         System.out.println("how many words would you like to add (up to 6)");
         String answer = in.next();
         int numOfWords = Integer.parseInt(answer); 
         String[] words = new String[numOfWords]; 
         for (int i = 0; i < numOfWords; i++) { //accepts entered words and adds them to an array
            System.out.println("Please type in word number " + (i + 1) + ": ");
            answer = in.next();
            words[i] = answer;
         }
         
         gen newGame = new gen(gridSizer(numOfWords), words); //creates the grid generation object
         newGame.filler(); //this is the primary ("main") method of the object
         System.out.println("Start fresh?");
         answer = in.next();
         if (answer.charAt(0) == 'y' || answer.charAt(0) == 'Y') {
            loop = 0;
         } else {
            loop = 1;
         }
      } //end game while loop
   }
   
   public static int gridSizer(int numOfWords) { //determines how big the grid should be
      int gridSize = 0;
      if (numOfWords < 3) {
            gridSize = numOfWords * 7;
         } else if (numOfWords < 5) {
            gridSize = numOfWords * 4;
         } else if (numOfWords < 6) {
            gridSize = numOfWords * 4;
         } else if (numOfWords < 7) {
            gridSize = numOfWords * 3;
         } else {
            gridSize = numOfWords;
         }
      return gridSize;
   }
}