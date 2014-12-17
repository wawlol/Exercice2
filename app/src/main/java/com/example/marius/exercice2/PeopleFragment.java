package com.example.marius.exercice2;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

public class PeopleFragment extends Fragment {

    public PeopleFragment(){}

    public static PeopleFragment newInstance(){
        return new PeopleFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.people_fragment, container, false);

        PeopleAdapter adapter = new PeopleAdapter(getActivity().getApplicationContext(), People.getPeoples() );
        GridView gridView = (GridView)rootView.findViewById(R.id.people_gridview);

        gridView.setAdapter(adapter);

        return rootView;
    }
}
