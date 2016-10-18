package com.example.christiankarlsson.hangman.model;

import java.util.ArrayList;

public class HangmanGame {
    private String secretWord;
    private ArrayList<Character> userGuesses;

    public HangmanGame() {
        this.secretWord = "BANAN";
        this.userGuesses = new ArrayList<>();
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

    public void addUserGuesses(char c) {
        userGuesses.add(c);
    }
}
