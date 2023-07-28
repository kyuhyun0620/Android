package com.himedia.exam05;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity
{
    public static final int REQUEST_CODE_MENU = 1001 ;

    EditText usernameInput ;
    EditText passwordInput ;

    @Override
    protected void onCreate( Bundle savedInstanceSate )
    {
        super.onCreate( savedInstanceSate ) ;
        setContentView( R.layout.activity_login ) ;

        Button loginButton = findViewById( R.id.loginButton ) ;
        loginButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                String username = usernameInput.getText().toString() ;
                String password = passwordInput.getText().toString() ;

                Intent intent = new Intent( getApplicationContext(), MenuActivity.class ) ;
                intent.putExtra( "username", username ) ;
                intent.putExtra( "password", password) ;

                startActivityForResult( intent, REQUEST_CODE_MENU ) ;
            }
        });

        usernameInput = findViewById( R.id.usernameInput ) ;
        passwordInput = findViewById( R.id.passwordInput ) ;

    }
    protected  void onActivityResult( int RequestCode, int resultCode, Intent intent )
    {
        super.onActivityResult( RequestCode, resultCode, intent ) ;

        if( resultCode == REQUEST_CODE_MENU )
        {
            if ( intent != null )
            {
                String menu = intent.getStringExtra( "menu" ) ;
                String message = intent.getStringExtra( "message" ) ;

                Toast toast = Toast.makeText( getBaseContext(), "result code" + resultCode + ", menu : " + menu +
                        " , message : " + message, Toast.LENGTH_LONG ) ;
                toast.show() ;
            }
        }
    }

}