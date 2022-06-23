package com.e.databasedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class InsertDemo extends AppCompatActivity {
 EditText iph,ipw,iem;
 Button store;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_demo);
        iph=findViewById(R.id.iph);
        iem=findViewById(R.id.iem);
        ipw=findViewById(R.id.ipw);
        store=findViewById(R.id.store);
        store.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
           StoreHelper sh=new StoreHelper(InsertDemo.this);
           sh.insert(iph.getText().toString(),iem.getText().toString(),ipw.getText().toString());
         }
        });
    }
}