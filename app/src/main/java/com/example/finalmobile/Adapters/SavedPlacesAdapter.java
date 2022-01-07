package com.example.finalmobile.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalmobile.DataModels.PlaceData;
import com.example.finalmobile.DatabaseHelper;
import com.example.finalmobile.PlaceDetailsActivity;
import com.example.finalmobile.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.switchmaterial.SwitchMaterial;

import java.util.ArrayList;

public class SavedPlacesAdapter extends RecyclerView.Adapter<SavedPlacesAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<PlaceData> places;
    private DatabaseHelper db;

    public SavedPlacesAdapter(Context context, ArrayList<PlaceData> places) {
        this.context = context;
        this.places = places;
        db = new DatabaseHelper(context);
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.saved_place_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.name.setText(String.valueOf(places.get(position).name));
        holder.type.setText(String.valueOf(places.get(position).type));
        holder.cl.setBackgroundResource(places.get(position).imageUrl);

        holder.btn.setOnClickListener(view -> {
            Intent intent = new Intent(context, PlaceDetailsActivity.class);
            intent.putExtra("name", places.get(position).name);
            intent.putExtra("type", places.get(position).type);
            intent.putExtra("lat", places.get(position).lat);
            intent.putExtra("lng", places.get(position).lng);
            intent.putExtra("rating", places.get(position).rating);
            intent.putExtra("imageUrl", places.get(position).imageUrl);
            intent.putExtra("address", places.get(position).address);
            intent.putExtra("description", places.get(position).description);
            context.startActivity(intent);
        });

        holder.switch_visited.setChecked(places.get(position).isVisited);
        if(places.get(position).isVisited){
            holder.tv_visited.setText("Visited");
            holder.tv_visited.setTextColor(context.getResources().getColor(R.color.green));
        } else {
            holder.tv_visited.setText("Not Visited");
            holder.tv_visited.setTextColor(context.getResources().getColor(R.color.lightGrey));
        }

        holder.switch_visited.setOnClickListener(view -> {
            if(holder.switch_visited.isChecked()){
                db.changeVisited(places.get(position).name, true);
                holder.tv_visited.setText("Visited");
                holder.tv_visited.setTextColor(context.getResources().getColor(R.color.green));
            } else {
                db.changeVisited(places.get(position).name, false);
                holder.tv_visited.setText("Not Visited");
                holder.tv_visited.setTextColor(context.getResources().getColor(R.color.lightGrey));
            }
        });
    }

    @Override
    public int getItemCount() {
        return places.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name, type;
        ConstraintLayout cl;
        MaterialButton btn;
        SwitchMaterial switch_visited;
        TextView tv_visited;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.place_name);
            type = itemView.findViewById(R.id.place_type);
            cl = itemView.findViewById(R.id.cl_place_row);
            btn = itemView.findViewById(R.id.read_more);
            switch_visited = itemView.findViewById(R.id.switch_visited);
            tv_visited = itemView.findViewById(R.id.visited);
        }
    }
}
