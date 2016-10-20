package com.example.christiankarlsson.hangman.model;

import java.util.ArrayList;

public class HangmanGame {
    private static final int MAX_GUESSES = 10;
    private String secretWord;
    private String maskedWord;
    private ArrayList<Character> userGuesses;
    private ArrayList<Character> wrongGuesses;
    private int guessesLeft;

    public HangmanGame() {
        secretWord = GenerateRandomWord.getWord().toUpperCase();
        maskedWord = generateMaskedWord(secretWord);
        userGuesses = new ArrayList<>();
        wrongGuesses = new ArrayList<>();
        guessesLeft = MAX_GUESSES;
    }

    public String getSecretWord() {
        return secretWord;
    }

    public ArrayList<Character> getUserGuesses() {
        return userGuesses;
    }

    public String getGuessesLeftAsString() {
        return "" + guessesLeft;
    }

    private String generateMaskedWord(String s) {
        String str = "";
        for(int i = 0; i < s.length(); i++) {
            str += "_";
        }
        return str;
    }

    public String getMaskedSecretWord() {
        return maskedWord;
    }

    public int getGuessesLeft() {
        return guessesLeft;
    }

    public String getFormattedMaskedSecretWord() {
        String str = "";
        for(int i = 0; i < maskedWord.length(); i++) {
            str += maskedWord.charAt(i) + " ";
        }
        str = str.substring(0,str.length()-1);
        return str;
    }

    public boolean addUserGuesses(char c) {
        c = Character.toUpperCase(c);
        for(char used : userGuesses) {
            if(used == c) {
                return false;
            }
        }
        userGuesses.add(c);
        matchSecretWord(c);
        return true;
    }

    public boolean isGameOver() {
        return (maskedWord.equals(secretWord) || guessesLeft == 0);
    }

    private void matchSecretWord(char c) {
        boolean inWord = false;
        for(int i = 0; i < secretWord.length(); i++) {
            if(secretWord.charAt(i) == c) {
                maskedWord = maskedWord.substring(0,i) + c + maskedWord.substring(i+1);
                inWord = true;
            }
        }
        if(!inWord) {
            wrongGuesses.add(c);
            guessesLeft--;
        }
    }

    public String getWrongGuesses() {
        String str = "";
        if(wrongGuesses.size() != 0) {
            for(char c : wrongGuesses) {
                str += c + ", ";
            }
            str = str.substring(0,str.length()-2);
        }
        return str;
    }

    public int getGuessesUsed() {
        return MAX_GUESSES - guessesLeft+1;
    }
}
