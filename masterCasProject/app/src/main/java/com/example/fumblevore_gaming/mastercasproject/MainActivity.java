package com.example.fumblevore_gaming.mastercasproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.Menu;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        //
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new mainPageFragment()).commit();

    }
    @Override
    public void onStop(){
        super.onStop();
        FileWriting.clearFile(this);
        for (Task task : ToDoListFragment.taskList){
            String line = task.getName() + "," + task.getDate() + "," + task.getTime() + "," + task.getSubject() + "," + task.getPriority() + "," + task.getDescription();
            FileWriting.saveToFile(this,line);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.menu_addtask:
                Intent addTask = new Intent(MainActivity.this, AddTask.class);
                startActivity(addTask);
        }
        return true;
    }
    @Override
    public boolean onNavigationItemSelected( @NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.nav_mainpage:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new mainPageFragment()).commit();
                break;
            case R.id.nav_calendar:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new CalendarFragment()).commit();
                break;

            case R.id.nav_todolist:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ToDoListFragment()).commit();
                break;

                }

            return true;

        }


    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }


    }
    public void mainPageOpenCalendar(View view){
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new CalendarFragment()).commit();
    }


}

