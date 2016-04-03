package project.scu.edu.chew.activities;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import project.scu.edu.chew.R;
import project.scu.edu.chew.models.FoodItem;

/**
 * Created by lakshitha on 2/2/16.
 */

// Adapter class to display the items available in a kitchen.
public class MenuAdapter extends ArrayAdapter<FoodItem> {

    private final List<FoodItem> foodItems;

    public MenuAdapter(Context context, int resource, List<FoodItem> foodItems) {
        super(context, resource, foodItems);
        this.foodItems = foodItems;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        FoodItem foodItem = foodItems.get(position);

        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService
                (Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.menu_list_row, null);

        TextView nameTextView = (TextView) row.findViewById(R.id.menu_row_name);
        nameTextView.setText(foodItem.getName());

        TextView descTextView = (TextView) row.findViewById(R.id.menu_row_description);
        descTextView.setText(foodItem.getDescription());

        return row;
    }
}





