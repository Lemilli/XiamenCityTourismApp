package com.example.finalmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

public class PlaceDetailsActivity extends AppCompatActivity {
    private MaterialButton gotoBtn, saveBtn;
    private ExtendedFloatingActionButton back_btn;
    private TextView tv_name, tv_type, tv_address, tv_description;
    private RatingBar ratingBar;
    private ImageView imageView;
    private double lat, lng;
    private boolean isSaved;
    private DatabaseHelper db;
    private String name, type, address, description;
    private Integer imageUrl;
    private float rating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_details);

        getSupportActionBar().hide();

        gotoBtn = findViewById(R.id.goto_place);
        back_btn = findViewById(R.id.back_btn);
        tv_name = findViewById(R.id.recommended_place_name);
        tv_type = findViewById(R.id.details_place_type);
        tv_address = findViewById(R.id.address);
        tv_description = findViewById(R.id.place_description);
        ratingBar = findViewById(R.id.rating);
        imageView = findViewById(R.id.imageView3);
        saveBtn = findViewById(R.id.save_place);

        db = new DatabaseHelper(this);

        // Read Passed data and show it
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            name = extras.getString("name");
            type = extras.getString("type");
            lat = extras.getDouble("lat");
            lng = extras.getDouble("lng");
            rating = extras.getFloat("rating");
            imageUrl = extras.getInt("imageUrl");
            address = extras.getString("address");
            description = extras.getString("description");

            tv_name.setText(name);
            tv_type.setText(type);
            tv_address.setText(address);
            tv_description.setText(description);
            ratingBar.setRating(rating);
            imageView.setImageResource(imageUrl);
        }

        isSaved = db.isSavedPlace(name);

        gotoBtn.setOnClickListener(view -> {
            String uri = "http://maps.google.com/maps?daddr=" + lat + "," + lng;
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
            startActivity(intent);
        });

        // Navigate back to previous activity
        back_btn.setOnClickListener(view -> {
            finish();
        });

        UpdateSaveButtonUI();

        saveBtn.setOnClickListener(view -> {
            isSaved = !isSaved;
            if (isSaved)
                db.savePlace(name, type, lat, lng, rating, imageUrl, address, description, false);
            else
                db.deleteSavedPlace(name);

            UpdateSaveButtonUI();
        });
    }

    void UpdateSaveButtonUI() {
        if (isSaved) {
            saveBtn.setText("Delete from Saved");
            saveBtn.setBackgroundColor(getResources().getColor(R.color.red));
        } else {
            saveBtn.setText("Save");
            saveBtn.setBackgroundColor(getResources().getColor(R.color.blue));
        }
    }
}