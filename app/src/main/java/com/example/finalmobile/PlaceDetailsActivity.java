package com.example.finalmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class PlaceDetailsActivity extends AppCompatActivity {
    MaterialButton btn;
    ExtendedFloatingActionButton back_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_details);

        getSupportActionBar().hide();

        btn = findViewById(R.id.goto_place);
        back_btn = findViewById(R.id.back_btn);

        btn.setOnClickListener(view -> {
            String uri = "http://maps.google.com/maps?daddr=" + 24.47438157514786 + "," + 118.09239228591898;
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
            startActivity(intent);
        });
        back_btn.setOnClickListener(view -> {
            // TODO: NAVIGATE BACK
        });
    }
}