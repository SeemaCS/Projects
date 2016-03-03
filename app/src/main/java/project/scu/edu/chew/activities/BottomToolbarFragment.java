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
public class BottomToolbarFragment extends Fragment {

    Button searchButton;
    Button user;
    Button cartButton;
    Button homeButton;


    public BottomToolbarFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_bottom_toolbar, container, false);

        searchButton = (Button) view.findViewById(R.id.searchButton);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity().getBaseContext(), SearchActivity.class);
                if (intent != null)
                    startActivity(intent);

            }
        });



        user = (Button)view.findViewById(R.id.user);
        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getBaseContext(), UserActivity.class);
                if (intent != null)
                    startActivity(intent);

            }
        });

        cartButton = (Button) view.findViewById(R.id.cartButton);
        cartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getBaseContext(), CartActivity10.class);
                if (intent != null)
                    startActivity(intent);
            }
        });

        homeButton = (Button) view.findViewById(R.id.homeButton);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getBaseContext(), HCListActivity5.class);
                if (intent != null)
                    startActivity(intent);
            }
        });


        // Inflate the layout for this fragment
        return view;
    }

}
