package com.fabian.gamesunitedbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.fabian.gamesunitedbar.adapter.FoodAdapter;
import com.fabian.gamesunitedbar.adapter.MenuItemAdapter;
import com.fabian.gamesunitedbar.data.FoodMockData;
import com.fabian.gamesunitedbar.data.MenuItems;
import com.fabian.gamesunitedbar.model.Food;

import java.util.List;

public class FoodActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private FoodMockData data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        data = FoodMockData.getInstance();

        recyclerView = (RecyclerView) findViewById(R.id.recycler_food);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(new FoodAdapter(data.getData(), this));

    }
}
