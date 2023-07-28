package com.himedia.exam03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.UnsupportedEncodingException;

public class MainActivity extends AppCompatActivity
{

    EditText inputMessage ;

    TextView inputCount ;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputMessage = findViewById( R.id.inputMessage ) ;
        inputCount = findViewById( R.id.inputCount ) ;

        Button sendButton  = findViewById( R.id.sendButton ) ;
        sendButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick( View v )
            {
                String message = inputMessage.getText().toString() ;
                Toast.makeText( getApplicationContext(), "전송할 메세지\n\n" + message, Toast.LENGTH_LONG ).show();
            }
        });

        Button closeButton = findViewById( R.id.closeButton ) ;
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick( View v )
            {
                finish() ;
            }
        });

        TextWatcher watcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {
            }

            @Override
            public void onTextChanged(CharSequence str, int start, int before, int count)
            {
                byte[] bytes = null;
                try{
                    bytes = str.toString().getBytes("KSC5601");
                    int strCount = bytes. length;
                    inputCount.setText(strCount + " / 80 바이트");
                } catch (UnsupportedEncodingException ex){
                    ex.printStackTrace();
                }
            }

            @Override
            public void afterTextChanged(Editable editable)
            {
                String str = editable.toString() ;
                try
                {
                    byte[] strBytes = str.getBytes( "KSC5601" ) ;
                    if ( strBytes.length > 80 )
                    {
                        editable.delete(editable.length() - 2, editable.length() - 1);
                    }
                } catch ( Exception ex )
                {
                    ex.printStackTrace() ;
                }
            }
        } ;
        inputMessage.addTextChangedListener(watcher);
    }
}