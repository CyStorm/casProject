package com.example.fumblevore_gaming.mastercasproject;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class NotifMain extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener {
    private TextView mTextView;

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        ArrayList<String[]> dateList = new ArrayList<String[]>();

        for (Task task : ToDoListFragment.taskList){
            String[] date = task.getDate().split("/");
            dateList.add(date);
            String year = date[0];
            String month = date[1];
            String day = date[2];
            Calendar c = Calendar.getInstance();
            c.set(Calendar.YEAR, Integer.parseInt(year));
            c.set(Calendar.MONTH, Integer.parseInt(month));
            c.set(Calendar.DAY_OF_MONTH, Integer.parseInt(day));

            updateTimeText(c);
            startAlarm(c);
        }
    }

    private void updateTimeText(Calendar c) {
        String timeText = "Alarm set for: ";
        timeText += DateFormat.getTimeInstance(DateFormat.SHORT).format(c.getTime());

        mTextView.setText(timeText);
    }

    private void startAlarm(Calendar c) {
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(this, AlertReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 1, intent, 0);

        if (c.before(Calendar.getInstance())) {
            c.add(Calendar.DATE, 1);
        }

        alarmManager.setExact(AlarmManager.RTC_WAKEUP, c.getTimeInMillis(), pendingIntent);
    }
}
