package com.example.matt.savebetweenfragsv3;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

/**
 * Created by Matt on 11/08/2017.
 */

public class tab2Fragment extends Fragment {
    private static final String TAG = "tab2Fragment";

    String[] exercisesList = {"push-up", "pull-up", "muscle-up", "skipping", "pull-over"};

    private Button btrTEST;
    private ListView lvTEST;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment2,container,false);

        //btrTEST = (Button) view.findViewById(R.id.button2);

        ListAdapter myListAdapter = new CustomAdapter2(getContext(), exercisesList);
        lvTEST = (ListView) view.findViewById(R.id.listview2);
        lvTEST.setAdapter(myListAdapter);


        return view;
    }
}
