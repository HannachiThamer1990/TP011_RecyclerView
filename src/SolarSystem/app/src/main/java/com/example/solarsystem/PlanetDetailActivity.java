package com.example.solarsystem;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PlanetDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planet_detail);
        ImageView detailImage = findViewById(R.id.detailImage);
        TextView detailName = findViewById(R.id.detailName);
        TextView detailMass = findViewById(R.id.detailMass);
        TextView detailRevolution = findViewById(R.id.detailRevolution);
        TextView detailSatellites = findViewById(R.id.detailSatellites);
        TextView detailDiameter = findViewById(R.id.detailDiameter);
        TextView detailGravity = findViewById(R.id.detailGravity);
        TextView detailAtmosphere = findViewById(R.id.detailAtmosphere);
        TextView detailTempRange = findViewById(R.id.detailTempRange);


        Planet planet = (Planet) getIntent().getSerializableExtra("planet");
        if (planet == null) {
            throw new IllegalArgumentException("Planet object is null!");
        }
        detailImage.setImageResource(planet.getImageResId());
        detailName.setText(planet.getName());
        detailMass.setText("Masse: " + planet.getMass() + " kg");
        detailRevolution.setText("Période de révolution: " + planet.getRevolutionPeriod() + " jours");
        detailSatellites.setText("Nombre de satellites: " + planet.getNumberOfSatellites());
        detailDiameter.setText("Diamètre: " + planet.getDiameter() + " km");
        detailGravity.setText("Gravité: " + planet.getGravity() + " m/s²");
        detailAtmosphere.setText("Atmosphère: " + planet.getAtmosphere());
        detailTempRange.setText("Température: " + planet.getMinTemperature() + " °C à " + planet.getMaxTemperature() + " °C");

        Button backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(v -> finish());
    }

}

