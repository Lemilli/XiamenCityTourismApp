package com.example.finalmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.finalmobile.DataModels.PlaceData;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class PlaceDetailsActivity extends AppCompatActivity {
    private MaterialButton btn;
    private ExtendedFloatingActionButton back_btn;
    private TextView tv_name, tv_type, tv_address, tv_description;
    private RatingBar ratingBar;
    private ImageView imageView;
    private double lat, lng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_details);

        getSupportActionBar().hide();

        btn = findViewById(R.id.goto_place);
        back_btn = findViewById(R.id.back_btn);
        tv_name = findViewById(R.id.recommended_place_name);
        tv_type = findViewById(R.id.details_place_type);
        tv_address = findViewById(R.id.address);
        tv_description = findViewById(R.id.place_description);
        ratingBar = findViewById(R.id.rating);
        imageView = findViewById(R.id.imageView3);

        // Read Passed data and show it
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String name = extras.getString("name");
            String type = extras.getString("type");
            lat = extras.getDouble("lat");
            lng = extras.getDouble("lng");
            float rating = extras.getFloat("rating");
            Integer imageUrl = extras.getInt("imageUrl");
            String address = extras.getString("address");
            String description = extras.getString("description");

            tv_name.setText(name);
            tv_type.setText(type);
            tv_address.setText(address);
            tv_description.setText(description);
            ratingBar.setRating(rating);
            imageView.setImageResource(imageUrl);
        }

        btn.setOnClickListener(view -> {
            String uri = "http://maps.google.com/maps?daddr=" + lat + "," + lng;
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
            startActivity(intent);
        });

        // Navigate back to previous activity
        back_btn.setOnClickListener(view -> {
            finish();
        });
    }
}