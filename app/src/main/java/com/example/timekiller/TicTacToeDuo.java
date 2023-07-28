package com.example.timekiller;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TicTacToeDuo extends AppCompatActivity {
    Button button1, button2, button3, button4, button5, button6, button7, button8, button9;
    String krestik;
    String nolik;
    String click;
    TextView textView, firstPoints, secondPoints, restart;
    int firstPointsCounter, secondPointsCounter;
    int tintGreen, tintGrey, tintRed;
    MediaPlayer backgroundMusic, buttonClickSound;
    private boolean isMediaPlayerPrepared = false;
    SharedPreferences sharedPreferencesDuo;
    SharedPreferences.Editor editorDuo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tic_tac_toe_duo);
        krestik = "X";
        nolik = "O";
        click = nolik;
        textView = findViewById(R.id.textView);
        textView.setText("");
        restart = findViewById(R.id.restart);
        backgroundMusic = MediaPlayer.create(TicTacToeDuo.this, R.raw.background_music);
        backgroundMusic.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                isMediaPlayerPrepared = true;
                startMediaPlayer();
            }
        });
        backgroundMusic.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                startMediaPlayer();
            }
        });
        buttonClickSound = MediaPlayer.create(TicTacToeDuo.this, R.raw.click1);
        backgroundMusic.start();
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        tintGreen = getResources().getColor(R.color.green);
        tintGrey = getResources().getColor(R.color.grey);
        tintRed = getResources().getColor(R.color.red);
        sharedPreferencesDuo = this.getSharedPreferences("score_duo", Context.MODE_PRIVATE);
        editorDuo = sharedPreferencesDuo.edit();
        firstPoints = findViewById(R.id.HumanPointsCounter);
        secondPoints = findViewById(R.id.ComputerPointsCounter);
        firstPointsCounter = sharedPreferencesDuo.getInt("firstPointsCounter", 0);
        firstPoints.setText("" + firstPointsCounter);
        secondPointsCounter = sharedPreferencesDuo.getInt("secondPointsCounter", 0);
        secondPoints.setText("" + secondPointsCounter);

    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (backgroundMusic != null) {
            backgroundMusic.release();
            backgroundMusic = null;
        }
        if (buttonClickSound != null) {
            buttonClickSound.release();
            buttonClickSound = null;
        }
    }
    private void startMediaPlayer() {
        if (isMediaPlayerPrepared) {
            backgroundMusic.seekTo(0);
            backgroundMusic.start();
        }
    }
    private void playButtonClickSound() {
        if (buttonClickSound.isPlaying()) {
            buttonClickSound.seekTo(0);
            buttonClickSound.pause();
        }
        buttonClickSound.start();
    }
    public void onClickBtn(View view) {
        Button button = (Button) view;
        if (button.getText().equals("") && textView.getText().equals("")) {
            if (click == nolik) {
                button.setBackgroundResource(R.drawable.x_button_grey);
                button.setText(krestik);
                isPlayerWinner();
                click = krestik;
            } else if (click == krestik) {
                button.setBackgroundResource(R.drawable.o_button_grey);
                button.setText(nolik);
                isSecondPlayerWinner();
                click = nolik;
            }
        }
    }
    //Условия выигрыша
    @SuppressLint("ResourceAsColor")
    public void isPlayerWinner() {
        // 1 строка
        if(button1.getText() == krestik && button2.getText() == krestik && button3.getText() == krestik){
            button1.setBackgroundResource(R.drawable.x_button_green);
            button2.setBackgroundResource(R.drawable.x_button_green);
            button3.setBackgroundResource(R.drawable.x_button_green);
            textView.setText(R.string.first_player_win_message);
            textView.setTextColor(tintGreen);
            restart.setTextColor(tintGreen);
            firstPointsCounter++;
            firstPoints.setText("" + firstPointsCounter);
            editorDuo.putInt("firstPointsCounter", firstPointsCounter);
            editorDuo.apply();
        } else if(button4.getText() == krestik && button5.getText() == krestik && button6.getText() == krestik){
            button4.setBackgroundResource(R.drawable.x_button_green);
            button5.setBackgroundResource(R.drawable.x_button_green);
            button6.setBackgroundResource(R.drawable.x_button_green);
            textView.setText(R.string.first_player_win_message);
            textView.setTextColor(tintGreen);
            restart.setTextColor(tintGreen);
            firstPointsCounter++;
            firstPoints.setText("" + firstPointsCounter);
            editorDuo.putInt("firstPointsCounter", firstPointsCounter);
            editorDuo.apply();
        } else if(button7.getText() == krestik && button8.getText() == krestik && button9.getText() == krestik){
            button7.setBackgroundResource(R.drawable.x_button_green);
            button8.setBackgroundResource(R.drawable.x_button_green);
            button9.setBackgroundResource(R.drawable.x_button_green);
            textView.setText(R.string.first_player_win_message);
            textView.setTextColor(tintGreen);
            restart.setTextColor(tintGreen);
            firstPointsCounter++;
            firstPoints.setText("" + firstPointsCounter);
            editorDuo.putInt("firstPointsCounter", firstPointsCounter);
            editorDuo.apply();
        } else if(button1.getText() == krestik && button4.getText() == krestik && button7.getText() == krestik){
            button1.setBackgroundResource(R.drawable.x_button_green);
            button4.setBackgroundResource(R.drawable.x_button_green);
            button7.setBackgroundResource(R.drawable.x_button_green);
            textView.setText(R.string.first_player_win_message);
            textView.setTextColor(tintGreen);
            restart.setTextColor(tintGreen);
            firstPointsCounter++;
            firstPoints.setText("" + firstPointsCounter);
            editorDuo.putInt("firstPointsCounter", firstPointsCounter);
            editorDuo.apply();
        } else if(button2.getText() == krestik && button5.getText() == krestik && button8.getText() == krestik){
            button2.setBackgroundResource(R.drawable.x_button_green);
            button5.setBackgroundResource(R.drawable.x_button_green);
            button8.setBackgroundResource(R.drawable.x_button_green);
            restart.setTextColor(tintGreen);
            textView.setTextColor(tintGreen);
            textView.setText(R.string.first_player_win_message);
            firstPointsCounter++;
            firstPoints.setText("" + firstPointsCounter);
            editorDuo.putInt("firstPointsCounter", firstPointsCounter);
            editorDuo.apply();
        } else if(button3.getText() == krestik && button6.getText() == krestik && button9.getText() == krestik){
            textView.setText(R.string.first_player_win_message);
            button3.setBackgroundResource(R.drawable.x_button_green);
            button6.setBackgroundResource(R.drawable.x_button_green);
            button9.setBackgroundResource(R.drawable.x_button_green);
            restart.setTextColor(tintGreen);
            textView.setTextColor(tintGreen);
            firstPointsCounter++;
            firstPoints.setText("" + firstPointsCounter);
            editorDuo.putInt("firstPointsCounter", firstPointsCounter);
            editorDuo.apply();
        } else if(button1.getText() == krestik && button5.getText() == krestik && button9.getText() == krestik){
            textView.setText(R.string.first_player_win_message);
            button1.setBackgroundResource(R.drawable.x_button_green);
            button5.setBackgroundResource(R.drawable.x_button_green);
            button9.setBackgroundResource(R.drawable.x_button_green);
            restart.setTextColor(tintGreen);
            textView.setTextColor(tintGreen);
            firstPointsCounter++;
            firstPoints.setText("" + firstPointsCounter);
            editorDuo.putInt("firstPointsCounter", firstPointsCounter);
            editorDuo.apply();
        } else if(button3.getText() == krestik && button5.getText() == krestik && button7.getText() == krestik){
            button3.setBackgroundResource(R.drawable.x_button_green);
            button5.setBackgroundResource(R.drawable.x_button_green);
            button7.setBackgroundResource(R.drawable.x_button_green);
            restart.setTextColor(tintGreen);
            textView.setTextColor(tintGreen);
            textView.setText(R.string.first_player_win_message);
            firstPointsCounter++;
            firstPoints.setText("" + firstPointsCounter);
            editorDuo.putInt("firstPointsCounter", firstPointsCounter);
            editorDuo.apply();
        } else if(button1.getText() != "" && button2.getText() != "" && button3.getText() != "" &&
                button4.getText() != "" && button5.getText() != "" && button6.getText() != "" &&
                button7.getText() != "" && button8.getText() != "" && button9.getText() != "") {
            textView.setText(R.string.draw_message);
        }
    }
    public void isSecondPlayerWinner() {
        // 1 строка
        if (button1.getText() == nolik && button2.getText() == nolik && button3.getText() == nolik) {
            button1.setBackgroundResource(R.drawable.o_button_red);
            button2.setBackgroundResource(R.drawable.o_button_red);
            button3.setBackgroundResource(R.drawable.o_button_red);
            textView.setTextColor(tintRed);
            restart.setTextColor(tintRed);
            textView.setText(R.string.second_player_win_message);
            secondPointsCounter++;
            secondPoints.setText("" + secondPointsCounter);
            editorDuo.putInt("secondPointsCounter", secondPointsCounter);
            editorDuo.apply();
        } else if (button4.getText() == nolik && button5.getText() == nolik && button6.getText() == nolik) {
            button4.setBackgroundResource(R.drawable.o_button_red);
            button5.setBackgroundResource(R.drawable.o_button_red);
            button6.setBackgroundResource(R.drawable.o_button_red);
            textView.setText(R.string.second_player_win_message);
            restart.setTextColor(tintRed);
            textView.setTextColor(tintRed);
            secondPointsCounter++;
            secondPoints.setText("" + secondPointsCounter);
            editorDuo.putInt("secondPointsCounter", secondPointsCounter);
            editorDuo.apply();
        } else if (button7.getText() == nolik && button8.getText() == nolik && button9.getText() == nolik) {
            button7.setBackgroundResource(R.drawable.o_button_red);
            button8.setBackgroundResource(R.drawable.o_button_red);
            button9.setBackgroundResource(R.drawable.o_button_red);
            textView.setText(R.string.second_player_win_message);
            restart.setTextColor(tintRed);
            textView.setTextColor(tintRed);
            secondPointsCounter++;
            secondPoints.setText("" + secondPointsCounter);
            editorDuo.putInt("secondPointsCounter", secondPointsCounter);
            editorDuo.apply();
        } else if (button1.getText() == nolik && button4.getText() == nolik && button7.getText() == nolik) {
            button1.setBackgroundResource(R.drawable.o_button_red);
            button4.setBackgroundResource(R.drawable.o_button_red);
            button7.setBackgroundResource(R.drawable.o_button_red);
            textView.setText(R.string.second_player_win_message);
            restart.setTextColor(tintRed);
            textView.setTextColor(tintRed);
            secondPointsCounter++;
            secondPoints.setText("" + secondPointsCounter);
            editorDuo.putInt("secondPointsCounter", secondPointsCounter);
            editorDuo.apply();
        } else if (button2.getText() == nolik && button5.getText() == nolik && button8.getText() == nolik) {
            button2.setBackgroundResource(R.drawable.o_button_red);
            button5.setBackgroundResource(R.drawable.o_button_red);
            button8.setBackgroundResource(R.drawable.o_button_red);
            textView.setText(R.string.second_player_win_message);
            restart.setTextColor(tintRed);
            textView.setTextColor(tintRed);
            secondPointsCounter++;
            secondPoints.setText("" + secondPointsCounter);
            editorDuo.putInt("secondPointsCounter", secondPointsCounter);
            editorDuo.apply();
        } else if (button3.getText() == nolik && button6.getText() == nolik && button9.getText() == nolik) {
            button3.setBackgroundResource(R.drawable.o_button_red);
            button6.setBackgroundResource(R.drawable.o_button_red);
            button9.setBackgroundResource(R.drawable.o_button_red);
            textView.setText(R.string.second_player_win_message);
            textView.setTextColor(tintRed);
            restart.setTextColor(tintRed);
            secondPointsCounter++;
            secondPoints.setText("" + secondPointsCounter);
            editorDuo.putInt("secondPointsCounter", secondPointsCounter);
            editorDuo.apply();
        } else if (button1.getText() == nolik && button5.getText() == nolik && button9.getText() == nolik) {
            button1.setBackgroundResource(R.drawable.o_button_red);
            button5.setBackgroundResource(R.drawable.o_button_red);
            button9.setBackgroundResource(R.drawable.o_button_red);
            textView.setText(R.string.second_player_win_message);
            textView.setTextColor(tintRed);
            restart.setTextColor(tintRed);
            secondPointsCounter++;
            secondPoints.setText("" + secondPointsCounter);
            editorDuo.putInt("secondPointsCounter", secondPointsCounter);
            editorDuo.apply();
        } else if (button3.getText() == nolik && button5.getText() == nolik && button7.getText() == nolik) {
            button3.setBackgroundResource(R.drawable.o_button_red);
            button5.setBackgroundResource(R.drawable.o_button_red);
            button7.setBackgroundResource(R.drawable.o_button_red);
            textView.setText(R.string.second_player_win_message);
            restart.setTextColor(tintRed);
            textView.setTextColor(tintRed);
            secondPointsCounter++;
            secondPoints.setText("" + secondPointsCounter);
            editorDuo.putInt("secondPointsCounter", secondPointsCounter);
            editorDuo.apply();
        } else if (button1.getText() != "" && button2.getText() != "" && button3.getText() != "" &&
                button4.getText() != "" && button5.getText() != "" && button6.getText() != "" &&
                button7.getText() != "" && button8.getText() != "" && button9.getText() != "") {
            textView.setText(R.string.draw_message);
        }
    }
    public void clickRestart(View view) {
        button1.setBackgroundResource(R.drawable.button);
        button2.setBackgroundResource(R.drawable.button);
        button3.setBackgroundResource(R.drawable.button);
        button4.setBackgroundResource(R.drawable.button);
        button5.setBackgroundResource(R.drawable.button);
        button6.setBackgroundResource(R.drawable.button);
        button7.setBackgroundResource(R.drawable.button);
        button8.setBackgroundResource(R.drawable.button);
        button9.setBackgroundResource(R.drawable.button);
        restart.setTextColor(tintGrey);
        playButtonClickSound();
        button1.setText("");
        button2.setText("");
        button3.setText("");
        button4.setText("");
        button5.setText("");
        button6.setText("");
        button7.setText("");
        button8.setText("");
        button9.setText("");
        textView.setText("");
        click = nolik;

    }
    public void onBackPressed(View view) {
        backgroundMusic.stop();
        startActivity(new Intent(TicTacToeDuo.this, MainActivity.class));
        finish();
    }

}