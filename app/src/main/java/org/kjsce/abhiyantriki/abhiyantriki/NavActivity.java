package org.kjsce.abhiyantriki.abhiyantriki;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.ViewStub;
import android.support.v4.widget.DrawerLayout;

public class NavActivity extends AppCompatActivity {
    DrawerLayout dl;
    ActionBarDrawerToggle abdt;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.drawer_layout);

    }

    @Override
    public void setContentView(int layoutResID) {
        ViewStub viewStub = (ViewStub) findViewById(R.id.navdrawer_stub);
        viewStub.setLayoutResource(layoutResID);
        viewStub.inflate();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return abdt.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }

    //If drawer is open and back is pressed, close the drawer
    //else go to previous activity
    @Override
    public void onBackPressed() {
        if (dl.isDrawerOpen(GravityCompat.START)) {
            dl.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        dl = (DrawerLayout) findViewById(R.id.drawer_layout);
        abdt = new ActionBarDrawerToggle(this, dl, R.string.Open, R.string.Close);

        abdt.setDrawerIndicatorEnabled(true);
        abdt.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.white));

        dl.addDrawerListener(abdt);
        abdt.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);

        //For handling click events of navigation drawer
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();
                Intent intent;

                switch (id) {
                    case R.id.events:
                        intent = new Intent(NavActivity.this, EventsActivity.class);
                        startActivity(intent);
                        break;

                    case R.id.expos:
                        intent = new Intent(NavActivity.this, ExposActivity.class);
                        startActivity(intent);
                        break;

                    case R.id.speakers:
                        intent = new Intent(NavActivity.this, SpeakersActivity.class);
                        startActivity(intent);
                        break;

                    case R.id.sponsors:
                        intent = new Intent(NavActivity.this, SponsorsActivity.class);
                        startActivity(intent);
                        break;

                    case R.id.parvaah:
                        intent = new Intent(NavActivity.this, ParvaahActivity.class);
                        startActivity(intent);
                        break;

                    case R.id.get_involved:
                        intent = new Intent(NavActivity.this, GetInvolved.class);
                        startActivity(intent);
                        break;

                    case R.id.reach:
                        intent = new Intent(NavActivity.this, ReachUs.class);
                        startActivity(intent);
                        break;
                    case R.id.profile:
                        intent = new Intent(NavActivity.this, ProfileActivity.class);
                        startActivity(intent);
                        break;
                }
                dl.closeDrawer(GravityCompat.START);
                return true;
            }
        });
    }
}