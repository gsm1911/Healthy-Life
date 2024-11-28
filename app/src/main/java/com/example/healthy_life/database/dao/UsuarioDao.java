package com.example.healthy_life.database.dao;

import android.content.Context;

import com.example.healthy_life.database.DBOpenHelper;

public class UsuarioDao extends AbstractDao {

    public UsuarioDao(Context context){
     helper = new DBOpenHelper(context);
    }

}
