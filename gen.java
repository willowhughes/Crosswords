import java.util.*;
import java.io.*;

public class gen {
   
   public int size;
   public String[] words = new String[3];
   public char[][] grid = new char[size][size];
   Random rn = new Random();
   Scanner in = new Scanner(System.in);
      
   public gen(int size, String[] words) {
      this.size = size;
      this.words = words;
   }
   
   public void filler() {
      char[][] temp = new char[size][size]; //this is the solution grid of X's
      char[][] grid = new char[size][size]; //this is the guessing grid of random chars
      for (int x = 0; x < size; x++) {
         for (int y = 0; y < size; y++) {
            char c = (char)(rn.nextInt(26) + 'a');
            grid[x][y] = c;
            temp[x][y] = 'X';
         }
      }
      for (int i = 0; i < words.length; i++) {
         int rand = rn.nextInt(2); //coin flip for if word will be verticle or horizontal
         if (rand == 1) { //generates horizontal word
            int rand1 = rn.nextInt(size - words[i].length()); //random x cordinate for word
            int rand2 = rn.nextInt(size - words[i].length()); //random y cordinate for word (might have my x and y mixed up)
            for (int g = 0; g < words[i].length(); g++) { //for loop to print each char of the word
               grid[rand1][rand2 + g] = words[i].charAt(g);
               temp[rand1][rand2 + g] = words[i].charAt(g);            
            }
         } else { //generates verticle word
            int rand3 = rn.nextInt(size - words[i].length());
            int rand4 = rn.nextInt(size - words[i].length());
            for (int g = 0; g < words[i].length(); g++) {
               grid[rand3 + g][rand4] = words[i].charAt(g);
               temp[rand3 + g][rand4] = words[i].charAt(g);
            }
         }
      }
      print(grid);
      System.out.println("ready for the solution?");
      String answer = in.next();
      if (answer.charAt(0) != 'n') {
         solutionPrint(temp);
      }
   }
   
   public void print(char[][] grid) { //Prints the wordsearch version of the grid
      for (int x = 0; x < size; x++) {
         for (int y = 0; y < size; y++) {
            System.out.print(grid[x][y] + " ");
         }
      System.out.println();
      }
   }
   
   public void solutionPrint(char[][] temp) { //prints the version of the grid with X's
      for (int x = 0; x < size; x++) {
         for (int y = 0; y < size; y++) {
            System.out.print(temp[x][y] + " ");
         }
      System.out.println();
      }
   }
}