package com.example.fumblevore_gaming.mastercasproject;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.*;

import org.w3c.dom.Text;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListViewHolder> {
    private ArrayList<Task> mTaskList;
    private OnDeleteClickListener mlistener;

    public interface OnDeleteClickListener{
        void onDeleteClick(int position);
    }

    public void setOnDeleteClickListener(OnDeleteClickListener listener){
        mlistener=listener;
    }

    public static class ListViewHolder extends RecyclerView.ViewHolder {
        public TextView taskDate;
        public TextView taskName;
        public ImageView deleteTask;

        public ListViewHolder(View itemView, final OnDeleteClickListener listener){
            super(itemView);
            taskName = itemView.findViewById(R.id.Name);
            taskDate = itemView.findViewById(R.id.Date);
            deleteTask = itemView.findViewById(R.id.delete);

            deleteTask.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onDeleteClick(position);
                        }
                    }
                }
            });
        }


    }

    public ListAdapter(ArrayList<Task> tasklist){
        mTaskList=tasklist;

    }
    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.task, parent, false);
        ListViewHolder lvh = new ListViewHolder(v, mlistener);
        return lvh;
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        Task currTask = mTaskList.get(position);

        holder.taskDate.setText(currTask.getDate());
        holder.taskName.setText(currTask.getName());
    }

    @Override
    public int getItemCount() {
        return mTaskList.size();
    }
}
