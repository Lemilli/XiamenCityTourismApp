package com.example.finalmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

public class HotelDetailsActivity extends AppCompatActivity {
    private MaterialButton gotoBtn;
    private ExtendedFloatingActionButton back_btn;
    private TextView tv_pool, tv_wifi, tv_fitness, tv_name, tv_price, tv_address, tv_description;
    private RatingBar ratingBar;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_details);

        getSupportActionBar().hide();

        gotoBtn = findViewById(R.id.goto_place);
        back_btn = findViewById(R.id.back_btn);
        tv_pool = findViewById(R.id.pool);
        tv_wifi = findViewById(R.id.wifi);
        tv_fitness = findViewById(R.id.fitness);
        tv_name = findViewById(R.id.details_hotel_name);
        tv_price = findViewById(R.id.pricing);
        tv_address = findViewById(R.id.address);
        tv_description = findViewById(R.id.details_hotel_description);
        ratingBar = findViewById(R.id.rating);
        imageView = findViewById(R.id.imageView3);


        // Read Passed data and show it
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
           String name = extras.getString("name");
           Integer price = extras.getInt("price");
           Double lat = extras.getDouble("lat");
           Double lng = extras.getDouble("lng");
           float rating = extras.getFloat("rating");
           Integer imageUrl = extras.getInt("imageUrl");
           String address = extras.getString("address");
           String description = extras.getString("description");
           boolean hasPool = extras.getBoolean("hasPool");
           boolean hasWifi = extras.getBoolean("hasWifi");
           boolean hasFitness = extras.getBoolean("hasFitness");

            tv_name.setText(name);
            tv_price.setText(price.toString());
            tv_address.setText(address);
            tv_description.setText(description);
            ratingBar.setRating(rating);
            imageView.setBackgroundResource(imageUrl);

            if(!hasPool)
                tv_pool.setTextColor(getResources().getColor(R.color.grey));
            if(!hasWifi)
                tv_wifi.setTextColor(getResources().getColor(R.color.grey));
            if(!hasFitness)
                tv_fitness.setTextColor(getResources().getColor(R.color.grey));


            gotoBtn.setOnClickListener(view -> {
                String uri = "http://maps.google.com/maps?daddr=" + lat + "," + lng;
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent);
            });
        }

        // Navigate back to previous activity
        back_btn.setOnClickListener(view -> {
            finish();
        });
    }
}