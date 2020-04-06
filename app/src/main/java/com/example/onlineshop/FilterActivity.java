package com.example.onlineshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class FilterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.meniu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.Home:
                openHomeMenu();
                return true;
            case R.id.About:
                openAboutMenu();
                return true;
            case R.id.Help:
                openHelpMenu();
                return true;
            case R.id.Settings:
                openSettingsMenu();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void openAboutMenu() {
        Intent intent = new Intent(this, AboutActivity.class);
        startActivity(intent);
    }

    public void openHomeMenu() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void openHelpMenu() {
        Intent intent = new Intent(this, HelpActivity.class);
        startActivity(intent);
    }

    public void openSettingsMenu() {
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }

}
