package com.example.randy.android_workshop;

import java.util.Random;

/**
 * Created by Randy on 10/16/2017.
 */

public class Hangman_Engine {
    String[] wordlist;
    //word is going to be the chosen word but as character strings instead of regular
    // characters to allow for comparsion
    String[] word;
    //the word thet will be used an empty string to test your words
    String[] underScores;
    //an empty string of spaces the same length as the word
    String[] spaces;
    //This next fiel d is going to be to keep track of the number of wrong guesses
    int tracker = 5;

    public Hangman_Engine(){
        //This is the word bank for the hangman game
        wordlist= new String[4];
        wordlist[0] = "ubiquitous";
        wordlist[1] = "great";
        wordlist[2] = "powered";
        wordlist[3] = "engineering";
    }

    public void setWord(){
        int chosen;
        Random random = new Random();
        chosen = random.nextInt(4);

        word = new String[wordlist[chosen].length()];
        underScores = new String[wordlist[chosen].length()];
        spaces = new String[wordlist[chosen].length()];

        for(int i = 0; i < word.length; i++){
            word[i] = "" + wordlist[chosen].charAt(i);
            underScores[i]  = "_";
            spaces[i] = " ";
        }

    }

    public String getWord(){
        setWord();
        String ret = "";

        tracker = 5;

        for(int i = 0; i < word.length; i++){
            ret = ret + underScores[i];
            ret = ret + spaces[i];
        }
        return ret;
    }

    public String checkTheWord(String input){
        tracker--;
        for(int i = 0; i < word.length; i++){
            if(input.charAt(0) == word[i].charAt(0)){
                underScores[i] = input;
                tracker++;
            }
        }
        String ret = "";
        for(int i = 0; i < word.length; i++){
            ret = ret + underScores[i];
            ret = ret + spaces[i];
        }
        return ret;
    }

    public String getTracker(){
        int a = 90;
        return "" + tracker;
    }



}
