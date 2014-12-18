package com.example.marius.exercice2;


import android.app.FragmentManager;
import android.support.v13.app.FragmentPagerAdapter;

class MeAdapter extends FragmentPagerAdapter {

    private static int NUM_ITEMS = 3;

    public MeAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    public static MeAdapter newInstance(FragmentManager fragmentManager) {
        MeAdapter m = new MeAdapter(fragmentManager);
        return m;

    }

    @Override
    public int getCount() {
        return NUM_ITEMS;
    }

    @Override
    public PeopleFragment getItem(int position) {

        switch (position) {
            case 0:
                System.out.println("getItem lancé");
                return PeopleFragment.newInstance();
            case 1:
                return PeopleFragment.newInstance();
            case 2:
                return PeopleFragment.newInstance();
        }
        return null;
    }
}
