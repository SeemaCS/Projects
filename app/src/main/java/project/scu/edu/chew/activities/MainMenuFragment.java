package project.scu.edu.chew.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import project.scu.edu.chew.R;
import project.scu.edu.chew.models.FoodItem;
import project.scu.edu.chew.models.HomeCook;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * create an instance of this fragment.
 */
public class MainMenuFragment extends Fragment {

    HomeCook homeCook;

    public MainMenuFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main_menu, container, false);

        Intent i = getActivity().getIntent();
        homeCook = (HomeCook)i.getSerializableExtra("homecook");

        ListView listView = (ListView) view.findViewById(R.id.menu_list_view);

        final List<FoodItem> foodItems = homeCook.getFoodItems();

        listView.setAdapter(new MenuAdapter(getActivity().getBaseContext(), R.layout.menu_list_row, foodItems));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(getActivity().getBaseContext(), FoodItemDetailsActivity9.class);
                intent.putExtra("foodItem", foodItems.get(position));
                if (intent != null)
                    startActivity(intent);

            }
        });
        // Inflate the layout for this fragment
        return view;
    }


}
