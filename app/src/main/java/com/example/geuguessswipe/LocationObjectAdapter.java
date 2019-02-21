package com.example.geuguessswipe;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

public class LocationObjectAdapter extends RecyclerView.Adapter<LocationObjectViewHolder> {

    private Context mContext;
    private LayoutInflater mInflater;
    public List<LocationObject> listLocationObject;

    public LocationObjectAdapter(Context context, List<LocationObject> listLocationObject) {
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
        this.listLocationObject = listLocationObject;
    }

    public String getLocation(int position) {
        LocationObject location = listLocationObject.get(position);
        return location.getLocationName();
    }

    public boolean getAnswer(int position) {
        LocationObject location = listLocationObject.get(position);
        return location.getLocationAnswer();
    }

    @NonNull
    @Override
    public LocationObjectViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_layout, parent, false);
        return new LocationObjectViewHolder(view);
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public void onBindViewHolder(@NonNull final LocationObjectViewHolder holder, final int position) {
        final LocationObject locationObject = listLocationObject.get(position);
        holder.locationImage.setImageResource(locationObject.getLocationImage());

        holder.locationImage.setOnTouchListener(new View.OnTouchListener() {
            long CLICK_DURATION = 200;
            float x1, x2, y1, y2, t1, t2;

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                boolean answer;
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        x1 = event.getX();
                        y1 = event.getY();
                        t1 = System.currentTimeMillis();
                        return true;
                    case MotionEvent.ACTION_UP:
                        x2 = event.getX();
                        y2 = event.getY();
                        t2 = System.currentTimeMillis();

                        if(x1 == x2 && y1 == y2 && (t2 - t1) < CLICK_DURATION) {
                            Toast.makeText(mContext, "You clicked " + getLocation(position), Toast.LENGTH_SHORT).show();
                        } else if (x1 > x2) {
                            answer = false;
                            if (answer != getAnswer(position)){
                                Toast.makeText(mContext, "Correct Answer!", Toast.LENGTH_SHORT).show();
                            } else Toast.makeText(mContext, "Incorrect answer...", Toast.LENGTH_SHORT).show();
                        } else if ( x2 > x1) {
                            answer = true;
                            if (answer != getAnswer(position)){
                                Toast.makeText(mContext, "Correct Answer!", Toast.LENGTH_SHORT).show();
                            }else Toast.makeText(mContext, "Incorrect Answer...", Toast.LENGTH_SHORT).show();
                        } return true;
                } return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return listLocationObject.size();
    }
}