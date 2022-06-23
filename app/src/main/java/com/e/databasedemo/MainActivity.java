package com.e.databasedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
   Button gti,gtd,gtu,gtv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gti=findViewById(R.id.gti);
        gtd=findViewById(R.id.gtd);
        gtu=findViewById(R.id.gtu);
        gtv=findViewById(R.id.gtv);
        gti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,InsertDemo.class);
                startActivity(i);
            }
        });
        gtd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,DeleteDemo.class);
                startActivity(i);
            }
        });
        gtu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,UpdateDemo.class);
                startActivity(i);
            }
        });
        gtv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,DisplayDemo.class);
                startActivity(i);
            }
        });



    }
}