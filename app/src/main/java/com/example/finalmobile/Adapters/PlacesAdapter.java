package com.example.finalmobile.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalmobile.DataModels.PlaceData;
import com.example.finalmobile.PlaceDetailsActivity;
import com.example.finalmobile.PlacesActivity;
import com.example.finalmobile.R;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;

public class PlacesAdapter extends RecyclerView.Adapter<PlacesAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<PlaceData> places;

    public PlacesAdapter(Context context, ArrayList<PlaceData> places) {
        this.context = context;
        this.places = places;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.place_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.name.setText(String.valueOf(places.get(position).name));
        holder.type.setText(String.valueOf(places.get(position).type));
        holder.ratingBar.setRating(places.get(position).rating);
        holder.cl.setBackgroundResource(places.get(position).imageUrl);

        holder.btn.setOnClickListener(view -> {
            Intent intent = new Intent(context, PlaceDetailsActivity.class);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return places.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name, type;
        RatingBar ratingBar;
        ConstraintLayout cl;
        MaterialButton btn;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.place_name);
            type = itemView.findViewById(R.id.place_type);
            ratingBar = itemView.findViewById(R.id.rating_place);
            cl = itemView.findViewById(R.id.cl_place_row);
            btn = itemView.findViewById(R.id.read_more);
        }
    }
}
