package com.example.finalmobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageButton;

import com.example.finalmobile.Adapters.RestaurantsAdapter;
import com.example.finalmobile.DataModels.RestaurantData;

import java.util.ArrayList;

public class RestaurantsActivity extends AppCompatActivity {
    private ImageButton btnShuyou;
    private RecyclerView rv;
    private RestaurantsAdapter adapter;

    private ArrayList<RestaurantData> restaurants = new ArrayList<RestaurantData>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants);

        getSupportActionBar().hide();

        restaurants.add(new RestaurantData("McDonald's", "Fast Food", 24.43808607832482, 118.0931335231255, 4.0f, R.drawable.mcdonalds));
        restaurants.add(new RestaurantData("Jiawei Zaitian", "Snack Bar", 24.45775322925288, 118.07676415834459, 4.4f, R.drawable.jiawei));
        restaurants.add(new RestaurantData("Chaofucheng", "Chinese Food", 24.460018944805206, 118.07127099451013, 4.8f, R.drawable.chaofucheng));
        restaurants.add(new RestaurantData("Jiali ", "Seafood", 24.477171932929373, 118.11950765712258, 4.2f, R.drawable.jiali));

        btnShuyou = findViewById(R.id.btnShuyou);
        rv = findViewById(R.id.rv_restaurants);

        btnShuyou.setOnClickListener(view -> {
            String uri = "http://maps.google.com/maps?daddr=" + 24.47438157514786 + "," + 118.09239228591898;
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
            startActivity(intent);
        });

        adapter = new RestaurantsAdapter(RestaurantsActivity.this, restaurants);
        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(RestaurantsActivity.this));
    }
}