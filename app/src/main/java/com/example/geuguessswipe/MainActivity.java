package com.example.geuguessswipe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<LocationObject> mLocationObjects = new ArrayList<>();

        for (int i = 0; i < LocationObject.PRE_DEFINED_LOCATION_OBJECT_NAMES.length; i++) {
            mLocationObjects.add(new LocationObject(LocationObject.PRE_DEFINED_LOCATION_OBJECT_NAMES[i],
                    LocationObject.PRE_DEFINED_LOCATION_OBJECT_IMAGE_IDS[i],
                    LocationObject.PRE_DEFINED_LOCATION_OBJECT_ANSWERS[i]));
        }
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        LocationObjectAdapter adapter = new LocationObjectAdapter(this, mLocationObjects);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}