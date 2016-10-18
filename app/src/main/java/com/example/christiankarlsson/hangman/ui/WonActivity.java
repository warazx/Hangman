package com.example.christiankarlsson.hangman.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.christiankarlsson.hangman.R;

public class WonActivity extends AppCompatActivity {

    private TextView secretWord;
    private ImageView hangImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_won);

        secretWord = (TextView) findViewById(R.id.secret_word_text);
        secretWord.setText(getIntent().getExtras().getString("SECRET_WORD"));

        hangImage = (ImageView) findViewById(R.id.hang_img);
    }
}
