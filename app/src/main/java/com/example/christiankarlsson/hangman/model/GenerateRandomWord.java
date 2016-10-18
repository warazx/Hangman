package com.example.christiankarlsson.hangman.model;

import java.util.Random;

public class GenerateRandomWord {

    private static Random rand = new Random();

    private static String[] words = {
            "banan",
            "fluga",
            "chips",
            "mjölk",
            "säng",
            "dvala",
            "riddare",
            "stålull",
            "maskerad"
    };

    public static String getWord() {
        return words[rand.nextInt(words.length)];
    }
}
