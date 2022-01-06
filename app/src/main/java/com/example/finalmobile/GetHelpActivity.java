package com.example.finalmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class GetHelpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_help);

        getSupportActionBar().hide();
    }
}