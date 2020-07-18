package com.example.rank_scanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import java.util.Objects;

import static android.os.SystemClock.sleep;

public class logoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo);
        Objects.requireNonNull(getSupportActionBar()).hide();
        Thread thread= new Thread(new Runnable() {
            @Override
            public void run() {
                sleep(1500);
                Intent i = new Intent(logoActivity.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        });
        thread.start();
    }
}