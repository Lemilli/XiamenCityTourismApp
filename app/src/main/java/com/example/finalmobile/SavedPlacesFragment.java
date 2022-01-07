package com.example.finalmobile;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.finalmobile.Adapters.PlacesAdapter;
import com.example.finalmobile.Adapters.SavedPlacesAdapter;
import com.example.finalmobile.DataModels.PlaceData;
import com.google.android.material.switchmaterial.SwitchMaterial;

import java.util.ArrayList;

public class SavedPlacesFragment extends Fragment {
    private RecyclerView rv;
    private ArrayList<PlaceData> places = new ArrayList<PlaceData>();
    private SavedPlacesAdapter adapter;
    private DatabaseHelper db;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_explore, container, false);
        rv = v.findViewById(R.id.rv_saved_places);

        db = new DatabaseHelper(getActivity());
        places = db.getAllSavedPlaces();

        adapter = new SavedPlacesAdapter(getActivity(), places);
        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));

        return v;
    }
}