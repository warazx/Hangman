package com.example.christiankarlsson.hangman.model;

import java.util.ArrayList;

public class HangmanGame {
    private static final int MAX_GUESSES = 10;
    private String secretWord;
    private String maskedWord;
    private ArrayList<Character> userGuesses;
    private int guessesLeft;

    public HangmanGame() {
        secretWord = "BANAN";
        maskedWord = generateMaskedWord(secretWord);
        userGuesses = new ArrayList<>();
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

    private String generateMaskedWord(String s) {
        String str = "";
        for(int i = 0; i < s.length(); i++) {
            str += "_";
        }
        return str;
    }

    public boolean addUserGuesses(char c) {
        c = Character.toUpperCase(c);
        for(char used : userGuesses) {
            if(used == c) {
                //matchSecretWord(c);
                return false;
            }
        }
        userGuesses.add(c);
        return true;
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
