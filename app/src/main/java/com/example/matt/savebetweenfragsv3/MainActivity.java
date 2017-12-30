package com.example.matt.savebetweenfragsv3;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button btnMain;

    CustomAdapter1 customAdapter1 = null;
    CustomAdapter2 customAdapter2 = null;
    CustomAdapter3 customAdapter3 = null;


    private static final String TAG = "MainActivity";

    private SectionsPageAdapter mSectionPageAdapter;

    private ViewPager mViewPager;

    private ViewPager lastView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Merge button with it's source in XML
        //---------------------- Need to create a method here that displays all currently displayed items in a list.
        btnMain = (Button) findViewById(R.id.buttonMain);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());


        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        setupViewPager(mViewPager);


        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

    }


    private void setupViewPager(ViewPager viewPager)
    {
        SectionsPageAdapter adapter = new SectionsPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new tab1Fragment(), "Legs");
        adapter.addFragment(new tab2Fragment(), "Chest");
        adapter.addFragment(new tab3Fragment(), "Core");
        viewPager.setAdapter(adapter);
    }

    private void createExercises()
    {

        ArrayList<Exercises> exerciseList = new ArrayList<>();

        Exercises _newExercise = new Exercises("Squat", false);
        exerciseList.add(_newExercise);
        _newExercise = new Exercises("Bar-kip", false);
        exerciseList.add(_newExercise);
        _newExercise = new Exercises("Pull-over", false);
        exerciseList.add(_newExercise);
        _newExercise = new Exercises("Push-up", false);
        exerciseList.add(_newExercise);
        _newExercise = new Exercises("Pull-up", false);
        exerciseList.add(_newExercise);
        _newExercise = new Exercises("Muscle-up", false);
        exerciseList.add(_newExercise);
        _newExercise = new Exercises("Deadlift", false);
        exerciseList.add(_newExercise);
        _newExercise = new Exercises("Weighted Pull-ups", false);
        exerciseList.add(_newExercise);
        _newExercise = new Exercises("Explosive Pull-ups", false);
        exerciseList.add(_newExercise);


        customAdapter1 = new CustomAdapter1(this, R.layout.activity_list_view_element, exerciseList);
        ListView listView = (ListView) findViewById(R.id.listview1);

        listView.setAdapter(customAdapter1);

    }
}
