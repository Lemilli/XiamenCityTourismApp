package com.example.finalmobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.finalmobile.Adapters.PlacesAdapter;
import com.example.finalmobile.DataModels.HotelData;
import com.example.finalmobile.DataModels.PlaceData;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;

public class PlacesActivity extends AppCompatActivity {
    private MaterialButton btn;
    private RecyclerView rv;
    private ArrayList<PlaceData> places = new ArrayList<PlaceData>();
    private PlacesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places);

        getSupportActionBar().hide();

        rv = findViewById(R.id.rv_places);
        btn = findViewById(R.id.recommended_read_more);

        places.add(new PlaceData("Gulangyu Island", "Landmark", 24.446550999573216, 118.06623184355593, 4.5f, R.drawable.gulangyu, "Siming District, Xiamen, China", "Gulangyu is directly off the southeastern coast of China, and the quaint tourist attraction is part of the bustling city of Xiamen. The island is famous for its natural beauty, colonial style architecture and a myriad of interesting museums.\n" +
                "\n" +
                "Besides the island's historic significance as an international port, Gulangyu is a great place to escape from city traffic and highrise, though Xiamen has consistently been voted as one of the most livable cities in China, and Gulangyu Island has been recognized as one of Fujian Province's most scenic places.\n" +
                "\n" +
                "Here are some of the attractions that make the islet so popular with natives and international visitors, as well as some important information for making one's island adventure enjoyable."));
        places.add(new PlaceData("Bailuzhou Park", "Park", 24.472884934238202, 118.0890941169133, 4.0f, R.drawable.bailuzhou, "Si Ming Qu, Xia Men Shi", "Bailuzhou Park is also known as the Xiamen Open Square Park. The park has a great environment and is especially good for peaceful and quiet walks." +
                "\n" +
                "You will find the park is divided into Central Park and West Park. In the West Park you will be able to find plenty of music options in the form of fountain squares and plazas. There is also a statue of the egret goddess located in the park. You will be able to find the statue at the south side of the park at the yacht dock. The statue consists of the goddess sitting on a rock as she combs her long beautiful hair. As she combs her hair she allows us to see her in all her beauty while carrying a small egret on her shoulders. The sculpture is a symbol of Xiamen."));
        adapter = new PlacesAdapter(PlacesActivity.this, places);
        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(PlacesActivity.this));

        btn.setOnClickListener(view -> {
            Intent intent = new Intent(PlacesActivity.this, PlaceDetailsActivity.class);
            startActivity(intent);
        });
    }
}