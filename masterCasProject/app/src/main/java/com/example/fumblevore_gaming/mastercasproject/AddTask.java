package com.example.fumblevore_gaming.mastercasproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.StringDef;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Spinner;

public class AddTask extends AppCompatActivity {

    String TaskName, TaskSubject, TaskDescription, TaskPriority;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        EditText TaskNameIN = (EditText) findViewById(R.id.taskName);
        EditText TaskDateIN = (EditText) findViewById(R.id.taskDate);
        EditText TaskTimeIN = (EditText) findViewById(R.id.taskTime);
        EditText TaskSubjectIN = (EditText) findViewById(R.id.taskSubject);
        EditText TaskDescriptionIN = (EditText) findViewById(R.id.taskDescription);
        Spinner TaskPriorityIN = (Spinner) findViewById(R.id.taskPriority);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.PriorityTypes, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        TaskPriorityIN.setAdapter(adapter);



        Button createNewTask = findViewById(R.id.addTaskCreate);
        createNewTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                TaskName = TaskNameIN.getText().toString();
                TaskSubject = TaskSubjectIN.getText().toString();
                TaskDescription = TaskDescriptionIN.getText().toString();

// find way of having date and time identifier to transfer to display screen.


                Intent transferToDisplay = new Intent(AddTask.this, DateDetail.class);
                transferToDisplay.putExtra("TaskName", TaskName);
                transferToDisplay.putExtra("TaskSubject", TaskSubject);
                transferToDisplay.putExtra("TaskDescription", TaskDescription);
                transferToDisplay.putExtra("TaskPriority", TaskPriority);

                startActivity(transferToDisplay);

            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
