package com.example.healthy_life.database.dao;

import android.database.sqlite.SQLiteDatabase;

import com.example.healthy_life.database.DBOpenHelper;

public abstract class AbstractDao {

    protected SQLiteDatabase db;
    protected DBOpenHelper helper;

    protected final void Open(){
        db = helper.getWritableDatabase();
    }
    protected  final  void Close(){
        helper.close();
    }

}
