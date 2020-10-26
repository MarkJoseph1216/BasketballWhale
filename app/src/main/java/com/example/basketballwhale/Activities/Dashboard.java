package com.example.basketballwhale.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.basketballwhale.Fragments.FragmentHome;
import com.example.basketballwhale.Fragments.FragmentLeagues;
import com.example.basketballwhale.Fragments.FragmentPlayers;
import com.example.basketballwhale.Fragments.FragmentScores;
import com.example.basketballwhale.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Dashboard extends AppCompatActivity {

    public static BottomNavigationView bottomNavigation;
    public static FrameLayout frameLayout;

    public static String fragmentStatus = "";
    public static int exitCount = 0;

    // BOTTOM NAVIGATION LISTENER
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    if (fragmentStatus.equals("Home")) {
                        exitCount = 0;
                    } else {
                        fragmentStatus = "Home";
                        exitCount = 0;
                        FragmentHome fragmentHome = new FragmentHome();
                        FragmentManager managerhome = getSupportFragmentManager();
                        managerhome.beginTransaction().replace(R.id.dashboard_frameLayout, fragmentHome, fragmentHome.getTag()).commit();
                    }
                    return true;

                case R.id.navigation_leagues:
                    if (fragmentStatus.equals("Leagues")) {
                        exitCount = 0;
                    } else {
                        fragmentStatus = "Leagues";
                        exitCount = 0;
                        FragmentLeagues fragmentLeagues = new FragmentLeagues();
                        FragmentManager managerLeagues = getSupportFragmentManager();
                        managerLeagues.beginTransaction().replace(R.id.dashboard_frameLayout, fragmentLeagues, fragmentLeagues.getTag()).commit();
                    }
                    return true;
                case R.id.navigation_scores:
                    if (fragmentStatus.equals("Scores")) {
                        exitCount = 0;
                    } else {
                        fragmentStatus = "Scores";
                        exitCount = 0;
                        FragmentScores fragmentScores = new FragmentScores();
                        FragmentManager managerScores = getSupportFragmentManager();
                        managerScores.beginTransaction().replace(R.id.dashboard_frameLayout, fragmentScores, fragmentScores.getTag()).commit();
                    }
                    return true;

                case R.id.navigation_players:
                    if (fragmentStatus.equals("Players")) {
                        exitCount = 0;
                    } else {
                        fragmentStatus = "Players";
                        exitCount = 0;
                        FragmentPlayers fragmentPlayers = new FragmentPlayers();
                        FragmentManager managerPlayers = getSupportFragmentManager();
                        managerPlayers.beginTransaction().replace(R.id.dashboard_frameLayout, fragmentPlayers, fragmentPlayers.getTag()).commit();
                    }
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        overridePendingTransition(R.anim.random, R.anim.zoomout);
        init();
    }

    private void init(){
        frameLayout = (FrameLayout) findViewById(R.id.dashboard_frameLayout);
        bottomNavigation = (BottomNavigationView) findViewById(R.id.bottomNavigation);
        bottomNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        bottomNavigation.setSelectedItemId(R.id.navigation_home);
    }

    @Override
    public void onBackPressed() {
        if (exitCount == 0) {
            exitCount++;
            Toast.makeText(this, "Press back to exit.", Toast.LENGTH_SHORT).show();
        } else {
            finish();
        }
    }
}