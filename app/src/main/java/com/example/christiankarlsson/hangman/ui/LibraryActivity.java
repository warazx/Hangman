package com.example.christiankarlsson.hangman.ui;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ArrayAdapter;

import com.example.christiankarlsson.hangman.R;
import com.example.christiankarlsson.hangman.model.GenerateRandomWord;

public class LibraryActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        String[] allWords = GenerateRandomWord.getAll();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, allWords);
        setListAdapter(adapter);
    }
}
