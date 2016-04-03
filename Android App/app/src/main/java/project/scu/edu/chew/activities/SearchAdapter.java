package project.scu.edu.chew.activities;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import project.scu.edu.chew.R;
import project.scu.edu.chew.models.HomeCook;


public class SearchAdapter extends BaseAdapter implements Filterable {

    CustomFilter filter;
    Context c;
    ListView listView;

    private List<HomeCook> homeCooks;

    List<HomeCook> filterList;

    public SearchAdapter(Context context, List<HomeCook> homeCooks, ListView listView) {
        this.c = context;
        this.homeCooks = homeCooks;
        this.filterList = homeCooks;
        this.listView = listView;
    }

    @Override
    public int getCount() {
        return homeCooks.size();
    }

    @Override
    public Object getItem(int pos) {
        return homeCooks.get(pos);
    }

    @Override
    public long getItemId(int pos) {
        return homeCooks.indexOf(getItem(pos));
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        HomeCook homeCook = homeCooks.get(position);

        LayoutInflater inflater = (LayoutInflater) c.getSystemService
                (Context.LAYOUT_INFLATER_SERVICE);
        if(convertView == null) {
            convertView = inflater.inflate(R.layout.home_cook_list_row, null);
        }
        TextView nameTextView = (TextView) convertView.findViewById(R.id.home_cook_row_name);
        nameTextView.setText(homeCook.getName());
        TextView cuisineTextView = (TextView) convertView.findViewById(R.id.home_cook_row_cuisine);
        cuisineTextView.setText(homeCook.getCuisine());

        try {
            ImageView imageView = (ImageView) convertView.findViewById(R.id.home_cook_row_image);
            InputStream inputStream = c.getAssets().open(homeCook.getImagePath());
            Drawable drawable = Drawable.createFromStream(inputStream, null);
            imageView.setImageDrawable(drawable);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return convertView;
    }

    @Override
    public Filter getFilter() {
        if(filter == null) {
            filter = new CustomFilter();
        }
        return filter;
    }

    //inner class
    class CustomFilter extends Filter {

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results = new FilterResults();
            if(constraint!=null && constraint.length() >0) {
                //constraint to upper
                constraint = constraint.toString().toUpperCase();
                ArrayList<HomeCook> filters = new ArrayList<HomeCook>();

                //getSpecific items
                for(int i =0; i < filterList.size();i++) {
                    if((filterList.get(i).getName().toUpperCase().contains(constraint)) || (filterList.get(i).getCuisine().toUpperCase().contains(constraint))) {
//                        HomeCook p = new HomeCook(filterList.get(i).getName(),"88888888",filterList.get(i).getImagePath());
//                        p.setCuisine(filterList.get(i).getCuisine());

                        HomeCook p = new HomeCook(filterList.get(i));
                        filters.add(p);
                    }
                }
                results.count = filters.size();
                results.values = filters;

            }
            else {
                results.count = filterList.size();
                results.values = filterList;
            }
            //New <code></code>
            homeCooks = filterList;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {

            homeCooks = (List<HomeCook>)results.values;
            notifyDataSetChanged();

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    Intent intent = new Intent(c, MainKitchenActivity6.class);

                    //New <code></code>
                    //HomeCook selectedHomeCook = (HomeCook)listView.getSelectedItem();
                    System.out.println("Homecook selectd in adpater:" + homeCooks.get(position).getName());
                    intent.putExtra("homecook", homeCooks.get(position));
                    if (intent != null)
                        c.startActivity(intent);

                }
            });
        }
    }

}
