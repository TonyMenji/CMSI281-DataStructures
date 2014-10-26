import java.io.*;
import java.util.*;
import java.util.Scanner;

public class WordSort {
  
  public static void main(String[] args) {
    
    //Makes sure that there are either one or two arguments
    if (args.length < 1 || args.length > 2) {
      System.out.println("Incorrect Use of Arguments, Use Either:");
      System.out.println("java WordSort textFileInput");
      System.out.println("           or");
      System.out.println("java WordSort -sensitive textFileInput");
      return;
    }
    
    //Defines the argument as the text file
    String textFileInput = args[0];
    if (args.length == 2) {
      textFileInput = args[1];
    }

    //creates a map that holds the word as a string and its frequency as an integer
    TreeMap <String,Integer> wordFrequency = new TreeMap <String,Integer>(  );

    // read every line of the input file
  try {
    //Takes in the text file input
    Scanner in = new Scanner(new File(textFileInput));

    //Checks if first argument (if two) is not the parameter
    if (args.length == 2 && !args[0].matches("-sensitive")){
      System.out.println("If you are writing two arguments:"); 
      System.out.println("have the parameter '-sensitive' first and then the textFileInput");
      System.out.println("Otherwise just include the textFileInput");
    }

    //Checks if first argument (if two) is the parameter
    if (args[0].matches("-sensitive")) {
      while (in.hasNext()) {
        //Removes all non-letters so only letters are taken into account
        String word=in.next().replaceAll("[^a-zA-Z]", "");
        if (!wordFrequency.containsKey(word)) {
          wordFrequency.put(word, 1);
        }
        else {
          wordFrequency.put(word, wordFrequency.get(word) + 1);
        }
      }
    }

    //Uses the first argument as the text file
    else if (args.length == 1) {
      while (in.hasNext()) {
        //Removes all non-letters so only letters are taken into account
        String word=in.next().replaceAll("[^a-zA-Z]", "").toUpperCase();
        if (!wordFrequency.containsKey(word)) {
          wordFrequency.put(word, 1);
        }
        else {
          wordFrequency.put(word, wordFrequency.get(word) + 1);
        }
      }
    }
  }
  //Exception thrown if there is no text file as an argument
  catch (IOException e) {
    System.out.println("Please include a text file to scan for a list and frequency of words!");
  }

    Set <String> list = wordFrequency.keySet();
   
    for (String s:list) 
      System.out.println(s + "\t = " + wordFrequency.get(s));
    
    
  }
}