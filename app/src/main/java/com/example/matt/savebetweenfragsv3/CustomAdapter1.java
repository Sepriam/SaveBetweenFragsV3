package com.example.matt.savebetweenfragsv3;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Matt on 10/08/2017.
 */

//note to self - Context is basically just background infomation

class CustomAdapter1 extends ArrayAdapter<Exercises>{

    SharedPreferences.Editor editor;

    public ArrayList<Exercises> exerciseList1;

    public CustomAdapter1(@NonNull Context context, @LayoutRes int resource, /*This is the resource we're passing in*/ ArrayList<Exercises> exerciseList) {

        //this will be the what the listview's element's layout will look like and from array we're passing in params above
        super(context, resource, exerciseList);
        this.exerciseList1 = new ArrayList<Exercises>();
        this.exerciseList1.addAll(exerciseList);
    }


    public class ViewHolder {
        TextView name;
        CheckBox chckBox;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //Creates a new viewholder to hold the current state of widgets
        ViewHolder holder = null;


        //checks to see if the content is new
        if (convertView == null) {

            //inflates the layout, gets context from wherever necessary
            LayoutInflater vi = (LayoutInflater) getContext().getSystemService(getContext().LAYOUT_INFLATER_SERVICE);


            //inflates the listview with custom listview element layout
            convertView = vi.inflate(R.layout.activity_list_view_element, null);

            //creates new instance of viewholder class
            holder = new ViewHolder();
            //assign the checkbox and textview to the viewholder
            holder.name = (TextView) convertView.findViewById(R.id.myTextview);
            holder.chckBox = (CheckBox) convertView.findViewById(R.id.myCheckbox);

            //sets the tag of the view to viewholder class
            /*
            essentially setting a tag allows us to assign an onclicklistener to everybutton in that list
            The onclick allows for but 1 parameter - IE a View
            We want the information from the views themselves --- hence the TAG
            Only useful if every button or in this case checkbox has the same functionality.
             */
            convertView.setTag(holder);

            holder.chckBox.setOnClickListener(new View.OnClickListener()
            {
                public void onClick(View v) {
                    CheckBox cb = (CheckBox) v;
                    Exercises _exercises = (Exercises) cb.getTag();

                    _exercises.setSelected(cb.isChecked());

                }


            });


        }
        else
        {
            holder = (ViewHolder) convertView.getTag();
        }

        Exercises exercises = exerciseList1.get(position);

        holder.chckBox.setText(exercises.getName());
        holder.chckBox.setChecked(exercises.getSelected());

        holder.chckBox.setTag(exercises);

        return convertView;
    }
}
