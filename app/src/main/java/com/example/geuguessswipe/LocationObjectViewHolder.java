package com.example.geuguessswipe;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class LocationObjectViewHolder extends RecyclerView.ViewHolder {

    public ImageView locationImage;
    RelativeLayout parentLayout;

    public LocationObjectViewHolder(View itemView) {
        super(itemView);
        locationImage = itemView.findViewById(R.id.locationImage);
        parentLayout = itemView.findViewById(R.id.recyclerView);
    }
}
