package com.himedia.proj08;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_menu ) ;

        Button button = findViewById( R.id.button ) ;
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent() ;
                intent.putExtra( "name", "mike" ) ;
                setResult( RESULT_OK, intent ) ;
                finish() ;
            }
        });
    }
}