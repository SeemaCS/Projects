package project.scu.edu.chew.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import project.scu.edu.chew.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * create an instance of this fragment.
 */
public class TopToolbarFragment extends Fragment {

    Button mapButton;
    Button navigationButton;

    public TopToolbarFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_top_toolbar, container, false);

        navigationButton = (Button) view.findViewById(R.id.navigationButton);
        navigationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((BaseActivity)getActivity()).mDrawerLayout.openDrawer(((BaseActivity)getActivity()).mDrawerList);
            }
        });

        mapButton = (Button) view.findViewById(R.id.mapButton);
        mapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity().getBaseContext(), MapActivity.class);
                if (intent != null)
                    startActivity(intent);

            }
        });

        // Inflate the layout for this fragment
        return view;


    }


}
