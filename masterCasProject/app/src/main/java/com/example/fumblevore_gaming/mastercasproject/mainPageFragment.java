package com.example.fumblevore_gaming.mastercasproject;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


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
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_main_page, container, false);

        View view = inflater.inflate(R.layout.fragment_main_page,container,false);
        return view;
    }



}
