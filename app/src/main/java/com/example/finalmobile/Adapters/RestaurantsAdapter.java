package com.example.finalmobile.Adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalmobile.DataModels.RestaurantData;
import com.example.finalmobile.R;

import java.util.ArrayList;

public class RestaurantsAdapter extends RecyclerView.Adapter<RestaurantsAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<RestaurantData> restaurants;

    public RestaurantsAdapter(Context context, ArrayList<RestaurantData> restaurants){
        this.context = context;
        this.restaurants = restaurants;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater= LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.restaurant_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.name.setText(String.valueOf(restaurants.get(position).name));
        holder.speciality.setText(String.valueOf(restaurants.get(position).speciality));
        holder.ratingBar.setRating(restaurants.get(position).rating);
        holder.cl.setBackgroundResource(restaurants.get(position).imageUrl);

        holder.btn.setOnClickListener(view -> {
            String uri = "http://maps.google.com/maps?daddr=" + restaurants.get(position).lat + "," + restaurants.get(position).lng;
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return restaurants.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView name, speciality;
        RatingBar ratingBar;
        ConstraintLayout cl;
        ImageButton btn;

        public MyViewHolder(@NonNull View itemView){
            super(itemView);

            name = itemView.findViewById(R.id.restaurant_name);
            speciality = itemView.findViewById(R.id.speciality);
            ratingBar = itemView.findViewById(R.id.rating_restaurant);
            cl = itemView.findViewById(R.id.cl_restaurant_row);
            btn = itemView.findViewById(R.id.btnRestaurantDirection);
        }
    }
}
