package com.example.timekiller;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class TicTacToe extends AppCompatActivity {
    Button button1, button2, button3, button4, button5, button6, button7, button8, button9;
    String krestik, nolik;
    TextView textView, humanPoints, computerPoints, restart;
    int humanPointsCounter, computerPointsCounter;
    MediaPlayer backgroundMusic, buttonClickSound;
    private boolean isMediaPlayerPrepared = false;
    int tintGreen, tintGrey, tintRed;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tic_tac_toe);
        krestik = "X";
        nolik = "O";
        textView = findViewById(R.id.textView);
        textView.setText("");
        restart = findViewById(R.id.restart);
        backgroundMusic = MediaPlayer.create(TicTacToe.this, R.raw.background_music);
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
        buttonClickSound = MediaPlayer.create(TicTacToe.this, R.raw.click1);
        backgroundMusic.start();
        sharedPreferences = this.getSharedPreferences("score_solo", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        humanPoints = findViewById(R.id.HumanPointsCounter);
        computerPoints = findViewById(R.id.ComputerPointsCounter);
        humanPointsCounter = sharedPreferences.getInt("humanPointsCounter", 0);
        humanPoints.setText("" + humanPointsCounter);
        computerPointsCounter = sharedPreferences.getInt("computerPointsCounter", 0);
        computerPoints.setText("" + computerPointsCounter);
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
    }
    private void startMediaPlayer() {
        if (isMediaPlayerPrepared) {
            backgroundMusic.seekTo(0);
            backgroundMusic.start();
        }
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
    private void playButtonClickSound() {
        if (buttonClickSound.isPlaying()) {
            buttonClickSound.seekTo(0);
            buttonClickSound.pause();
        }
        buttonClickSound.start();
    }
    private void hodPC() {
        Random random = new Random();
        int clickPC = random.nextInt(9) + 1;
        Button[] buttons = {button1, button2, button3, button4, button5, button6, button7, button8, button9};
        Button currentButton = buttons[clickPC - 1];

        if (currentButton.getText().equals("")) {
            currentButton.setText(nolik);
            currentButton.setBackgroundResource(R.drawable.o_button_grey);
            isComputerWinner();
        } else {
            hodPC();
        }
    }

    public void onClickBtn(View view) {
        Button button = (Button) view;
        if (button.getText().equals("") && textView.getText().equals("")) {
            button.setText(krestik);
            button.setBackgroundResource(R.drawable.x_button_grey);
            isPlayerWinner();
            if (textView.getText().equals("")) {
                hodPC();
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
            textView.setText(R.string.winner_message);
            textView.setTextColor(tintGreen);
            restart.setTextColor(tintGreen);
            humanPointsCounter++;
            humanPoints.setText("" + humanPointsCounter);
            editor.putInt("humanPointsCounter", humanPointsCounter);
            editor.apply();
        } else if(button4.getText() == krestik && button5.getText() == krestik && button6.getText() == krestik){
            button4.setBackgroundResource(R.drawable.x_button_green);
            button5.setBackgroundResource(R.drawable.x_button_green);
            button6.setBackgroundResource(R.drawable.x_button_green);
            textView.setText(R.string.winner_message);
            textView.setTextColor(tintGreen);
            restart.setTextColor(tintGreen);
            humanPointsCounter++;
            humanPoints.setText("" + humanPointsCounter);
            editor.putInt("humanPointsCounter", humanPointsCounter);
            editor.apply();
        } else if(button7.getText() == krestik && button8.getText() == krestik && button9.getText() == krestik){
            button7.setBackgroundResource(R.drawable.x_button_green);
            button8.setBackgroundResource(R.drawable.x_button_green);
            button9.setBackgroundResource(R.drawable.x_button_green);
            textView.setText(R.string.winner_message);
            textView.setTextColor(tintGreen);
            restart.setTextColor(tintGreen);
            humanPointsCounter++;
            humanPoints.setText("" + humanPointsCounter);
            editor.putInt("humanPointsCounter", humanPointsCounter);
            editor.apply();
        } else if(button1.getText() == krestik && button4.getText() == krestik && button7.getText() == krestik){
            button1.setBackgroundResource(R.drawable.x_button_green);
            button4.setBackgroundResource(R.drawable.x_button_green);
            button7.setBackgroundResource(R.drawable.x_button_green);
            textView.setText(R.string.winner_message);
            textView.setTextColor(tintGreen);
            restart.setTextColor(tintGreen);
            humanPointsCounter++;
            humanPoints.setText("" + humanPointsCounter);
            editor.putInt("humanPointsCounter", humanPointsCounter);
            editor.apply();
        } else if(button2.getText() == krestik && button5.getText() == krestik && button8.getText() == krestik){
            button2.setBackgroundResource(R.drawable.x_button_green);
            button5.setBackgroundResource(R.drawable.x_button_green);
            button8.setBackgroundResource(R.drawable.x_button_green);
            textView.setTextColor(tintGreen);
            restart.setTextColor(tintGreen);
            textView.setText(R.string.winner_message);
            humanPointsCounter++;
            humanPoints.setText("" + humanPointsCounter);
            editor.putInt("humanPointsCounter", humanPointsCounter);
            editor.apply();
        } else if(button3.getText() == krestik && button6.getText() == krestik && button9.getText() == krestik){
            textView.setText(R.string.winner_message);
            button3.setBackgroundResource(R.drawable.x_button_green);
            button6.setBackgroundResource(R.drawable.x_button_green);
            button9.setBackgroundResource(R.drawable.x_button_green);
            textView.setTextColor(tintGreen);
            restart.setTextColor(tintGreen);
            humanPointsCounter++;
            humanPoints.setText("" + humanPointsCounter);
            editor.putInt("humanPointsCounter", humanPointsCounter);
            editor.apply();
        } else if(button1.getText() == krestik && button5.getText() == krestik && button9.getText() == krestik){
            textView.setText(R.string.winner_message);
            button1.setBackgroundResource(R.drawable.x_button_green);
            button5.setBackgroundResource(R.drawable.x_button_green);
            button9.setBackgroundResource(R.drawable.x_button_green);
            textView.setTextColor(tintGreen);
            restart.setTextColor(tintGreen);
            humanPointsCounter++;
            humanPoints.setText("" + humanPointsCounter);
            editor.putInt("humanPointsCounter", humanPointsCounter);
            editor.apply();
        } else if(button3.getText() == krestik && button5.getText() == krestik && button7.getText() == krestik){
            button3.setBackgroundResource(R.drawable.x_button_green);
            button5.setBackgroundResource(R.drawable.x_button_green);
            button7.setBackgroundResource(R.drawable.x_button_green);
            textView.setTextColor(tintGreen);
            textView.setText(R.string.winner_message);
            restart.setTextColor(tintGreen);
            humanPointsCounter++;
            humanPoints.setText("" + humanPointsCounter);
            editor.putInt("humanPointsCounter", humanPointsCounter);
            editor.apply();
        } else if(button1.getText() != "" && button2.getText() != "" && button3.getText() != "" &&
                button4.getText() != "" && button5.getText() != "" && button6.getText() != "" &&
                button7.getText() != "" && button8.getText() != "" && button9.getText() != "") {
            textView.setText(R.string.draw_message);
        }
    }
    public void isComputerWinner() {
        // 1 строка
        if(button1.getText() == nolik && button2.getText() == nolik && button3.getText() == nolik) {
            button1.setBackgroundResource(R.drawable.o_button_red);
            button2.setBackgroundResource(R.drawable.o_button_red);
            button3.setBackgroundResource(R.drawable.o_button_red);
            textView.setTextColor(tintRed);
            textView.setText(R.string.looser_message);
            restart.setTextColor(tintRed);
            computerPointsCounter++;
            computerPoints.setText("" + computerPointsCounter);
            editor.putInt("computerPointsCounter", computerPointsCounter);
            editor.apply();
        } else if(button4.getText() == nolik && button5.getText() == nolik && button6.getText() == nolik) {
            button4.setBackgroundResource(R.drawable.o_button_red);
            button5.setBackgroundResource(R.drawable.o_button_red);
            button6.setBackgroundResource(R.drawable.o_button_red);
            textView.setText(R.string.looser_message);
            textView.setTextColor(tintRed);
            restart.setTextColor(tintRed);
            computerPointsCounter++;
            computerPoints.setText("" + computerPointsCounter);
            editor.putInt("computerPointsCounter", computerPointsCounter);
            editor.apply();
        } else if(button7.getText() == nolik && button8.getText() == nolik && button9.getText() == nolik) {
            button7.setBackgroundResource(R.drawable.o_button_red);
            button8.setBackgroundResource(R.drawable.o_button_red);
            button9.setBackgroundResource(R.drawable.o_button_red);
            textView.setText(R.string.looser_message);
            textView.setTextColor(tintRed);
            restart.setTextColor(tintRed);
            computerPointsCounter++;
            computerPoints.setText("" + computerPointsCounter);
            editor.putInt("computerPointsCounter", computerPointsCounter);
            editor.apply();
        } else if(button1.getText() == nolik && button4.getText() == nolik && button7.getText() == nolik) {
            button1.setBackgroundResource(R.drawable.o_button_red);
            button4.setBackgroundResource(R.drawable.o_button_red);
            button7.setBackgroundResource(R.drawable.o_button_red);
            textView.setText(R.string.looser_message);
            textView.setTextColor(tintRed);
            restart.setTextColor(tintRed);
            computerPointsCounter++;
            computerPoints.setText("" + computerPointsCounter);
            editor.putInt("computerPointsCounter", computerPointsCounter);
            editor.apply();
        } else if(button2.getText() == nolik && button5.getText() == nolik && button8.getText() == nolik) {
            button2.setBackgroundResource(R.drawable.o_button_red);
            button5.setBackgroundResource(R.drawable.o_button_red);
            button8.setBackgroundResource(R.drawable.o_button_red);
            textView.setText(R.string.looser_message);
            textView.setTextColor(tintRed);
            restart.setTextColor(tintRed);
            computerPointsCounter++;
            computerPoints.setText("" + computerPointsCounter);
            editor.putInt("computerPointsCounter", computerPointsCounter);
            editor.apply();
        } else if(button3.getText() == nolik && button6.getText() == nolik && button9.getText() == nolik) {
            button3.setBackgroundResource(R.drawable.o_button_red);
            button6.setBackgroundResource(R.drawable.o_button_red);
            button9.setBackgroundResource(R.drawable.o_button_red);
            textView.setText(R.string.looser_message);
            textView.setTextColor(tintRed);
            restart.setTextColor(tintRed);
            computerPointsCounter++;
            computerPoints.setText("" + computerPointsCounter);
            editor.putInt("computerPointsCounter", computerPointsCounter);
            editor.apply();
        } else if(button1.getText() == nolik && button5.getText() == nolik && button9.getText() == nolik) {
            button1.setBackgroundResource(R.drawable.o_button_red);
            button5.setBackgroundResource(R.drawable.o_button_red);
            button9.setBackgroundResource(R.drawable.o_button_red);
            textView.setText(R.string.looser_message);
            textView.setTextColor(tintRed);
            restart.setTextColor(tintRed);
            computerPointsCounter++;
            computerPoints.setText("" + computerPointsCounter);
            editor.putInt("computerPointsCounter", computerPointsCounter);
            editor.apply();
        } else if(button3.getText() == nolik && button5.getText() == nolik && button7.getText() == nolik) {
            button3.setBackgroundResource(R.drawable.o_button_red);
            button5.setBackgroundResource(R.drawable.o_button_red);
            button7.setBackgroundResource(R.drawable.o_button_red);
            textView.setText(R.string.looser_message);
            textView.setTextColor(tintRed);
            restart.setTextColor(tintRed);
            computerPointsCounter++;
            computerPoints.setText("" + computerPointsCounter);
            editor.putInt("computerPointsCounter", computerPointsCounter);
            editor.apply();
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

    }
    public void onBackPressed(View view) {
        startActivity(new Intent(TicTacToe.this, MainActivity.class));
        finish();
    }
}