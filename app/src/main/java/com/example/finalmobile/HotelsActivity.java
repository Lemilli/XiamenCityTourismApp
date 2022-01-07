package com.example.finalmobile;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalmobile.Adapters.HotelsAdapter;
import com.example.finalmobile.DataModels.HotelData;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;

public class HotelsActivity extends AppCompatActivity {
    private MaterialButton btn;
    private RecyclerView rv;
    private ArrayList<HotelData> hotels = new ArrayList<HotelData>();
    private HotelsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotels);

        getSupportActionBar().hide();

        rv = findViewById(R.id.rv_places);
        btn = findViewById(R.id.recommended_read_more);

        hotels.add(new HotelData("Marco Polo", 68, 24.475252349786373, 118.0844843957495, 4.5f, R.drawable.marco_polo, "8 Jianye Road, Hubin Bei, Siming, 361012", "Located near the famous Coffee Street, Marco Polo Xiamen is a 20-minute drive to Xiamen International Airport and also close to the business district. The hotel offers accommodations with sweeping views of the Yuandang Lake and the white egret protection zone.\n" +
                "\n" +
                "Marco Polo Xiamen is a 10-minute drive from Nanputuo Temple and Gulangyu Ferry Pier. Xiamen International Conference Center is 25 minutes' drive away and it is a 40-minute drive from Xiamen North Railway Station.\n" +
                "\n" +
                "Marco Polo Xiamen features 300 well-appointed rooms and suites, featuring modern interiors and large bay windows. All rooms at the property are fitted with a TV, electric kettle, wardrobe and seating area. The private bathroom includes a bathtub and shower.\n" +
                "\n" +
                "The hotel features a recreation complex with an outdoor swimming pool, a fitness center, sauna, billiards and kids club. It also has a Marco Polo ballroom and 9 meeting rooms, which can cater to various events and guests’ needs.\n" +
                "\n" +
                "There are 9 dining outlets at the property, providing a wide selection of global cuisine.", true, true, true));
        hotels.add(new HotelData("Pan Pacific", 84, 24.478392206756684, 118.08238172639216, 4.2f, R.drawable.pan_pacific, "19 Hubin Bei Road (near Jianye Road metro station), Siming, 361012", "Located in the central business district of Xiamen, Pan Pacific provides luxury accommodations with exclusive Pacific Lounge on the Club floor. With coffee and bar street nearby, the property has an outdoor pool. Jianye Road Metro Station on Line 2 is just 100 m away.\n" +
                "\n" +
                "Pan Pacific Xiamen is around a 10-minute walk from Gulangyu Island Ferry Terminal, a 20-minute drive from Gaoqi International Airport and 30-minute drive from Xiamen International Conference Center. Xiamen North Railway Station is a 40-minute car journey away.\n" +
                "\n" +
                "Rooms and suites at Xiamen Pan Pacific feature beautiful views of picturesque Yundang Lake, Gulf Park, Gulangyu Island and South Putuo Temple. Each room is equipped with a cable TV, mini-bar and safety deposit box.\n" +
                "\n" +
                "Treat yourself to a relaxing massage, or work out at the gym. The hotel offers laundry and airport shuttle service, along with in-car WiFi.\n" +
                "\n" +
                "Enjoy international dishes in a poolside terrace setting at Cesar’s on 3 Restaurant, which has an open kitchen concept. For fine dining, sample the Cantonese specialties at Hai Tien Lo Restaurant.", true, true, false));
        hotels.add(new HotelData("Hilton", 89, 24.490665844662363, 118.11925277766666, 4.6f, R.drawable.hilton, "No.199 Jiahe Road, Siming, 361012", "Hilton Xiamen is located right adjacent to Paragon Complex where you could shop for luxury brands, watch a film, or try international cuisine at a nearby restaurant. It has 8,000-square-yard beautifully landscaped garden with natural lawn and a private jogging track. 2 restaurants and 1 bar accompanied with spa, swimming pool and fitness center provide a variety of leisure options.\n" +
                "\n" +
                "Hilton Xiamen is only a 8-minute drive from Xiamen Railway Station, and a 20-minute drive from Xiamen Airport, Nanputuo Temple, Xiamen University, Gulangyu Island and Xiang'an tunnel. Xiamen North Railway Station is a 40-minute drive away.\n" +
                "\n" +
                "Modern air-conditioned rooms are equipped with a mini-bar, laptop safe box and a sofa. Bathrooms have a bathtub and hairdryer.\n" +
                "\n" +
                "Guests can work at the business center, or relax at the sauna and steam rooms. The hotel also provides car rentals, laundry and dry cleaning services.\n" +
                "\n" +
                "Above Cafe serves international buffet spreads on the 4th floor, while Yue Yuan Chinese Restaurant offers Chinese delicacies. After meals, you may choose to unwind with a drink at Royal Bar.", true, true, false));

        btn.setOnClickListener(view -> {
            Intent intent = new Intent(HotelsActivity.this, HotelDetailsActivity.class);
            intent.putExtra("name", "Swiss Grand Xiamen");
            intent.putExtra("price", 102);
            intent.putExtra("lat", 24.446550999573216);
            intent.putExtra("lng", 118.06623184355593);
            intent.putExtra("rating", 4.6f);
            intent.putExtra("imageUrl", R.drawable.swiss);
            intent.putExtra("address", "8 Jianye Road, Hubin Bei, Siming, 361012");
            intent.putExtra("description", "Located near the famous Coffee Street, Marco Polo Xiamen is a 20-minute drive to Xiamen International Airport and also close to the business district. The hotel offers accommodations with sweeping views of the Yuandang Lake and the white egret protection zone.\n\nMarco Polo Xiamen is a 10-minute drive from Nanputuo Temple and Gulangyu Ferry Pier. Xiamen International Conference Center is 25 minutes' drive away and it is a 40-minute drive from Xiamen North Railway Station.\n\nMarco Polo Xiamen features 300 well-appointed rooms and suites, featuring modern interiors and large bay windows. All rooms at the property are fitted with a TV, electric kettle, wardrobe and seating area. The private bathroom includes a bathtub and shower.\n\nThe hotel features a recreation complex with an outdoor swimming pool, a fitness center, sauna, billiards and kids club. It also has a Marco Polo ballroom and 9 meeting rooms, which can cater to various events and guests’ needs.\n\nThere are 9 dining outlets at the property, providing a wide selection of global cuisine.");
            intent.putExtra("hasPool", true);
            intent.putExtra("hasWifi", true);
            intent.putExtra("hasFitness", true);
            startActivity(intent);
        });

        adapter = new HotelsAdapter(HotelsActivity.this, hotels);
        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(HotelsActivity.this));
    }
}