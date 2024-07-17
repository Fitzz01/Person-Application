package com.example.individualproject;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar); //Ignore red line errors
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_nav,
                R.string.close_nav);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
            navigationView.setCheckedItem(R.id.person);
        }
    }

    //method to change toolbar title on each of fragments
    private void displayFragment(int position) {
        // update the main content by replacing fragments
        Fragment fragment = null;
        String title = "";
        switch (position) {
            case 0:
                fragment = new PersonFragment();
                title = "Profile";
                break;
            case 1:
                fragment = new SkillFragment();
                title = "Skill";
                break;
            case 2:
                fragment = new HobbyFragment();
                title = "Hobby";
                break;
            case 3:
                fragment = new ScheduleFragment();
                title = "Time Table";
                break;
            case 4:
                fragment = new LinkFragment();
                title = "Link";
                break;

            default:
                break;
        }

        // update selected fragment and title
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, fragment).commit(); //replace with id of your frame container
            getSupportActionBar().setTitle(title);
        }
    }

    //method to display dialog message for logout
    public void exitPressed(){

        new AlertDialog.Builder(this)
                .setMessage("Are sure you want to exit ?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                })
                .setNegativeButton("No", null)
                .show();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.person:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new PersonFragment()).commit();
                displayFragment(0);
                break;

            case R.id.skill:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new SkillFragment()).commit();
                displayFragment(1);
                break;

            case R.id.hobby:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HobbyFragment()).commit();
                displayFragment(2);
                break;

            case R.id.schedule:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ScheduleFragment()).commit();
                displayFragment(3);
                break;

            case R.id.link:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new LinkFragment()).commit();
                displayFragment(4);
                break;

            case R.id.action_Logout:
                exitPressed();
                break;
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

}