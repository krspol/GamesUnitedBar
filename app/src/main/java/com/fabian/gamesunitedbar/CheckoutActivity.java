package com.fabian.gamesunitedbar.model;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.fabian.gamesunitedbar.R;
import com.fabian.gamesunitedbar.data.Cart;


public class CheckoutActivity extends AppCompatActivity {

    private Cart checkoutCart;

    private TextView checkoutText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        checkoutCart = Cart.getInstance();

        checkoutText = (TextView) findViewById(R.id.checkout_list);
        checkoutText.setText(checkoutCart.getCart().toString());
    }
}
