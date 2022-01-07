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

import com.example.finalmobile.DataModels.HotelData;
import com.example.finalmobile.HotelDetailsActivity;
import com.example.finalmobile.HotelsActivity;
import com.example.finalmobile.R;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;

public class HotelsAdapter extends RecyclerView.Adapter<HotelsAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<HotelData> hotels;

    public HotelsAdapter(Context context, ArrayList<HotelData> hotels){
        this.context = context;
        this.hotels = hotels;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater= LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.hotel_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.name.setText(String.valueOf(hotels.get(position).name));
        holder.price.setText(String.valueOf(hotels.get(position).price));
        holder.ratingBar.setRating(hotels.get(position).rating);
        holder.cl.setBackgroundResource(hotels.get(position).imageUrl);

        holder.btn.setOnClickListener(view -> {
            Intent intent = new Intent(context, HotelDetailsActivity.class);
            intent.putExtra("name", hotels.get(position).name);
            intent.putExtra("price", hotels.get(position).price);
            intent.putExtra("lat", hotels.get(position).lat);
            intent.putExtra("lng", hotels.get(position).lng);
            intent.putExtra("rating", hotels.get(position).rating);
            intent.putExtra("imageUrl", hotels.get(position).imageUrl);
            intent.putExtra("address", hotels.get(position).address);
            intent.putExtra("description", hotels.get(position).description);
            intent.putExtra("hasPool", hotels.get(position).hasPool);
            intent.putExtra("hasWifi", hotels.get(position).hasWifi);
            intent.putExtra("hasFitness", hotels.get(position).hasFitness);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return hotels.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView name, price;
        RatingBar ratingBar;
        ConstraintLayout cl;
        MaterialButton btn;

        public MyViewHolder(@NonNull View itemView){
            super(itemView);

            name = itemView.findViewById(R.id.hotel_name);
            price = itemView.findViewById(R.id.hotel_price);
            ratingBar = itemView.findViewById(R.id.rating_hotel);
            cl = itemView.findViewById(R.id.cl_hotel_row);
            btn = itemView.findViewById(R.id.read_more);
        }
    }
}
