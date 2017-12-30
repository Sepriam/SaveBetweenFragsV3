package com.example.matt.savebetweenfragsv3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

/**
 * Created by Matt on 10/08/2017.
 */

//note to self - Context is basically just background infomation

class CustomAdapter3 extends ArrayAdapter<Exercises>{

    public CustomAdapter3(Context context, /*This is the resource we're passing in*/ String[] exercises) {

        //this will be the what the listview's element's layout will look like and from array we're passing in params above
        super(context, R.layout.activity_list_view_element ,exercises);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater myInflater = LayoutInflater.from(getContext());

        View customView = myInflater.inflate(R.layout.activity_list_view_element, parent, false);

        //the position is just the position of the item in the list
        String singleExercise = getItem(position);

        //The CustomView is the one we created above
        TextView newTextView = (TextView) customView.findViewById(R.id.myTextview);
        CheckBox newCheckbox = (CheckBox) customView.findViewById(R.id.myCheckbox);

        newTextView.setText(singleExercise);


        return customView;
    }
}
