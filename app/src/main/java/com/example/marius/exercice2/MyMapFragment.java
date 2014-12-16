package com.example.marius.exercice2;


import android.app.Fragment;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MyMapFragment extends MapFragment {


    public MyMapFragment() {
    }

    public static MyMapFragment newInstance() {
        MyMapFragment f = new MyMapFragment();
        return f;
    }

    @Override
    public void onStart() {
        getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {


                for (int i = 0; i<People.getPeoples().size(); i++){

                    People person = People.getPeoples().get(i);
                    String name = person.getName();
                    float  lat = person.getmLat();
                    float  lng   = person.getmLng();

                    googleMap.addMarker(new MarkerOptions()
                            .position(new LatLng(lat, lng))
                            .title(name));
                }
            }
        });
        super.onStart();
    }


}

