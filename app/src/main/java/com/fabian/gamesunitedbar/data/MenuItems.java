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

        data.add(new MenuItem("Order food", R.drawable.burger));
        data.add(new MenuItem("Order drinks", R.drawable.beer));
        data.add(new MenuItem("Book a table", R.drawable.table));
    }

    public List<MenuItem> getData(){
        return data;
    }


}
