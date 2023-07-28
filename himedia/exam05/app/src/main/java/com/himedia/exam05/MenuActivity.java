package com.himedia.exam05;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity ;

public class MenuActivity extends AppCompatActivity
{
    public  static final int REQUEST_CODE_OK = 200 ;

    @Override
    protected void  onCreate( Bundle savedInstanceState )
    {
        super.onCreate( savedInstanceState ) ;
        setContentView( R.layout.activity_menu ) ;

        Intent receiveIntent = getIntent() ;
        String username = receiveIntent.getStringExtra( "username" ) ;
        String password = receiveIntent.getStringExtra( "password" ) ;

        Toast.makeText( this, "username : " + username + " , password : " + password,
                Toast.LENGTH_SHORT ).show() ;

        Button menu01_button = findViewById( R.id.menu01_button ) ;

        menu01_button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent resultIntent = new Intent() ;
                resultIntent.putExtra( "menu", "고객 관리 메뉴" ) ;
                resultIntent.putExtra( "message", "Result Message is On" ) ;

                setResult( Activity.RESULT_OK, resultIntent ) ;
                finish() ;
            }
        }) ;

        Button menu02_button = findViewById( R.id.menu02_button ) ;

        menu02_button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent resultIntent = new Intent() ;
                resultIntent.putExtra( "menu", "매출 관리 메뉴" ) ;
                resultIntent.putExtra( "message", "Result Message is On" ) ;

                setResult( Activity.RESULT_OK, resultIntent ) ;
                finish() ;
            }
        }) ;

        Button menu03_button = findViewById( R.id.menu03_button ) ;

        menu03_button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent resultIntent = new Intent() ;
                resultIntent.putExtra( "menu", "상품 관리 메뉴" ) ;
                resultIntent.putExtra( "message", "Result Message is On" ) ;

                setResult( Activity.RESULT_OK, resultIntent ) ;
                finish() ;
            }
        }) ;
    }
}
