package com.example.christiankarlsson.hangman.model;

import java.util.ArrayList;

public class HangmanGame {

    private static HangmanGame game = null;

    /**
     * Singelton getter of the instance.
     * @return the instnce of the game.
     */
    public static HangmanGame getGame() {
        if(game == null) {
            game = new HangmanGame();
        }
        return game;
    }

    /**
     * Forces a new game.
     */
    public void startNew() {
        game = new HangmanGame();
    }

    private static final int MAX_GUESSES = 10;
    private String secretWord;
    private String maskedWord;
    private ArrayList<Character> userGuesses;
    private ArrayList<Character> wrongGuesses;
    private int guessesLeft;
    private boolean isPaused = false;

    /**
     * Default constructor for the game.
     */
    public HangmanGame() {
        secretWord = GenerateRandomWord.getWord().toUpperCase();
        maskedWord = generateMaskedWord(secretWord);
        userGuesses = new ArrayList<>();
        wrongGuesses = new ArrayList<>();
        guessesLeft = MAX_GUESSES;
    }

    /**
     * @return the secret word.
     */
    public String getSecretWord() {
        return secretWord;
    }

    /**
     * @return guesses left as string.
     */
    public String getGuessesLeftAsString() {
        return "" + guessesLeft;
    }

    /**
     * Generate a masked word.
     * @param s the word that needs to masked.
     * @return the word masked.
     */
    private String generateMaskedWord(String s) {
        String str = "";
        for(int i = 0; i < s.length(); i++) {
            str += "_";
        }
        return str;
    }

    /**
     * @return guesses left.
     */
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

    /**
     * Takes one guess from the player.
     * @param c the gueesed character.
     * @return if the guess was valid.
     */
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

    /**
     * @param paused set to pause the game.
     */
    public void setPaused(boolean paused) {
        isPaused = paused;
    }

    /**
     * @return if the game is paused.
     */
    public boolean isPaused() {
        return isPaused;
    }

    /**
     * @return if the game is over.
     */
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

    /**
     * @return a string with all guesses formated.
     */
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
}
