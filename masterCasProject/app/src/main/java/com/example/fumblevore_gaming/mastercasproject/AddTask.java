package com.example.fumblevore_gaming.mastercasproject;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
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
import android.widget.TimePicker;

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

        TextView TaskTimeIN = (TextView) findViewById(R.id.taskTime);
        EditText TaskSubjectIN = (EditText) findViewById(R.id.taskSubject);
        EditText TaskDescriptionIN = (EditText) findViewById(R.id.taskDescription);


        // this is where the spinner for priority is set
        Spinner TaskPriorityIN = (Spinner) findViewById(R.id.taskPriority);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.PriorityTypes, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        TaskPriorityIN.setAdapter(adapter);

        // date pick dialogue code
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

        // time selection dialogue code
        TaskTimeIN.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                TimePickerDialog timeSelect = new TimePickerDialog(AddTask.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minutes) {
                        String selectedTime = hourOfDay + ":" + minutes;
                        TaskTimeIN.setText(selectedTime);
                    }
                }, 0, 0, true);
                timeSelect.show();
            }
        });

        // functionality to the button ADD
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
                TaskTime = TaskTimeIN.getText().toString();

                // creates new task object with inputted attributes.
                Task test = new Task(TaskName, TaskSubject, TaskDescription, TaskPriority, TaskDate, TaskTime);
                Log.d("task", test.getName());
                Log.d("task", test.getDescription());
                Log.d("task", test.getPriority());
                Log.d("task", test.getSubject());
                Log.d("task", test.getDate());
                Log.d("task", test.getTime());

                // potentially useless code to send information to other activity.
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
