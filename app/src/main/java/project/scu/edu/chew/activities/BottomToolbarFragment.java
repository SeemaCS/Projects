package project.scu.edu.chew.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;

import project.scu.edu.chew.R;
import project.scu.edu.chew.models.UserSession;

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
    TextView badgeButton;


    public BottomToolbarFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_bottom_toolbar, container, false);

        badgeButton = (TextView) view.findViewById(R.id.badgeButton);
        SharedPreferences gobblePreferences = getActivity().getSharedPreferences("GOBBLE_PREFS", getActivity().MODE_PRIVATE);
        Gson gson = new Gson();
        String json = gobblePreferences.getString("currentSession", "");
        UserSession userSession = gson.fromJson(json, UserSession.class);
        badgeButton.setText(userSession.getBadgeCount() + "");
        if(userSession.getBadgeCount() > 0) {
            badgeButton.setVisibility(View.VISIBLE);
        } else {
            badgeButton.setVisibility(View.INVISIBLE);
        }


//        badgeButton.setVisibility(view.INVISIBLE);
//
//        if(!badgeButton.getText().equals("0")) {
//            badgeButton.setVisibility(view.VISIBLE);
//        }

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

    @Override
    public void onResume() {
        super.onResume();
        SharedPreferences gobblePreferences = getActivity().getSharedPreferences("GOBBLE_PREFS", getActivity().MODE_PRIVATE);
        Gson gson = new Gson();
        String json = gobblePreferences.getString("currentSession", "");
        UserSession userSession = gson.fromJson(json, UserSession.class);
        badgeButton.setText(userSession.getBadgeCount() + "");
        if(userSession.getBadgeCount() > 0) {
            badgeButton.setVisibility(View.VISIBLE);
        } else {
            badgeButton.setVisibility(View.INVISIBLE);
        }
    }
}
