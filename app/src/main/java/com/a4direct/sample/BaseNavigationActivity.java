package com.a4direct.sample;

import android.arch.lifecycle.ViewModelProvider;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;


import com.a4direct.sample.interfaces.ViewInterface;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

/**
 * Created by Jyothi Asapu on 15-12-2017.
 */
public abstract class BaseNavigationActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Inject
    public ViewModelProvider.Factory mViewModelFactory;

    protected FloatingActionButton mFab;
    protected View mView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_navigation);

        mFab = (FloatingActionButton) findViewById(R.id.fab);
        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fabAction(view);
            }
        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.getMenu().clear();
        navigationView.inflateMenu(getNavigationMenuResource());
        navigationView.setNavigationItemSelectedListener(this);

        mView = findViewById(R.id.content_frame);
    }

    protected void addView(int layoutId) {
        if (mView == null) {
            throw new IllegalArgumentException("mView is null");
        }

        ViewGroup parent = (ViewGroup) mView.getParent();
        int index = parent.indexOfChild(mView);
        parent.removeView(mView);

        mView = getLayoutInflater().inflate(layoutId, parent, false);
        parent.addView(mView, index);
    }

    protected void addView(int layoutId, int fabVisibility) {
        addView(layoutId);
        setFabIcon(fabVisibility);

        if (mView instanceof ViewInterface) {
            ((ViewInterface) mView).initializeViewModel(this, mViewModelFactory);
            setTitle(((ViewInterface) mView).getTitleResource());
        } else {
            throw new IllegalArgumentException("View is not an instance of ViewInterface");
        }
    }

    public abstract int getMenuResource();

    public abstract int getNavigationMenuResource();

    public abstract void fabAction(View view);

    public abstract void doNavigationAction(int id);

    public abstract boolean doMenuAction(int id);

    public void setFabIcon(int visibility) {
        if (mView == null) {
            return;
        }

        if (mFab == null) {
            return;
        }

        int id = ((ViewInterface) mView).getFabIcon();
        mFab.setImageResource(id);
        mFab.setVisibility(visibility);
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
        doNavigationAction(item.getItemId());

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(getMenuResource(), menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (doMenuAction(id)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
