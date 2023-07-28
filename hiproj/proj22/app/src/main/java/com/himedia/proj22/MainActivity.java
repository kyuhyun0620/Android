package com.himedia.proj22;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.security.Permission;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AndPermission.with( this )
                .runtime()
                .permission(Permission.RECEIVE_SMS )
                .onGranted( new Action < List < String >> ()
                {
                    onAction

                })
    }
}