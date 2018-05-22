package com.sheygam.java_19_18_05_18;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.sheygam.java_19_18_05_18.view.login.LoginFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.root,new LoginFragment())
                .commit();
    }
}
