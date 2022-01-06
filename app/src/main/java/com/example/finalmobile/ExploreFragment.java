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

public class ExploreFragment extends Fragment {
    private RecyclerView rv;
    private ArrayList<PlaceData> places = new ArrayList<PlaceData>();
    private SavedPlacesAdapter adapter;

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

        places.add(new PlaceData("Gulangyu Island", "Landmark", 24.446550999573216, 118.06623184355593, 4.5f, R.drawable.gulangyu, "Siming District, Xiamen, China", "Gulangyu is directly off the southeastern coast of China, and the quaint tourist attraction is part of the bustling city of Xiamen. The island is famous for its natural beauty, colonial style architecture and a myriad of interesting museums.\n" +
                "\n" +
                "Besides the island's historic significance as an international port, Gulangyu is a great place to escape from city traffic and highrise, though Xiamen has consistently been voted as one of the most livable cities in China, and Gulangyu Island has been recognized as one of Fujian Province's most scenic places.\n" +
                "\n" +
                "Here are some of the attractions that make the islet so popular with natives and international visitors, as well as some important information for making one's island adventure enjoyable."));
        places.add(new PlaceData("Bailuzhou Park", "Park", 24.472884934238202, 118.0890941169133, 4.0f, R.drawable.bailuzhou, "Si Ming Qu, Xia Men Shi", "Bailuzhou Park is also known as the Xiamen Open Square Park. The park has a great environment and is especially good for peaceful and quiet walks." +
                "\n" +
                "You will find the park is divided into Central Park and West Park. In the West Park you will be able to find plenty of music options in the form of fountain squares and plazas. There is also a statue of the egret goddess located in the park. You will be able to find the statue at the south side of the park at the yacht dock. The statue consists of the goddess sitting on a rock as she combs her long beautiful hair. As she combs her hair she allows us to see her in all her beauty while carrying a small egret on her shoulders. The sculpture is a symbol of Xiamen."));

        adapter = new SavedPlacesAdapter(getActivity(), places);
        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));

        return v;
    }
}