package com.fabian.gamesunitedbar.data;

import com.fabian.gamesunitedbar.MainActivity;
import com.fabian.gamesunitedbar.R;
import com.fabian.gamesunitedbar.model.MenuItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Fabian Polkosnik on 26.06.2017.
 */

public class MenuItems {

    private static MenuItems instance;
    private List<MenuItem> data;

    public static MenuItems getInstance(){
        if(instance == null)
            return new MenuItems();
        return instance;
    }

    private MenuItems(){
        data = new ArrayList<>();

        loadMenuItems();
    }

    private void loadMenuItems(){

        data.add(new MenuItem("Order food", "http://vignette2.wikia.nocookie.net/cswikia/images/8/8d/Csgo-knife-m9-bayonet-fade.png/revision/latest?cb=20131115142834"));
        data.add(new MenuItem("Order drinks", "https://t0.rbxcdn.com/64ed207a782cf3b6f11525d6a589e2d7"));
        data.add(new MenuItem("Book a table", "https://t0.rbxcdn.com/64ed207a782cf3b6f11525d6a589e2d7"));
    }

    public List<MenuItem> getData(){
        return data;
    }


}
