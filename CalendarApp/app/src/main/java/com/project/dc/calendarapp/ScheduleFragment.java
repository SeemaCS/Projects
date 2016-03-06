package com.project.dc.calendarapp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * create an instance of this fragment.
 */
public class ScheduleFragment extends Fragment {

    private Spinner userSpinner;
    private Spinner daySpinner;
    private TextView participants;
    private static final String[] users = {"Jack", "Bob", "John", "Andrew", "Charlie", "Dan"};
    private static final String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    String text = "";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_schedule, container, false);
        MainActivity activity = (MainActivity) getActivity();
        participants = (TextView) view.findViewById(R.id.participants);
        userSpinner = (Spinner)view.findViewById(R.id.users);

//        text = userSpinner.getSelectedItem().toString();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity().getBaseContext(),
                android.R.layout.simple_spinner_item,users);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        userSpinner.setAdapter(adapter);
        userSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        text = parent.getSelectedItem().toString();
                        participants.setText(text);
                        break;
                    case 1:
                        text = text + "," + parent.getSelectedItem().toString();
                        participants.setText(text);
                        //participants.setText(parent.getSelectedItem().toString());

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        daySpinner = (Spinner)view.findViewById(R.id.days);

        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(getActivity().getBaseContext(),
                android.R.layout.simple_spinner_item,days);

        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        daySpinner.setAdapter(adapter1);
        daySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        return view;
    }



}
