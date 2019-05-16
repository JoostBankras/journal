package com.example.journal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class InPutActivity1 extends AppCompatActivity {
//   define database entry
    EntryDatabase nDatabaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_in_put1);
        nDatabaseHelper = new EntryDatabase(this);

    }

//    submit button for adding a new item
    protected void onItemClick1(View view){
        TextView input = findViewById(R.id.editText);
        String title = input.getText().toString();
        TextView input2 = findViewById(R.id.editText2);
        String content = input2.getText().toString();
        RadioButton btn1 = findViewById(R.id.radioButton1);
        RadioButton btn2 = findViewById(R.id.radioButton2);
        RadioButton btn3 = findViewById(R.id.radioButton3);

        String mood;
//         defining all pictures as numbers
        if (btn1.isChecked()){
            mood = "1";
        }
        else if (btn2.isChecked()){
            mood = "2";
        }
        else if (btn3.isChecked()){
            mood = "3";
        }
        else {
            mood = "4";
        }
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        String time = dateFormat.format(date);

//        inserting data into database
        boolean insertData = nDatabaseHelper.addData(title, content, mood, time);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
