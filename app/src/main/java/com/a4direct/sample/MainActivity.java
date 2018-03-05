package com.a4direct.sample;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.Toast;

import com.a4direct.blanket.adapter.base.OnItemClickListener;
import com.a4direct.sample.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnItemClickListener<String> {

    private ActivityMainBinding mBinding;

    private StringAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        mAdapter = new StringAdapter();

        List<String> items = new ArrayList<>();
        items.add("Australia");
        items.add("Brazil");
        items.add("Canada");
        items.add("France");
        items.add("Germany");
        items.add("India");
        items.add("Netherlands");
        items.add("Sweden");
        items.add("United Kingdom");
        items.add("United States");

        mAdapter.setItems(items);
        mAdapter.setListener(this);

        mBinding.recyclerView.setAdapter(mAdapter);
        mBinding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onItemClicked(String item) {
        Toast.makeText(getApplicationContext(), item, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemLongPress(String item) {
        // TODO: add the colde for long click
    }

    @Override
    protected void onDestroy() {
        if (mAdapter != null) {
            mAdapter.tearDown();
        }

        super.onDestroy();
    }
}
