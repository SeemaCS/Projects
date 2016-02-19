package project.scu.edu.chew.activities;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;

import project.scu.edu.chew.R;
import project.scu.edu.chew.models.FoodItem;

/**
 * Created by lakshitha on 2/2/16.
 */


public class CartAdapter extends ArrayAdapter<FoodItem> {

    private final List<FoodItem> foodItems;

    public CartAdapter(Context context, int resource, List<FoodItem> foodItems) {
        super(context, resource, foodItems);
        this.foodItems = foodItems;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        FoodItem foodItem = foodItems.get(position);

        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService
                (Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.cart_list_row, null);

//        TextView nameTextView = (TextView) row.findViewById(R.id.cart_row_name);
//        nameTextView.setText("Paratha");



//        try {
//            ImageView imageView = (ImageView) row.findViewById(R.id.menu_row_image);
//            InputStream inputStream = getContext().getAssets().open(foodItem.getImagePath());
//            Drawable drawable = Drawable.createFromStream(inputStream, null);
//            imageView.setImageDrawable(drawable);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        return row;
    }
}





