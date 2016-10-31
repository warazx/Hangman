package com.example.christiankarlsson.hangman.ui;

import android.content.Intent;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.christiankarlsson.hangman.R;
import com.example.christiankarlsson.hangman.model.GenerateHangImage;
import com.example.christiankarlsson.hangman.model.HangmanGame;

public class GameActivity extends AppCompatActivity {

    public static final String GAME_DATA = "GAME_DATA";

    private EditText editText;
    private Button button;
    private TextView guessesLeftTextView;
    private TextView usedGuessesTextView;
    private TextView secretWordTextView;
    private ImageView hangImage;
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
        secretWordTextView = (TextView) findViewById(R.id.secret_word_text);
        hangImage = (ImageView) findViewById(R.id.hang_img);

        updateView();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actionbar_main_menu, menu);
        return true;
    }

    private void updateView() {
        guessesLeftTextView.setText(hangmanGame.getGuessesLeftAsString());
        usedGuessesTextView.setText(hangmanGame.getWrongGuesses());
        secretWordTextView.setText(hangmanGame.getFormattedMaskedSecretWord());
        hangImage.setImageDrawable(ResourcesCompat.getDrawable(getResources(), GenerateHangImage.getImage(hangmanGame.getGuessesLeft()), null));
    }

    public void userGuess(View view) {
        try {
            char c = editText.getText().toString().charAt(0);
            if(hangmanGame.addUserGuesses(c)) {
                if(hangmanGame.isGameOver()) {
                    Intent intent = new Intent(this, ResultActivity.class);
                    intent.putExtra(GAME_DATA, hangmanGame);
                    startActivity(intent);
                }
                updateView();
            } else {
                Toast.makeText(this, R.string.error_char_used_text, Toast.LENGTH_SHORT).show();
            }
            editText.setText("");
        } catch (Exception e) {
            Toast.makeText(this, R.string.error_fail_input_text, Toast.LENGTH_SHORT).show();
        }
    }


}
