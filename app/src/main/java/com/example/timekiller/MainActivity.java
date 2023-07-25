package com.example.timekiller;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.core.view.WindowCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.timekiller.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView imageGame_01;
    ImageView imageGame_02;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageGame_01 = findViewById(R.id.tictac_icon);
    }

    public void tictactoe_choose(View view) {
        Intent intent = new Intent(MainActivity.this, TicTacToeChoose.class);
        startActivity(intent);
    }

    public void clickSettings(View view) {
        Intent intent = new Intent(MainActivity.this, TicTacToeSettings.class);
        startActivity(intent);

    }
}