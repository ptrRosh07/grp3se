package se.grp3.theorganizer;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.addBtn);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToNext = new Intent(MainActivity.this, InputActivity.class);
                startActivity(goToNext);
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.notesBtn) {
            Intent goToNext = new Intent (MainActivity.this, MainActivity.class);
            startActivity(goToNext);
        } else if (id == R.id.todoBtn) {
            Intent goToNext = new Intent (MainActivity.this, TodoActivity.class);
            startActivity(goToNext);
        } else if (id == R.id.reminderBtn) {
            Intent goToNext = new Intent (MainActivity.this, ReminderActivity.class);
            startActivity(goToNext);
        } else if (id == R.id.plannerBtn) {
            Intent goToNext = new Intent (MainActivity.this, PlannerActivity.class);
            startActivity(goToNext);
        } else if (id == R.id.timerBtn) {
            Intent goToNext = new Intent (MainActivity.this, TimerActivity.class);
            startActivity(goToNext);
        } else if (id == R.id.habitBtn) {
            Intent goToNext = new Intent (MainActivity.this, RecommenderActivity.class);
            startActivity(goToNext);
        } else if (id == R.id.collabBtn) {
            Intent goToNext = new Intent (MainActivity.this, CollabActivity.class);
            startActivity(goToNext);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}