package com.example.lifecycledemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    Button bt_click;
    TextView tv_counter;

    int clicks = 0;

    //Saves the value of clicks into a temp storage loc
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState)
    {
        super.onSaveInstanceState(outState);
        outState.putInt("clickervalue", clicks);
    }

    //Reinstate the clicks value on restore
    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        clicks = savedInstanceState.getInt("clickervalue");
        tv_counter = findViewById(R.id.tv_counter);
        tv_counter.setText(Integer.toString(clicks));
    }

    @Override
    protected void onStart()
    {
        super.onStart();
        Log.d("lifecycle", "The app has started.");
    }

    @Override
    protected void onStop()
    {
        super.onStop();
        Log.d("lifecycle", "The app has stopped.");
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        Log.d("lifecycle", "The app has been destroyed.");
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        Log.d("lifecycle", "The app is paused.");
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        Log.d("lifecycle", "The app has resumed.");
    }

    @Override
    protected void onRestart()
    {
        super.onRestart();
        Log.d("lifecycle", "The app has restarted.");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("lifecycle", "The app has been created.");

        bt_click = (Button) findViewById(R.id.bt_click);
        tv_counter = (TextView) findViewById(R.id.tv_counter);

        bt_click.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                clicks++;
                tv_counter.setText(Integer.toString(clicks));
            }
        });
    }
}