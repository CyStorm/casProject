package com.example.fumblevore_gaming.mastercasproject;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

public class NotifReader{
    private RecyclerView todolist;
    private ListAdapter listAdapter;
    static ArrayList<Task> taskList = new ArrayList<>();
    ArrayList<String> tasks = new ArrayList<>();
    taskList.clear();
    for (String task : tasks) {
        String[] p = task.split(",");
        taskList.add(new Task(p[0], p[1], p[2], p[3], p[4], p[5]));
    }
}
