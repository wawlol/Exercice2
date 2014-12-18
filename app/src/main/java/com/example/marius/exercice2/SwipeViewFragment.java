package com.example.marius.exercice2;


import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.marius.exercice2.Views.SlidingTabLayout;

public class SwipeViewFragment extends Fragment {

    private ViewPager mPager;

    SlidingTabLayout mSlidingTabLayout;

    public SwipeViewFragment() {
    }

    public static SwipeViewFragment newInstance() {
        SwipeViewFragment f = new SwipeViewFragment();
        return f;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        mPager = (ViewPager)getActivity().findViewById(R.id.pager);
        View rootView = inflater.inflate(R.layout.swipe_view, container, false);


        return rootView;

    }

    @Override
    public void onStart() {

        mPager = (ViewPager) getActivity().findViewById(R.id.pager);
        System.out.println("OnStart - SwipeView Fragment");
        mPager.setAdapter(MeAdapter.newInstance(getFragmentManager()));
        mSlidingTabLayout = (SlidingTabLayout) getActivity().findViewById(R.id.sliding_tabs);
        mSlidingTabLayout.setViewPager(mPager);
        super.onStart();
    }


}

