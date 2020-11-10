package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // initializing the keywords and adding them to an arraylist
        Keywords keywords = new Keywords();
        keywords.addKeyword("explain");
        keywords.addKeyword("don't");
        keywords.addKeyword("know");
        keywords.addKeyword("rules");

        // welcome/starting message
        System.out.println("Welcome to Blackjack!");
        System.out.println("Do you know the rules or would you like me to explain them?");

        // read answer
        String answer = readString();
        //System.out.println(answer);
        String[] words = split(answer);
        Keywords keys = new Keywords();
        KeywordReader keywordReader = new KeywordReader(answer, keys);
        System.out.println("trigger: " + keywordReader.trigger);                // test
        //System.out.println(Arrays.toString(keywordReader.input));                   // test
        //System.out.println(keywordReader.keywords.getAsString(0));            // test
        System.out.println(keywordReader.containsKeywords());                       // test
        keywordReader.showContainedKeywords();                                  // test
        //TriggerMap map = new TriggerMap();
        //map.show();
        Reply response = new Reply(keywordReader.trigger);



        /**
         // check if answer contains specific keyword
         boolean[] keywordCheck = contains(words, keywordsBeforeGame);
         //printBooleanArray(keywordCheck);
         int[] keywordCheckIndices = containsIndices(words, keywordsBeforeGame);
         System.out.print("The answer contains the keywords at these indices: ");
         System.out.println(Arrays.toString(keywordCheckIndices));
         System.out.println("test for explain and rules: " + anotherContainsMethod(keywordCheckIndices, 0, 3));
         //System.out.println("test for 0: " + anotherContainsMethod(keywordCheckIndices, 0));
         System.out.println("test for explain, don't and rules: " + anotherContainsMethod(keywordCheckIndices, 0, 1, 3));

         // react based on keywords found
         // reminder: String[] keywordsBeforeGame = {"explain", "don't", "know", "rules"};
         // "explain" && !"don't" -> explain rules
         // "I don't know the rules" -> explain rules

         if ((keywordCheck[0] && !keywordCheck[1]) || (keywordCheck[1] && keywordCheck[2] && keywordCheck[3])) {
         System.out.println("No, problem! These are the rules: bla bla");
         System.out.println("Any questions about the rules or are you ready to play?");

         }
         if ((anotherContainsMethod(keywordCheckIndices, 0) && !anotherContainsMethod(keywordCheckIndices, 1)) || (anotherContainsMethod(keywordCheckIndices, 1, 2, 3))) {
         System.out.println("No, problem! These are the rules: bla bla");
         System.out.println("Any questions about the rules or are you ready to play?");

         }


         // "don't" && "explain" -> start game
         // "i know the rules" -> start game




         /*


         int i;
         ArrayList<Integer> index = new ArrayList<Integer>();
         for (i = 0; i < keywords.length; i++){
         if (Arrays.asList(sentence.split(" ")).contains(keywords[i])) {
         System.out.println(keywords[i]);
         index.add(i);
         }
         }
         */


        //System.out.println(index);
        //System.out.println(Arrays.asList(keywords));

    }

    // method that reads input as a string
    public static String readString() {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        return input;
    }

    // method that splits sentences into words / string into string[]
    public static String[] split(String s) {
        String[] words = s.toLowerCase().split(" ");
        return words;
    }

    // which keywords does the answer contain?
    public static boolean[] contains(String[] input, String[] keywordList){
        // create an array for the answers
        boolean [] answerList = new boolean[keywordList.length];

        // fill the answer array with 'false'
        for (boolean v : answerList) {
            v = false;
        }

        // check for each keyword and replace 'false' with 'true' if keyword found
        for (int i = 0; i < keywordList.length; i++) {
            for (String word : input) {
                if (word.equals(keywordList[i])) {
                    answerList[i] = true;
                }
            }
        }

        return answerList;
    }

    // method that returns the indices of the keywords contained
    // input: sentence array, some keyword array to check for, output: indices of the keywords contained
    public static int[] containsIndices(String[] input, String[] keywords){
        // create an array for the answers
        int[] result = new int[0];

        // check for each keyword
        for (int i = 0; i < keywords.length; i++) {
            for (String word : input) {
                if (word.equals(keywords[i])) {
                    // append index
                    result = Arrays.copyOf(result, result.length + 1);
                    result[result.length - 1] = i;
                }
            }
        }

        return result;
    }

    // checking if the keyword check array contains numbers x and y
    // input should be int[] instead of xs
    public static boolean anotherContainsMethod(int[] array, int ...xs) {
        boolean[] tracker = new boolean[xs.length];
        //System.out.println("tracker length: "+tracker.length);

        // fill the tracker array with 'false'
        for (boolean t : tracker) {
            t = false;
        }

        // update the tracker if x is found
        for (int x : xs) {
            int index = 0;
            for (int i = 0; i < xs.length; i++){
                if (xs[i] == x){
                    index = i;
                }
            }
            //System.out.println("index of " + x + ": " + index);
            for (int a : array) {
                if (x == a) {
                    tracker[index] = true;
                }
            }
        }

        // return true if all values of tracker are true
        // return false if at least one value of tracker is false
        for (boolean t : tracker ) {
            if (!t) {
                return false;
            }
        }
        return true;
    }


    // method that prints each word in a string[] in a separate line
    public static void printStringArray(String[] words) {
        for (String word : words){
            System.out.println(word);
        }
    }

    // method that prints boolean values in a boolean[] separated by spaces
    public static void printBooleanArray(boolean[] values) {
        for (boolean value : values){
            System.out.print(value + " ");
        }
    }

    // method that converts an integer arraylist to an int[]
    public static int[] toIntArray(ArrayList<Integer> list) {
        int[] array = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
    }
}















        /*
        public static String cardFinder(String[] keywords){
            //keyword = "123woods";
            for (int i = 0; i > keywords.length; i++) {
                Boolean found = Arrays.asList(string.split(" ")).contains(keywords[i]);
                if (found) {
                    System.out.println("Keyword matched the string");
                    int foundIndex = i;
                }
            }
            return keywords[i];
    */




/*
- Find a way to read and recognize Strings
- if *a word* and *a word* then *sentence*
- Error response
- keyword rank stack
- read numbers
- class for sentences. And array of possible answers. Array that you search through.
- detect repeat
- construct sentence containing keyword

- Keyword class
    String word
    int sentence *(index)*

 Keyword k = new Keyword ("sleep",2) .... so if we get keyword "sleep", we reply with Sentence 2
    k getIndex()

- first: show dialog - receive data from dialog - print out data in new dialog
- start with static sentences
- keywords has references to relevant sentences.

Sentence[] answers = new Sentence(MAX);

private final int max = 20;


PDF hand in!


 */