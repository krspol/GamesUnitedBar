package com.fabian.gamesunitedbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Map;


public class CheckoutActivity extends AppCompatActivity {

    private TextView checkoutText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);


        checkoutText = (TextView) findViewById(R.id.checkout_list);
        checkoutText.setText(getProducts());
    }

    private String getProducts(){
        // TODO get cart from SQLLite

        return null;
    }
}
