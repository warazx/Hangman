package com.example.christiankarlsson.hangman.model;

import com.example.christiankarlsson.hangman.R;

public class GenerateHangImage {

    /**
     * Get the right image from for the number of guesses left.
     * @param guessesLeft the players numbers of guesses left.
     * @return id of the image.
     */
    public static int getImage(int guessesLeft) {
        switch (guessesLeft) {
            case 10:
                return R.drawable.hang10;
            case 9:
                return R.drawable.hang9;
            case 8:
                return R.drawable.hang8;
            case 7:
                return R.drawable.hang7;
            case 6:
                return R.drawable.hang6;
            case 5:
                return R.drawable.hang5;
            case 4:
                return R.drawable.hang4;
            case 3:
                return R.drawable.hang3;
            case 2:
                return R.drawable.hang2;
            case 1:
                return R.drawable.hang1;
            case 0:
                return R.drawable.hang0;
            default:
                return 0;
        }
    }
}
