package com.example.fumblevore_gaming.mastercasproject;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.support.annotation.StringDef;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Spinner;

public class AddTask extends AppCompatActivity {

    String TaskName, TaskSubject, TaskDescription, TaskPriority, TaskDate, TaskTime;
    private DatePickerDialog.OnDateSetListener dateSelect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        EditText TaskNameIN = (EditText) findViewById(R.id.taskName);

        TextView TaskDateIN = (TextView) findViewById(R.id.taskDate);

        EditText TaskTimeIN = (EditText) findViewById(R.id.taskTime);
        EditText TaskSubjectIN = (EditText) findViewById(R.id.taskSubject);
        EditText TaskDescriptionIN = (EditText) findViewById(R.id.taskDescription);

        Spinner TaskPriorityIN = (Spinner) findViewById(R.id.taskPriority);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.PriorityTypes, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        TaskPriorityIN.setAdapter(adapter);

        TaskDateIN.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int currentYear = cal.get(Calendar.YEAR);
                int currentMonth = cal.get(Calendar.MONTH);
                int currentDay = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(AddTask.this, android.R.style.Theme_Holo_Dialog, dateSelect, currentYear,currentMonth,currentDay);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable((Color.TRANSPARENT)));
                dialog.show();
            }
        });

        dateSelect = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                Log.d("date", year + "/" + (month + 1) + "/" + dayOfMonth);
                String selectedDate = year + "/" + (month + 1) + "/" + dayOfMonth;
                TaskDateIN.setText(selectedDate);
            }
        };

        Button createNewTask = findViewById(R.id.addTaskCreate);
        createNewTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                TaskName = TaskNameIN.getText().toString();
                TaskSubject = TaskSubjectIN.getText().toString();
                TaskDescription = TaskDescriptionIN.getText().toString();
                TaskPriority = TaskPriorityIN.getSelectedItem().toString();
                TaskDate = TaskDateIN.getText().toString();

// find way of having date and time identifier to transfer to display screen.
                Task test = new Task(TaskName, TaskSubject, TaskDescription, TaskPriority, TaskDate);
                Log.d("task", test.getName());
                Log.d("task", test.getDescription());
                Log.d("task", test.getPriority());
                Log.d("task", test.getSubject());
                Log.d("task", test.getDate());


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
