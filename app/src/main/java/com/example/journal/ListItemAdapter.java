package com.example.journal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListItemAdapter extends ArrayAdapter<ListItem> {
//    list with items for ListView
    public ArrayList<ListItem> ListItems;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
//        if there is no view, make a view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.entry_row, parent, false);
        }

//        get data and put data in adapterview
        String title = ListItems.get(position).title;
        Integer mood = ListItems.get(position).mood;
        String time = ListItems.get(position).time;
        ImageView image = convertView.findViewById(R.id.imageView);
        TextView mood1 = convertView.findViewById(R.id.textView3);
        if (mood == 1){
            image.setImageResource(R.drawable.crying_face);
            mood1.setText("Shitty");
        }
        else if (mood == 2){
            image.setImageResource(R.drawable.sad_face);
            mood1.setText("pffff");
        }
        else if (mood == 3){
            image.setImageResource(R.drawable.smirk_face);
            mood1.setText("hmmmm");
        }
        else if (mood == 4){
            image.setImageResource(R.drawable.happy_face);
            mood1.setText("yeahh");
        }
        TextView title1 = convertView.findViewById(R.id.textView);
        title1.setText(title);
        TextView time1 = convertView.findViewById(R.id.textView2);
        time1.setText(time);

        return convertView;
    }

//    function to call for Adapter
    public ListItemAdapter(Context context, int resource, ArrayList<ListItem> objects) {
        super(context, resource, objects);
        ListItems = objects;
    }
}
