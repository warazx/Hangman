package com.example.christiankarlsson.hangman.model;

import java.util.ArrayList;

public class HangmanGame {
    private static final int MAX_GUESSES = 10;
    private String secretWord;
    private ArrayList<Character> userGuesses;
    private int guessesLeft;

    public HangmanGame() {
        this.secretWord = "BANAN";
        this.userGuesses = new ArrayList<>();
        guessesLeft = MAX_GUESSES;
    }

    public String getSecretWord() {
        return secretWord;
    }

    public void setSecretWord(String secretWord) {
        this.secretWord = secretWord;
    }

    public ArrayList<Character> getUserGuesses() {
        return userGuesses;
    }

    public String getGuessesLeft() {
        return "" + guessesLeft;
    }

    public void setUsedGuesses(int guessesLeft) {
        this.guessesLeft = guessesLeft;
    }

    public boolean addUserGuesses(char c) {
        c = Character.toUpperCase(c);
        for(char used : userGuesses) {
            if(used == c) {
                return true;
            }
        }
        userGuesses.add(c);
        return false;
    }

    public String getUsedGuesses() {
        String str = "";
        if(userGuesses.size() != 0) {
            for(char c : userGuesses) {
                str += c + ", ";
            }
            str = str.substring(0,str.length()-2);
        }
        return str;
    }
}
