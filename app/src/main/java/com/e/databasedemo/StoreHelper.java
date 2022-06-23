package com.e.databasedemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class StoreHelper extends SQLiteOpenHelper
{
   Context c;
    public StoreHelper(Context context) {
        super(context, "College", null, 1);
        c=context;
    }
    public HashMap<String, ArrayList> showusers()
    {
        SQLiteDatabase db=this.getReadableDatabase(); // read
        String[] cols={"sphone","semail","spwd"};
        HashMap<String, ArrayList> hm=new HashMap<>();
        ArrayList ph,em,pw;
        ph=new ArrayList();
        em=new ArrayList();
        pw=new ArrayList();

        Cursor cur=db.query("student",cols,null,null,null,null,null);
           if(cur.moveToFirst())
               do
               {
                   ph.add(cur.getString(0));
                   em.add(cur.getString(1));
                   pw.add(cur.getString(2));

               }while(cur.moveToNext());
        hm.put("phone",ph);
        hm.put("email",em);
        hm.put("pass",pw);
        db.close();
        return hm;
    }
    public boolean checkuser(String ph,String pw)
    {
        SQLiteDatabase db=this.getReadableDatabase(); // read
        String[] cols={"sphone","semail","spwd"};
        String[] args={ph,pw};

        Cursor cur=db.query("student",cols,"sphone=? and spwd=?",args,null,null,null);

        if(cur.getCount()!=0)
            return true;
        else
            return false;
    }
    public void update(String ph,String pw)
    {
        SQLiteDatabase db=this.getWritableDatabase(); // read write
        String[] args={ph};
        ContentValues cv=new ContentValues();
        cv.put("spwd",pw);
        db.update("student",cv,"sphone=?",args);
        db.close();
    }
    public void delete(String ph)
    {
        SQLiteDatabase db=this.getWritableDatabase(); // read write
        String[] args={ph};
        db.delete("student","sphone=?",args);
        Toast.makeText(c, "Deleted Value", Toast.LENGTH_SHORT).show();
        db.close();
    }
    public void insert(String ph,String em,String pw)
    {
        SQLiteDatabase db=this.getWritableDatabase(); // read write
        ContentValues cv=new ContentValues();
        cv.put("sphone",ph);
        cv.put("semail",em);
        cv.put("spwd",pw);
        db.insert("student",null,cv);
        Toast.makeText(c, "Inserted Perfectly", Toast.LENGTH_SHORT).show();
        db.close();
    }

    public void onCreate(SQLiteDatabase db)
    {
    String t1="create table student(sphone text,semail text,spwd text);";
    db.execSQL(t1);
    }

    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int olds, int news) {

    }
}
