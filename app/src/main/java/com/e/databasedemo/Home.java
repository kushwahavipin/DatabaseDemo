package com.e.databasedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Home extends AppCompatActivity {
 ListView showtabledata;
 StoreHelper sh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        showtabledata=findViewById(R.id.showtabledata);
        sh=new StoreHelper(Home.this);
        ArrayAdapter ad=new ArrayAdapter(Home.this, android.R.layout.simple_list_item_1,sh.showusers().get("phone"));
        showtabledata.setAdapter(ad);
        showtabledata.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(Home.this, ""+sh.showusers().get("pass").get(i), Toast.LENGTH_SHORT).show();
            }
        });

    }
}