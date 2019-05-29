package com.example.cnkua.discoverethiopia.Controllers;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.cnkua.discoverethiopia.AgentFragmentFinal;
import com.example.cnkua.discoverethiopia.AttractionFragmentFinal;
import com.example.cnkua.discoverethiopia.R;

public class AgentActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agent);
        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawer,toolbar,
                R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new AgentFragmentFinal()).commit();

        navigationView.setCheckedItem(R.id.agents);
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.attractions:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new AttractionFragmentFinal()).commit();
//                Intent i1 =new Intent(this,AttractionsActivity.class);
//                startActivity(i1);
                break;
            case R.id.agents:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new AgentFragmentFinal()).commit();
//                Intent i2 =new Intent(this,AgentActivity.class);
//                startActivity(i2);
                break;


        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();}
    }
}
