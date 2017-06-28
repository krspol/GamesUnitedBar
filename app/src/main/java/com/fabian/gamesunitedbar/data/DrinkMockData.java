package com.fabian.gamesunitedbar.data;

import com.fabian.gamesunitedbar.model.Drink;
import com.fabian.gamesunitedbar.model.Food;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Fabian Polkosnik on 28.06.2017.
 */

public class DrinkMockData {

    private static DrinkMockData instance;
    private List<Drink> data;


    public static DrinkMockData getInstance(){
        if(instance == null)
            return new DrinkMockData();
        return instance;
    }

    private DrinkMockData(){
        data = new ArrayList<>();
        data.add(new Drink("http://oohmagazine.pl/upload/news/tyskie-logo.png", "Piwo - Tyskie", 500, 5.55));
        data.add(new Drink("http://2.bp.blogspot.com/-azo2qsj6dKo/VV34kyMWUzI/AAAAAAAAChE/BPOT1FphKGY/s1600/Carlsberg-logo-vector.png", "Piwo - Carlsberg", 500, 2.55));
        data.add(new Drink("https://warka-tomaszow.pl/wp-content/themes/warka/images/logo.png", "Piwo - Warka", 500, 2.55));
    }

    public List<Drink> getData(){
        return data;
    }



}
