package com.example.christiankarlsson.hangman.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.christiankarlsson.hangman.R;
import com.example.christiankarlsson.hangman.model.HangmanGame;

public class GameActivity extends AppCompatActivity {

    private EditText editText;
    private Button button;
    private TextView guessesLeftTextView;
    private TextView usedGuessesTextView;
    private HangmanGame hangmanGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        hangmanGame = new HangmanGame();

        editText = (EditText) findViewById(R.id.user_guess_text);
        button = (Button) findViewById(R.id.guess_button);
        guessesLeftTextView = (TextView) findViewById(R.id.guess_left_text);
        usedGuessesTextView = (TextView) findViewById(R.id.used_guesses_text);

        updateView();
    }

    private void updateView() {
        guessesLeftTextView.setText(hangmanGame.getGuessesLeft());
        usedGuessesTextView.setText(hangmanGame.getUsedGuesses());
    }

    public void userGuess() {
        char c = editText.getText().toString().charAt(0);

        if(hangmanGame.addUserGuesses(c)) {
            guessSuccess(c);
        } else {
            guessFailed(c);
        }
    }

    private void guessFailed(char c) {

    }

    private void guessSuccess(char c) {
    }
}
