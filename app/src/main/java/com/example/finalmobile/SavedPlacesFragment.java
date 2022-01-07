package com.example.finalmobile;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.finalmobile.Adapters.SavedPlacesAdapter;
import com.example.finalmobile.DataModels.PlaceData;

import java.util.ArrayList;

public class SavedPlacesFragment extends Fragment {
    private RecyclerView rv;
    private ArrayList<PlaceData> places = new ArrayList<PlaceData>();
    private SavedPlacesAdapter adapter;
    private DatabaseHelper db;
    private TextView tv_nothing_saved;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_saved_places, container, false);
        rv = v.findViewById(R.id.rv_saved_places);
        tv_nothing_saved = v.findViewById(R.id.tv_nothing_saved);

        db = new DatabaseHelper(getActivity());
        places = db.getAllSavedPlaces();

        if(places.size() <= 0){
            tv_nothing_saved.setVisibility(View.VISIBLE);
        }

        adapter = new SavedPlacesAdapter(getActivity(), places);
        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));

        return v;
    }
}