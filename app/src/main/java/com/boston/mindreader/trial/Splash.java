package com.boston.mindreader.trial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        Thread tr = new Thread() {
            public void run() {
                try {
                    sleep(2000);
                } catch (Exception e) {
                } finally {
                    Intent intent = new Intent(Splash.this, Menu.class);
                    startActivity(intent);
                    finish();
                }
            }
        };
        tr.start();
    }
}
