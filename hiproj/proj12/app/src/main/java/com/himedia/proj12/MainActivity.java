package com.himedia.proj12;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity
{
    MainFragment mainFragment ;

    MenuFragment menuFragment ;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainFragment = ( MainFragment) getSupportFragmentManager().findFragmentById( R.id.mainFragment ) ;
        menuFragment = new MenuFragment() ;
    }

    onFra
}