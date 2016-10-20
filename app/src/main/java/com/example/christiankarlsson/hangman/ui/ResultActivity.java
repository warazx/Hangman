package com.example.christiankarlsson.hangman.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.christiankarlsson.hangman.R;

public class ResultActivity extends AppCompatActivity {

    private TextView secretWord;
    private ImageView hangImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        secretWord = (TextView) findViewById(R.id.secret_word_text);
        secretWord.setText(getIntent().getExtras().getString("SECRET_WORD"));

        hangImage = (ImageView) findViewById(R.id.hang_img);
    }

    public void returnToMenu(View view) {
        Intent intent = new Intent (this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}
