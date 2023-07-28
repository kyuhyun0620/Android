package com.himedia.proj11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById( R.id.button ) ;
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent( getApplicationContext(), MainActivity.class ) ;
                startActivity( intent ) ;
            }
        });
    }

    @Override
    protected void onResume()
    {
        super.onResume() ;

        println( "onResume 호출됨" ) ;
    }

    public void println( String data )
    {
        Toast.makeText(this, data, Toast.LENGTH_LONG ).show() ;
        Log.d( "Main", data ) ;
    }

}