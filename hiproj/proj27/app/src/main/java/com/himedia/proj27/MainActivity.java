package com.himedia.proj27;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{

    RecyclerView recyclerView ;
    PersonAdapter adapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        GridLayoutManager layoutManager = new GridLayoutManager(this,2 ) ;
        recyclerView.setLayoutManager(layoutManager);

        adapter = new PersonAdapter() ;

        adapter.addItem(new Person("김민수", "010-1000-1000"));
        adapter.addItem(new Person("김하늘", "010-2000-2000"));
        adapter.addItem(new Person("홍길동", "010-3000-3000"));
        adapter.addItem(new Person("이름1", "010-4000-4000"));
        adapter.addItem(new Person("이름2", "010-5000-5000"));
        adapter.addItem(new Person("이름3", "010-6000-6000"));
        adapter.addItem(new Person("이름4", "010-7000-7000"));
        adapter.addItem(new Person("이름5", "010-8000-8000"));
        adapter.addItem(new Person("이름6", "010-9000-9000"));

        recyclerView.setAdapter( adapter ) ;

        adapter.setOnItemClickListener(new OnPersonItemClickListener()
        {
            @Override
            public void onItemClick(PersonAdapter.ViewHolder holder, View view, int position)
            {
                Person item = adapter.getItem( position ) ;
                Toast.makeText(getApplicationContext(), "아이템 선택됨: " + item.getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}