package com.example.solarsystem;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class PlanetAdapter extends RecyclerView.Adapter<PlanetAdapter.PlanetViewHolder> {
    private Context context;
    private List<Planet> planetList;

    public PlanetAdapter(Context context, List<Planet> planetList) {
        this.context = context;
        this.planetList = planetList;
    }
    @NonNull
    @Override
    public PlanetViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_planet, parent, false);
        return new PlanetViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull PlanetViewHolder holder, int position) {
        Planet planet = planetList.get(position);
        holder.planetName.setText(planet.getName());
        holder.planetDistance.setText("Distance: " + planet.getDistanceFromSun() + " million km");
        holder.planetImage.setImageResource(planet.getImageResId());

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, PlanetDetailActivity.class);
            intent.putExtra("planet", planet);
            context.startActivity(intent);
        });
    }
    @Override
    public int getItemCount() {
        return planetList.size();
    }

    static class PlanetViewHolder extends RecyclerView.ViewHolder {
        TextView planetName, planetDistance;
        ImageView planetImage;

        public PlanetViewHolder(@NonNull View itemView) {
            super(itemView);
            planetName = itemView.findViewById(R.id.planetName);
            planetDistance = itemView.findViewById(R.id.planetDistance);
            planetImage = itemView.findViewById(R.id.planetImage);
        }
    }
}

