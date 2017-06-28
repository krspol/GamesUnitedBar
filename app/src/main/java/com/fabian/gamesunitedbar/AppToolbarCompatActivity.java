package com.fabian.gamesunitedbar;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.mikepenz.actionitembadge.library.ActionItemBadge;
import com.mikepenz.fontawesome_typeface_library.FontAwesome;

/**
 * Created by Fabian Polkosnik on 28.06.2017.
 */

public abstract class AppToolbarCompatActivity
        extends AppCompatActivity {

    public static int productsInCart = 0;

    // manages menu
    // if there is no products in cart - icon disapears
    // else it shows icon and value of products
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);

        if (productsInCart > 0)
            ActionItemBadge.update(this, menu.findItem(R.id.item_checkout), FontAwesome.Icon.faw_shopping_cart, ActionItemBadge.BadgeStyles.RED, productsInCart);
        else
            ActionItemBadge.hide(menu.findItem(R.id.item_checkout));

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        // on checkout button clicked
        // opens new CheckoutActivity
        if (id == R.id.item_checkout) {
            Intent intent = new Intent(this, CheckoutActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    // defines menu bar
    protected void defineActionBar(){
        ActionBar ab = getSupportActionBar();

        if (ab != null) {
            ab.setDisplayUseLogoEnabled(true);
            ab.setTitle("Games United Bar");
            ab.show();
        }
    }

}
