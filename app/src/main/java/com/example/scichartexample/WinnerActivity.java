package com.example.scichartexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class WinnerActivity extends AppCompatActivity {
    private static final String TAG = "MainTagName";
    private TextView winnerText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winner);
        winnerText = findViewById(R.id.winnerText);
        Intent intent = getIntent();
        int data = intent.getIntExtra("data", -1);
        Log.d(TAG, data + "");
        if (data == 1)
            winnerText.setText("Cross win");
        if (data == 0)
            winnerText.setText("Zero win");
        if (data == 2)
            winnerText.setText("No win");
    }
}