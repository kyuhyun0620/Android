package com.himedia.proj07;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate( savedInstanceState ) ;


        Button button = findViewById( R.id.button2) ;

        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Toast.makeText( getApplicationContext(),"버튼을 눌렀어요.", Toast.LENGTH_SHORT ).show() ;
            }
        });

        setContentView( R.layout.activity_main ) ;

    }
}