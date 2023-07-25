package com.example.timekiller;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class TicTacToeChoose extends AppCompatActivity {
    MediaPlayer buttonClickSound;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tictactoe_choose);
        buttonClickSound = MediaPlayer.create(TicTacToeChoose.this, R.raw.click1);
    }
    private void playButtonClickSound() {
        if (buttonClickSound.isPlaying()) {
            buttonClickSound.seekTo(0);
            buttonClickSound.pause();
        }
        buttonClickSound.start();
    }
    public void start_tictaktoe(View view) {
        Intent intent = new Intent(TicTacToeChoose.this, TicTacToe.class);
        playButtonClickSound();
        startActivity(intent);
        finish();
    }
    public void start_tictaktoe_duo(View view) {
        Intent intent = new Intent(TicTacToeChoose.this, TicTacToeDuo.class);
        playButtonClickSound();
        startActivity(intent);
        finish();
    }
    public void onBackPressed(View view) {
        Intent intentBackPress = new Intent(TicTacToeChoose.this, MainActivity.class);
        startActivity(intentBackPress);
        finish();
    }
}