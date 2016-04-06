package com.homework.moibleapp.oscars;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by ssardesai on 2/1/2016.
 */
public class CustomAdapter extends ArrayAdapter<Movies> {

    private final List<Movies> movies;

    static class ViewHolder {
        TextView textView;
        ImageView imageView;
    }

    public CustomAdapter(Context context, int resource, List<Movies> movies) {
        super(context, resource, movies);
        this.movies = movies;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return getView(position, convertView, parent);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Movies movie = movies.get(position);

        View row;
        ViewHolder holder;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService
                    (Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.custom_row, null);

            holder = new ViewHolder();
            holder.imageView = (ImageView) row.findViewById(R.id.movieImage);
            holder.textView = (TextView) row.findViewById(R.id.movieName);
            row.setTag(holder);
        } else {
            row = convertView;
            holder = (ViewHolder) row.getTag();
        }

        // Set the text
        holder.textView.setText(movie.getName());


        // Set the image
        try {
            InputStream inputStream = getContext().getAssets().open(movie.getImage());
            Drawable drawable = Drawable.createFromStream(inputStream, null);
            holder.imageView.setImageDrawable(drawable);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return row;
    }

}
