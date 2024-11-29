package com.example.healthy_life.database.dao;

import android.content.ContentValues;
import android.content.Context;

import com.example.healthy_life.database.DBOpenHelper;
import com.example.healthy_life.database.model.UsuarioModel;

public class UsuarioDao extends AbstractDao {

    public UsuarioDao(Context context){
     helper = new DBOpenHelper(context);
    }
    public long insert(final UsuarioModel usuarioModel){

        long resultado= -1;

        try{
            Open();

            ContentValues values = new ContentValues();
            values.put(UsuarioModel.COLUNA_NOME,usuarioModel.getNome());
            values.put(UsuarioModel.COLUNA_EMAIL,usuarioModel.getEmail());
            values.put(UsuarioModel.COLUNA_SENHA,usuarioModel.getSenha());

            resultado = db.insert(UsuarioModel.TABLE_NAME,null,values);
        }
        finally {
            Close();
        }

        return resultado;
    }

}
