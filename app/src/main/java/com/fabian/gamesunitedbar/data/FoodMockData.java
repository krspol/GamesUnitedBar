package com.fabian.gamesunitedbar.data;

import com.fabian.gamesunitedbar.model.Food;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Fabian Polkosnik on 27.06.2017.
 */

public class FoodMockData {

    private static FoodMockData instance;
    private List<Food> data;

    public static FoodMockData getInstance(){
        if(instance == null)
            return new FoodMockData();
        return instance;
    }

    private FoodMockData(){
        data = new ArrayList<>();
        initData();
    }

    private void initData() {
        data.add(new Food("http://www.pngall.com/wp-content/uploads/2016/05/Burger-PNG-HD.png", "Burger", "Chrupicy z kurczakiem zajebisty", 19.99, true));
        data.add(new Food("http://www.pngall.com/wp-content/uploads/2016/05/Burger-PNG-HD.png", "Burger", "Chrupicy z kurczakiem zajebisty", 19.99, true));

    }

    public List<Food> getData(){
        return data;
    }


}
