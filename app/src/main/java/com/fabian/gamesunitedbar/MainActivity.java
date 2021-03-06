package com.fabian.gamesunitedbar;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.facebook.FacebookSdk;
import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Arrays;


public class MainActivity extends AppCompatActivity {

    private static int RC_SIGN_IN = 0;

    private FirebaseAuth auth;

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseAuth.getInstance().signOut();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_main);

         auth = FirebaseAuth.getInstance();

        if(auth.getCurrentUser() != null){
            Log.d("AUTH", auth.getCurrentUser().getEmail());
        }else{
            startActivityForResult(
                    AuthUI.getInstance()
                            .createSignInIntentBuilder()
                            .setAvailableProviders(
                                    Arrays.asList(new AuthUI.IdpConfig.Builder(AuthUI.EMAIL_PROVIDER).build(),
                                            new AuthUI.IdpConfig.Builder(AuthUI.GOOGLE_PROVIDER).build(),
                                            new AuthUI.IdpConfig.Builder(AuthUI.FACEBOOK_PROVIDER).build() ))
                            .setTheme(R.style.AuthTheme)
                            .build(),
                    RC_SIGN_IN);
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == RC_SIGN_IN){
            if(resultCode == RESULT_OK){
                // user log in
                Log.d("AUTH", "user already logged in");
            }else{
                // user not authenticated
                Log.d("AUTH", "user not authenticated");

            }
        }
    }

    public void onSignOutClick(View view){
        AuthUI.getInstance().signOut(this).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                Log.d("AUTH", "User logged out");
                finish();
            }
        });
    }
}
