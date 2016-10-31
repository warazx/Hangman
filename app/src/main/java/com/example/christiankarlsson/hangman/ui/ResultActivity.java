package com.example.christiankarlsson.hangman.ui;

import android.content.Intent;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.christiankarlsson.hangman.R;
import com.example.christiankarlsson.hangman.model.GenerateHangImage;
import com.example.christiankarlsson.hangman.model.HangmanGame;

public class ResultActivity extends AppCompatActivity {

    private TextView victoryText;
    private TextView secretWord;
    private ImageView hangImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Bundle data = getIntent().getExtras();
        HangmanGame hangmanGame = data.getParcelable("GAME_DATA");

        victoryText = (TextView) findViewById(R.id.victory_text);
        if(hangmanGame.getGuessesLeft() == 1) {
            victoryText.setText(getString(R.string.result_victory_text_1left));
        } else if(hangmanGame.getGuessesLeft() != 0) {
            victoryText.setText(getString(R.string.result_victory_text, hangmanGame.getGuessesLeft()));
        } else {
            victoryText.setText(getString(R.string.result_lose_text));
        }

        secretWord = (TextView) findViewById(R.id.secret_word_text);
        secretWord.setText(getString(R.string.result_secret_word_text, hangmanGame.getSecretWord()));

        hangImage = (ImageView) findViewById(R.id.hang_img);
        hangImage.setImageDrawable(ResourcesCompat.getDrawable(getResources(), GenerateHangImage.getImage(hangmanGame.getGuessesLeft()), null));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actionbar_main_menu, menu);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.menu_result_title);
        return true;
    }

    public void returnToMenu(View view) {
        goToStart();
    }

    @Override
    public void onBackPressed() {
        goToStart();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        Intent intent;
        switch (id) {
            case R.id.startgame_btn:
                intent = new Intent(this, GameActivity.class);
                break;
            case R.id.aboutgame_btn:
                intent = new Intent(this, AboutActivity.class);
                break;
            default:
                intent = new Intent(this, null);
        }
        startActivity(intent);
        return super.onOptionsItemSelected(item);
    }

    private void goToStart() {
        Intent intent = new Intent (this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}
