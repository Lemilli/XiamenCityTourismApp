package com.example.finalmobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

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
    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places);

        getSupportActionBar().hide();

        rv = findViewById(R.id.rv_places);
        btn = findViewById(R.id.recommended_read_more);

        db = new DatabaseHelper(this);
//        InsertData(db);

        places = db.getAllPlaces();

        Log.i("TAGGGGGG", "" + places.size());

        adapter = new PlacesAdapter(PlacesActivity.this, places);
        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(PlacesActivity.this));

        btn.setOnClickListener(view -> {
            Intent intent = new Intent(PlacesActivity.this, PlaceDetailsActivity.class);
            intent.putExtra("name", "Nanputuo Temple");
            intent.putExtra("type", "Religious Site");
            intent.putExtra("lat", 24.446550999573216);
            intent.putExtra("lng", 118.06623184355593);
            intent.putExtra("rating", 4.0f);
            intent.putExtra("imageUrl", R.drawable.nanputuo);
            intent.putExtra("address", "Siming District, Xiamen, China");
            intent.putExtra("description", "Gulangyu is directly off the southeastern coast of China, and the quaint tourist attraction is part of the bustling city of Xiamen. The island is famous for its natural beauty, colonial style architecture and a myriad of interesting museums.\\n\\nBesides the island's historic significance as an international port, Gulangyu is a great place to escape from city traffic and highrise, though Xiamen has consistently been voted as one of the most livable cities in China, and Gulangyu Island has been recognized as one of Fujian Province's most scenic places.\\n\\nHere are some of the attractions that make the islet so popular with natives and international visitors, as well as some important information for making one's island adventure enjoyable.");
            startActivity(intent);
        });
    }

    void InsertData(DatabaseHelper db) {
        db.insertPlaceData("Gulangyu Island", "Landmark", 24.446550999573216, 118.06623184355593, 4.5f, R.drawable.gulangyu, "Siming District, Xiamen, China", "Gulangyu is directly off the southeastern coast of China, and the quaint tourist attraction is part of the bustling city of Xiamen. The island is famous for its natural beauty, colonial style architecture and a myriad of interesting museums.\n" +
                "\n" +
                "Besides the island's historic significance as an international port, Gulangyu is a great place to escape from city traffic and highrise, though Xiamen has consistently been voted as one of the most livable cities in China, and Gulangyu Island has been recognized as one of Fujian Province's most scenic places.\n" +
                "\n" +
                "Here are some of the attractions that make the islet so popular with natives and international visitors, as well as some important information for making one's island adventure enjoyable.", false);
        db.insertPlaceData("Bailuzhou Park", "Park", 24.472884934238202, 118.0890941169133, 4.0f, R.drawable.bailuzhou, "Si Ming Qu, Xia Men Shi", "Bailuzhou Park is also known as the Xiamen Open Square Park. The park has a great environment and is especially good for peaceful and quiet walks." +
                "\n" +
                "You will find the park is divided into Central Park and West Park. In the West Park you will be able to find plenty of music options in the form of fountain squares and plazas.\n\nThere is also a statue of the egret goddess located in the park. You will be able to find the statue at the south side of the park at the yacht dock. The statue consists of the goddess sitting on a rock as she combs her long beautiful hair. As she combs her hair she allows us to see her in all her beauty while carrying a small egret on her shoulders. The sculpture is a symbol of Xiamen.", false);
        db.insertPlaceData("Piano Museum", "Museum", 24.439652194379043, 118.06901926876682, 4.0f, R.drawable.piano_museum, "No.7 Ganghou Road, Siming District", "The Piano Museum is located on the Gulangyu Island in the Tide Viewing Tower of Shuzhuang Garden. The island is often known as the piano island simply because of the long-known popularity of pianos among the local people. This museum depicts the culture and history of pianos. Expert musicians, as well as uninitiated visitors, would be charmed by the beautiful pianos, the artistry involved in creating them, and the lovely music to come away more knowledgeable about the beauty and history of pianos.\n" +
                "\n" +
                "The museum exhibits more than 100 ancient pianos that are world-famous. The pianos have been collected from the Americas, Australia, Britain, Austria, and France. All pianos were collected by Hu Youyi, an overseas patriotic Chinese. He was born on Gulangyu Island.\n\nThe museum has a huge range of pianos and over 70 of them are from famous brands from all over the world.  All the pianos are more than 100 years old. \n" +
                "\n" +
                "The collection includes the popular Steinwat and Sons pianos which were made in the US during the beginning of the 19th century. The collection also includes the oldest and the biggest vertical piano, the tallest upright piano in the world made by Broadward and Sons, and many more. Exploring the world of pianos, you can listen to beautiful old melodies and also get the unique opportunity to play music on these old, precious musical instruments.", false);
    }
}