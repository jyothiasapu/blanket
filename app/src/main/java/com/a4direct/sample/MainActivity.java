package com.a4direct.sample;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.a4direct.sample.interfaces.ViewInterface;

public class MainActivity extends BaseNavigationActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addView(R.layout.feedback_list_view, View.GONE);
    }

    @Override
    public int getMenuResource() {
        return R.menu.main;
    }

    @Override
    public int getNavigationMenuResource() {
        return R.menu.activity_main_drawer;
    }

    @Override
    public void fabAction(View view) {
        ((ViewInterface) mView).fabAction(view);
    }

    @Override
    public void doNavigationAction(int id) {
        if (id == R.id.feedback_list) {
            addView(R.layout.feedback_list_view, View.GONE);
        } else if (id == R.id.feedback) {
            addView(R.layout.feedback_view, View.VISIBLE);
        } else if (id == R.id.info_activity) {
            Intent intent = new Intent(this, InfoActivity.class);
            startActivity(intent);
        }
    }

    @Override
    public boolean doMenuAction(int id) {
        if (id == R.id.action_settings) {
            Toast.makeText(getApplicationContext(), "Settings Activity", Toast.LENGTH_SHORT).show();
            return true;
        }

        return false;
    }
}
