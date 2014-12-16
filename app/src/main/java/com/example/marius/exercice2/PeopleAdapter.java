package com.example.marius.exercice2;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class PeopleAdapter extends ArrayAdapter<People> {

    public PeopleAdapter(Context context, ArrayList<People> peoples) {
        super(context, 0, peoples);

}
    @Override
    public View getView (int position, View convertView, ViewGroup parent){

        People people = getItem(position);
        ViewHolder viewHolder;

        if (convertView == null) {
            viewHolder = new ViewHolder();

            convertView = LayoutInflater.from(getContext()).inflate(R.layout.people_fragment_item, parent, false);
            viewHolder.text = (TextView) convertView.findViewById(R.id.people_textview);

            convertView.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.text.setText(people.getName());

        return convertView;
    }

    private static class ViewHolder{
        private TextView  text = null;
    }
}