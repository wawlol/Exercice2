package com.example.marius.exercice2;


import java.util.ArrayList;

public class People {



    private String      mName = null;
    private String      mSex = null;
    private float       mLat = -1;
    private float       mLng = -1;


    public People(final String name, final String sex, final float lat, final float lng){
        this.mName = name;
        this.mSex = sex;
        this.mLat = lat;
        this.mLng = lng;

        }

    public static ArrayList<People> getPeoples(){

        ArrayList<People> peoples = new ArrayList<>();

        for(int i=1; i < 9; i++) {
            peoples.add(new People("Marius " + i, "Male", i * 5, i * 10));
        }
        return peoples;
    }
    public String getName() {
        return mName;
    }
    public float getmLat() {
        return mLat;
    }
    public float getmLng() {
        return mLng;
    }
}
