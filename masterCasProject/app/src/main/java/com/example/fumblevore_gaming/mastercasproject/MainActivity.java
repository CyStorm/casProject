package com.example.fumblevore_gaming.mastercasproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import java.util.Calendar;
import java.util.Date;
import com.squareup.timessquare.CalendarPickerView;

// daniel
    public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

        private Button chatTestbutton;
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

            if (savedInstanceState == null) {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new CalendarFragment()).commit();
                navigationView.setCheckedItem(R.id.nav_calendar);
            }
            Date today = new Date();
            Calendar nextYear = Calendar.getInstance();
            nextYear.add(Calendar.YEAR, 1);

            CalendarPickerView datePicker = findViewById(R.id.calendar_view);
            datePicker.init(today, nextYear.getTime())
                    .withSelectedDate(today);

            datePicker.setOnDateSelectedListener(new CalendarPickerView.OnDateSelectedListener() {
                @Override
                public void onDateSelected(Date date) {
                    //String selectedDate = DateFormat.getDateInstance(DateFormat.FULL).format(date);

                    Calendar calSelected = Calendar.getInstance();
                    calSelected.setTime(date);

                    String selectedDate = "" + calSelected.get(Calendar.DAY_OF_MONTH)
                            + " " + (calSelected.get(Calendar.MONTH) + 1)
                            + " " + calSelected.get(Calendar.YEAR);

                    Toast.makeText(MainActivity.this, selectedDate, Toast.LENGTH_SHORT).show();
                }
                @Override
                public void onDateUnselected(Date date) {

                }
        });
        }
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.nav_calendar:
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            new CalendarFragment()).commit();
                    break;
                case R.id.nav_message:
                    Toast.makeText(this, "Message", Toast.LENGTH_SHORT).show();
                    break;
            }
            drawer.closeDrawer(GravityCompat.START);
            return true;
        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.menu_main, menu);
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

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            // Handle action bar item clicks here. The action bar will
            // automatically handle clicks on the Home/Up button, so long
            // as you specify a parent activity in AndroidManifest.xml.
            int id = item.getItemId();

            //noinspection SimplifiableIfStatement
            if (id == R.id.action_settings) {
                return true;
            }

            return super.onOptionsItemSelected(item);
        }
    }

