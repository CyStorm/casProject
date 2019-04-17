package com.example.fumblevore_gaming.mastercasproject;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentManagerNonConfig;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link mainPageFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link mainPageFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class mainPageFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_main_page,container,false);
        ImageButton CalendarOpen = (ImageButton) view.findViewById(R.id.CalendarOpen);
        CalendarOpen.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                CalendarFragment calendarFragment = new CalendarFragment();
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.fragment_container, new CalendarFragment()).commit();
            }
        });
        ImageButton ScheduleOpen = (ImageButton) view.findViewById(R.id.ScheduleOpen);
        ScheduleOpen.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                ToDoListFragment toDoListFragment = new ToDoListFragment();
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.fragment_container, new ToDoListFragment()).commit();
            }
        });

        return view;





    }



}
