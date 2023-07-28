package com.himedia.proj01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;

public class MainActivity extends AppCompatActivity
{
    ImageView imageView ;

    ScrollView scrollView ;

    BitmapDrawable bitmap ;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState) ;
        setContentView(R.layout.activity_main) ;

        imageView = findViewById( R.id.imageView ) ;
        scrollView = findViewById( R.id.scrollView ) ;
        scrollView.setHorizontalFadingEdgeEnabled( true ) ;

        Resources res = getResources() ;
        bitmap = ( BitmapDrawable ) res.getDrawable( R.drawable.image01 ) ;
        int bitmapWidth = bitmap.getIntrinsicWidth() ;
        int bitmapHeight = bitmap.getIntrinsicHeight() ;

        imageView.setImageDrawable( bitmap ) ;
        imageView.getLayoutParams().width = bitmapWidth ;
        imageView.getLayoutParams().height = bitmapHeight ;
    }

    public void onButtonClicked(View v )
    {
        changeImage() ;
    }

    private void changeImage()
    {
        Resources res = getResources() ;
//  클릭해서 이미지 계속 변경 가능하도록
//        if( flag == 0 ) {
//            flag = 1 ;
//            bitmap = (BitmapDrawable) res.getDrawable(R.drawable.image01);
//        } else {
//            flag = 0 ;
//            bitmap = (BitmapDrawable) res.getDrawable(R.drawable.image02);
//        }
        bitmap = ( BitmapDrawable ) res.getDrawable( R.drawable.image02 ) ;
        int bitmapWidth = bitmap.getIntrinsicWidth() ;
        int bitmapHeight = bitmap.getIntrinsicHeight() ;

        imageView.setImageDrawable( bitmap ) ;
        imageView.getLayoutParams().width = bitmapWidth ;
        imageView.getLayoutParams().height = bitmapHeight ;
    }
}