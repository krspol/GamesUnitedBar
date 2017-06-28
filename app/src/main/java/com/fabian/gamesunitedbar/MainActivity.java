package com.fabian.gamesunitedbar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.fabian.gamesunitedbar.adapter.MenuItemAdapter;
import com.fabian.gamesunitedbar.data.MenuItems;
import com.facebook.FacebookSdk;
import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Arrays;

// check if user is logged, if not
// he can log in using Facebook or Google account
//
// if logged - shows main menu
public class MainActivity extends AppToolbarCompatActivity {

    private static int RC_SIGN_IN = 0;

    private FirebaseAuth auth;

    private MenuItems data;

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FacebookSdk.sdkInitialize(getApplicationContext());

        setContentView(R.layout.activity_main);
        defineActionBar();

        auth = FirebaseAuth.getInstance();

        // check if user is already logged
        if(auth.getCurrentUser() != null)
            Log.d("AUTH", auth.getCurrentUser().getEmail());
        else
            // gives possibility to log in through Facebook/Google account
            startActivityForResult(
                    AuthUI.getInstance()
                            .createSignInIntentBuilder()
                            .setAvailableProviders(
                                    Arrays.asList(
                                            new AuthUI.IdpConfig.Builder(AuthUI.GOOGLE_PROVIDER).build(),
                                            new AuthUI.IdpConfig.Builder(AuthUI.FACEBOOK_PROVIDER).build() ))
                            .setTheme(R.style.AuthTheme)
                            .build(),
                    RC_SIGN_IN);

        // gets mock data
        data = MenuItems.getInstance();

        // defines and implement RecyclerView
        recyclerView = (RecyclerView) findViewById(R.id.main_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(new MenuItemAdapter(data.getData(), this));

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // checks if user is authorized or not
        if(requestCode == RC_SIGN_IN){
            if(resultCode == RESULT_OK)
                Log.d("AUTH", "user already logged in");
            else
                Log.d("AUTH", "user not authenticated");
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        // products in cart must be updated
        invalidateOptionsMenu();
    }
}
