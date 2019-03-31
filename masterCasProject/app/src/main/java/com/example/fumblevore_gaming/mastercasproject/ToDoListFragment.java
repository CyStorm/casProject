package com.example.fumblevore_gaming.mastercasproject;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.*;

public class ToDoListFragment extends Fragment {
    private RecyclerView todolist;
    private ListAdapter listAdapter;
    static ArrayList<Task> taskList = new ArrayList<>();
    ArrayList<String> tasks = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_todolist, null);
        buildToDoList(view);
        return view;
    }

    public class taskComp implements Comparator<Task>{

        @Override
        public int compare(Task t1, Task t2) {
            int a = Integer.parseInt(t1.getDate().replaceAll("[^%\\d]",""));
            int b = Integer.parseInt(t2.getDate().replaceAll("[^%\\d]",""));

            return a-b;
        }
    }
    public void removeItem(int position){
        taskList.remove(position);
        listAdapter.notifyItemRemoved(position);
    }
    public void buildToDoList(View view){
        todolist = view.findViewById(R.id.recyclerView);
        tasks = FileWriting.ReadFile(getActivity());
        for (String task : tasks){
            String[] p = task.split(",");
            taskList.add(new Task(p[0],p[1],p[2],p[3],p[4],p[5]));
        }
        Collections.sort(taskList,new taskComp());

        todolist.setHasFixedSize(true);
        todolist.setLayoutManager(new LinearLayoutManager(view.getContext()));
        listAdapter = new ListAdapter(taskList);
        todolist.setAdapter(listAdapter);
        listAdapter.setOnDeleteClickListener(new ListAdapter.OnDeleteClickListener() {
            @Override
            public void onDeleteClick(int position) {
                removeItem(position);
            }
        });
    }

}
