package com.example.christiankarlsson.hangman.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.christiankarlsson.hangman.R;
import com.example.christiankarlsson.hangman.model.HangmanGame;

public class GameActivity extends AppCompatActivity {

    private EditText editText;
    private Button button;
    private HangmanGame hangmanGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        hangmanGame = new HangmanGame();

        editText = (EditText) findViewById(R.id.user_guess_text);
        button = (Button) findViewById(R.id.guess_button);
    }

    public void userGuess() {
    }
}
