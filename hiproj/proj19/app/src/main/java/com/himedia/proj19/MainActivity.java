package com.himedia.proj19;


import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity
    implements NavigationView.OnNavigationItemSelectedListener, FragmentCallBack
{
    Fragment1 fragment1 ;
    Fragment2 fragment2 ;
    Fragment3 fragment3 ;

    DrawerLayout drawerLayout ;
    Toolbar toolbar ;

    @Override
    protected void onCreate( Bundle savedInstanceState )
    {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_main ) ;

        toolbar = findViewById( R.id.toolbar ) ;
        setSupportActionBar( toolbar ) ;

        drawerLayout = findViewById( R.id.drawer_layout ) ;
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle (
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        ) ;
        drawerLayout.addDrawerListener( toggle ) ;
        toggle.syncState() ;

        NavigationView navigationView = findViewById( R.id.nav_view ) ;
        navigationView.setNavigationItemSelectedListener( this ) ;

        fragment1 = new Fragment1() ;
        fragment2 = new Fragment2() ;
        fragment3 = new Fragment3() ;

        getSupportFragmentManager().beginTransaction().add( R.id.container, fragment1 ).commit() ;

    }

    @Override
    public void onBackPressed()
    {
        if (drawerLayout.isDrawerOpen(GravityCompat.START ) )
        {
            drawerLayout.closeDrawer( GravityCompat.START ) ;
        } else
        {
            super.onBackPressed() ;
        }
    }

    public boolean onNavigationItemSelected( MenuItem item )
    {
        int id = item.getItemId() ;

        if ( id == R.id.menu1 )
        {
            Toast.makeText(this, "첫 번째 메뉴 선택됨.", Toast.LENGTH_SHORT).show() ;
            onFragmentSelected( 0, null ) ;
        } else if ( id == R.id.menu2 )
        {
            Toast.makeText(this, "두 번째 메뉴 선택됨.", Toast.LENGTH_SHORT).show() ;
            onFragmentSelected( 1, null ) ;
        } else if ( id == R.id.menu3)
        {
            Toast.makeText(this, "세 번째 메뉴 선택됨.", Toast.LENGTH_SHORT).show() ;
            onFragmentSelected( 2, null ) ;
        }

        drawerLayout.closeDrawer( GravityCompat.START ) ;

        return true ;
    }

    public void onFragmentSelected(int position, Bundle bundle )
    {
        Fragment curFragment = null ;
        if ( position == 0 )
        {
            curFragment = fragment1 ;
            toolbar.setTitle( "첫 번째 화면" ) ;
        } else if ( position == 1 )
        {
            curFragment = fragment2 ;
            toolbar.setTitle( "두 번재 화면" ) ;
        } else if ( position == 2 )
        {
            curFragment = fragment3 ;
            toolbar.setTitle( "세 번째 화면" ) ;
        }

        getSupportFragmentManager().beginTransaction().replace( R.id.container, curFragment).commit() ;
    }
}