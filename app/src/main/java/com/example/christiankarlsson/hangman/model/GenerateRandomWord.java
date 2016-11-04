package com.example.christiankarlsson.hangman.model;

import java.util.Arrays;
import java.util.Random;

public class GenerateRandomWord {

    private static Random rand = new Random();

    private static String[] words = {
            "banan",
            "fluga",
            "chips",
            "säng",
            "dvala",
            "riddare",
            "maskerad",
            "kanin",
            "robot",
            "stålmannen",
            "japan",
            "fotboll",
            "ros",
            "julgran",
            "rike",
            "stövel"
    };

    /**
     * Get one of the words in the array.
     * @return random generated word.
     */
    public static String getWord() {
        return words[rand.nextInt(words.length)];
    }

    /**
     * Sorts the array in alphabetic order.
     * @return sorted array.
     */
    public static String[] getAll() {
        Arrays.sort(words);
        return words;
    }
}
