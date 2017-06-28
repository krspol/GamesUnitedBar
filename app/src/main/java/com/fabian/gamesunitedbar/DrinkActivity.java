package com.fabian.gamesunitedbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.fabian.gamesunitedbar.R;
import com.fabian.gamesunitedbar.adapter.DrinkAdapter;
import com.fabian.gamesunitedbar.data.DrinkMockData;

public class DrinkActivity extends AppToolbarCompatActivity {

    private RecyclerView recyclerView;
    private DrinkMockData data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);

        data = DrinkMockData.getInstance();

        recyclerView = (RecyclerView) findViewById(R.id.recycler_drink);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(new DrinkAdapter(data.getData(), this));

        defineActionBar();
    }
}
