package com.fabian.gamesunitedbar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;

import com.fabian.gamesunitedbar.adapter.FoodAdapter;
import com.fabian.gamesunitedbar.data.FoodMockData;

public class FoodActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private FoodMockData data;

    private EditText foodCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        data = FoodMockData.getInstance();

        recyclerView = (RecyclerView) findViewById(R.id.recycler_food);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(new FoodAdapter(data.getData(), this));

        foodCounter = (EditText) findViewById(R.id.food_counter);

    }


    public void increaseCart(View view){

    }

    public void decreaseCart(View view){

    }

    public void onCheckoutClick(View view){

        Intent intent = new Intent(this, CheckoutActivity.class);
        startActivity(intent);
    }
}
