package com.example.christiankarlsson.hangman.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.christiankarlsson.hangman.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actionbar_main_menu, menu);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setTitle(getString((R.string.menu_main_title)));
        return true;
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

    public void startGame(View view) {
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    }

    public void aboutApp(View view) {
        Intent intent = new Intent(this, AboutActivity.class);
        startActivity(intent);
    }

    public void showLibrary(View view) {
        Intent intent = new Intent(this, LibraryActivity.class);
        startActivity(intent);
    }

}
