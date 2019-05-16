package com.example.journal;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{
//    variables
    EntryDatabase nEntryDatabase;
    ListView nListView;
    ArrayList<ListItem> ListData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        get listview and database entry
        nListView = findViewById(R.id.joe);
        nEntryDatabase = new EntryDatabase(this);
        populateListView();

//        set adapter and onclicklistener
        nListView.setAdapter(new ListItemAdapter(this, 0, ListData));
        nListView.setOnItemClickListener(new GridItemClickListener());
    }

//    go through data and add al to nListItem
    private void populateListView() {
        Cursor data = nEntryDatabase.getData();

        while (data.moveToNext()) {
            ListItem nListItem = new ListItem();
            nListItem.id = data.getInt(data.getColumnIndex("id"));
            nListItem.time = data.getString(data.getColumnIndex("time"));
            nListItem.title = data.getString(data.getColumnIndex("title"));
            nListItem.content = data.getString(data.getColumnIndex("content"));
            nListItem.mood = data.getInt(data.getColumnIndex("mood"));
            ListData.add(nListItem);
        }
    }

//    onItemClick for new item
    protected void onItemClick(View view) {
        Intent intent = new Intent(this, InPutActivity1.class);
        startActivity(intent);
        }

//     GrititemListener for ListView
    private class GridItemClickListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            ListItem item = ListData.get(position);
            String title = item.title;
            String content = item.content;
            String time = item.time;
            Integer mood = item.mood;

            Intent intent = new Intent(MainActivity.this, DetailActivity.class);
            intent.putExtra("title", title);
            intent.putExtra("content", content);
            intent.putExtra("time", time);
            intent.putExtra("mood", mood);

            startActivity(intent);
        }
    }

}
