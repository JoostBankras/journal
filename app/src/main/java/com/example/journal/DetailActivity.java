package com.example.journal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

//        get extra data from intent
        Intent intent = getIntent();
        String title = (String) intent.getSerializableExtra("title");
        String time = (String) intent.getSerializableExtra("time");
        String content = (String) intent.getSerializableExtra("content");
        Integer mood = (Integer) intent.getSerializableExtra("mood");

//        put data in detail view
        TextView title1 = findViewById(R.id.title);
        title1.setText(title);
        TextView time1 = findViewById(R.id.time);
        time1.setText(time);
        TextView content1 = findViewById(R.id.content);
        content1.setText(content);
        ImageView image = findViewById(R.id.imageView);
        if (mood == 1){
            image.setImageResource(R.drawable.crying_face);
        }
        else if (mood == 2){
            image.setImageResource(R.drawable.sad_face);
        }
        else if (mood == 3){
            image.setImageResource(R.drawable.smirk_face);
        }
        else if (mood == 4){
            image.setImageResource(R.drawable.happy_face);
        }
    }

//    function for adding another blog item
    protected void onItemClick(View view) {
        Intent intent = new Intent(this, InPutActivity1.class);
        startActivity(intent);
    }
}
