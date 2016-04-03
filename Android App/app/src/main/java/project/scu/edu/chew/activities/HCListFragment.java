package project.scu.edu.chew.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import project.scu.edu.chew.R;
import project.scu.edu.chew.helpers.LoadData;
import project.scu.edu.chew.models.HomeCook;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * create an instance of this fragment.
 */
public class HCListFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    public HCListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_hclist, container, false);

        ListView listView = (ListView) view.findViewById(R.id.home_cook_list_view);

        final List<HomeCook> homeCooks = new ArrayList<>();
        LoadData.populateData(homeCooks);

        listView.setAdapter(new HomeCookListAdapter(getActivity().getBaseContext(), R.layout.home_cook_list_row, homeCooks));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(getActivity().getBaseContext(), MainKitchenActivity6.class);
                intent.putExtra("homecook", homeCooks.get(position));
                if (intent != null)
                    startActivity(intent);

            }
        });
        // Inflate the layout for this fragment
        return view;
    }


}
