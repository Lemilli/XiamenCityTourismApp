package com.example.finalmobile;

import android.content.Intent;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class HomeFragment extends Fragment {

//    public HomeFragment() {
//        // Required empty public constructor
//    }
//
//    public static HomeFragment newInstance(String param1, String param2) {
//        HomeFragment fragment = new HomeFragment();
//        Bundle args = new Bundle();
//        fragment.setArguments(args);
//        return fragment;
//    }

    ConstraintLayout food, places, hotels;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home, container, false);

        food = v.findViewById(R.id.constraint_food);
        places = v.findViewById(R.id.constraint_places);
        hotels = v.findViewById(R.id.constraint_hotels);

        food.setOnClickListener(view -> {
            Intent intent = new Intent(getActivity(), RestaurantsActivity.class);
            startActivity(intent);
        });

        places.setOnClickListener(view -> {
            Intent intent = new Intent(getActivity(), PlacesActivity.class);
            startActivity(intent);
        });

        hotels.setOnClickListener(view -> {
            Intent intent = new Intent(getActivity(), HotelsActivity.class);
            startActivity(intent);
        });

        return v;
    }
}