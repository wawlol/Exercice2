package com.example.marius.exercice2;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class MainActivity extends ActionBarActivity {

    private Toolbar                 mToolbar        = null;
    private DrawerLayout            mDrawerLayout   = null;
    private ActionBarDrawerToggle   mDrawerToggle   = null ;
    private String[]                mDrawerList     = null;
    private ListView                mDrawerItem     = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,mToolbar, R.string.open, R.string.close);
        mDrawerList = getResources().getStringArray(R.array.drawer_list);
        mDrawerItem = (ListView) findViewById(R.id.left_drawer);

        setSupportActionBar(mToolbar);

        mDrawerItem.setAdapter(new ArrayAdapter<>(this,R.layout.drawer_list_item, mDrawerList));

        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.content_frame, HomeFragment.newInstance());
        fragmentTransaction.commit();

        mDrawerItem.setOnItemClickListener(new DrawerItemClickListener());

        //Code for the tab :
    }

    private class DrawerItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView parent, View view, int position, long id) {
            selectItem(position);
        }
    }
    private void selectItem(int position){
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        if (position == 0){
            System.out.println("Nouvelle Instance du fragment SwipeView");
            fragmentTransaction.replace(R.id.content_frame, SwipeViewFragment.newInstance());
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
            mDrawerLayout.closeDrawer(mDrawerItem);
        }
        else if (position == 1){
            fragmentTransaction.replace(R.id.content_frame, MyMapFragment.newInstance());
            fragmentTransaction.commit();
            mDrawerLayout.closeDrawer(mDrawerItem);


        }
        else if (position == 2){
            fragmentTransaction.replace(R.id.content_frame, PeopleFragment.newInstance());
            fragmentTransaction.commit();
            mDrawerLayout.closeDrawer(mDrawerItem);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public void onBackPressed() {
        if(mDrawerLayout.isDrawerOpen(Gravity.START|Gravity.LEFT)){
            mDrawerLayout.closeDrawers();
            return;
        }
        super.onBackPressed();
    }


}
