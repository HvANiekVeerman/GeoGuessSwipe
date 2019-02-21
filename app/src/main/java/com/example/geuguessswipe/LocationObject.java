package com.example.geuguessswipe;

import com.example.geuguessswipe.R;

public class LocationObject {

    private String mLocationName;
    private boolean inEurope;
    private int mLocationImageName;

    public LocationObject(String mGeoName, int mGeoImageName, boolean mGeoAnswer) {
        this.mLocationName = mGeoName;
        this.inEurope = mGeoAnswer;
        this.mLocationImageName = mGeoImageName;
    }

    public String getLocationName() {
        return mLocationName;
    }

    public int getLocationImage() {
        return mLocationImageName;
    }

    public boolean getLocationAnswer() { return inEurope;}

    public static final String[] PRE_DEFINED_LOCATION_OBJECT_NAMES = {
            "Denmark",
            "Canada",
            "Bangladesh",
            "Kazachstan",
            "Colombia",
            "Poland",
            "Malta",
            "Thailand"
    };

    public static final int[] PRE_DEFINED_LOCATION_OBJECT_IMAGE_IDS = {
            R.drawable.img1_yes_denmark,
            R.drawable.img2_no_canada,
            R.drawable.img3_no_bangladesh,
            R.drawable.img4_yes_kazachstan,
            R.drawable.img5_no_colombia,
            R.drawable.img6_yes_poland,
            R.drawable.img7_yes_malta,
            R.drawable.img8_no_thailand
    };

    public static final boolean[] PRE_DEFINED_LOCATION_OBJECT_ANSWERS = {
            true,
            false,
            false,
            true,
            false,
            true,
            true,
            false,
    };
}
