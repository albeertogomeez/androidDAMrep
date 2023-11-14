package com.example.firstprojectandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("Test", "Mensaje que sale desde onCreate");
    }

    protected void onStart() {
        super.onStart();
        setContentView(R.layout.activity_main);
        Log.i("TestStart", "Mensaje que sale desde onStart");
    }

    protected void onPause() {
        super.onPause();
        setContentView(R.layout.activity_main);
        Log.i("TestPause", "Mensaje que sale desde onPause");
    }

    protected void onResume() {
        super.onResume();
        setContentView(R.layout.activity_main);
        Log.i("TestResume", "Mensaje que sale desde onResume");
    }

    protected void onStop() {
        super.onStop();
        setContentView(R.layout.activity_main);
        Log.i("TestStop", "Mensaje que sale desde onStop");
    }

    protected void onDestroy() {
        super.onDestroy();
        setContentView(R.layout.activity_main);
        Log.i("TestDestroy", "Mensaje que sale desde onDestroy");
    }


}