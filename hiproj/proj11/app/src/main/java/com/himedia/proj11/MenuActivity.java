package com.himedia.proj11;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu) ;
        Toast.makeText(this,"onCreate 호출됨", Toast.LENGTH_LONG ).show() ;
    }

    @Override
    protected void onStart()
    {
        super.onStart();
        Toast.makeText(this, "onStart 호출됨", Toast.LENGTH_LONG ).show() ;
    }

    @Override
    protected void onStop()
    {
        super.onStop() ;
        Toast.makeText(this, "onStop 호출됨", Toast.LENGTH_LONG ).show() ;
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy() ;
        Toast.makeText(this, "onDestroy", Toast.LENGTH_LONG ).show() ;
    }

    @Override
    protected void onPause()
    {
        super.onPause() ;
        Toast.makeText(this, "onPause 호출됨", Toast.LENGTH_LONG ).show() ;
    }

    @Override
    protected void onResume()
    {
        super.onResume() ;
        Toast.makeText(this, "onResume 호출됨", Toast.LENGTH_LONG ).show() ;
    }
}