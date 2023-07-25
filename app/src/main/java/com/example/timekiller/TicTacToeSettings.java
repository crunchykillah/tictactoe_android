package com.example.timekiller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class TicTacToeSettings extends AppCompatActivity {
    Button button1, button2;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    SharedPreferences sharedPreferencesDuo;
    SharedPreferences.Editor editorDuo;
    MediaPlayer buttonClickSound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        button1 = findViewById(R.id.reset_button1);
        button1 = findViewById(R.id.reset_button2);
        buttonClickSound = MediaPlayer.create(TicTacToeSettings.this, R.raw.click1);
        setContentView(R.layout.activity_tic_tac_toe_settings);
        sharedPreferencesDuo = this.getSharedPreferences("score_duo", Context.MODE_PRIVATE);
        editorDuo = sharedPreferencesDuo.edit();
        sharedPreferences = this.getSharedPreferences("score_solo", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }
    private void playButtonClickSound() {
        if (buttonClickSound.isPlaying()) {
            buttonClickSound.seekTo(0);
            buttonClickSound.pause();
        }
        buttonClickSound.start();
    }
    public void resetFirst(View view) {
        playButtonClickSound();
        editor.putInt("humanPointsCounter", 0);
        editor.putInt("computerPointsCounter", 0);
        editor.apply();
        Toast.makeText(TicTacToeSettings.this,"reset completed", Toast.LENGTH_SHORT).show();
    }

    public void resetSecond(View view) {
        playButtonClickSound();
        editorDuo.putInt("firstPointsCounter", 0);
        editorDuo.putInt("secondPointsCounter", 0);
        editorDuo.apply();
        Toast.makeText(TicTacToeSettings.this,"reset completed", Toast.LENGTH_SHORT).show();
    }
}