package com.example.fumblevore_gaming.mastercasproject;

import android.app.ActivityManager;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class DateDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_detail);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton addTask = findViewById(R.id.addNewTask);
        addTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                Log.d("date", "add button clicked");
                Intent addTask = new Intent(DateDetail.this, AddTask.class);
                startActivity(addTask);
            }
        });

        // get all attributes from addtask and store them permanantly and display in a list
        Intent recieveData = getIntent();
        String TaskName = recieveData.getStringExtra("TaskName");
        String TaskDescription = recieveData.getStringExtra("TaskDescription");
        String TaskSubject = recieveData.getStringExtra("TaskSubject");
        String TaskPriority = recieveData.getStringExtra("TaskPriority");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
