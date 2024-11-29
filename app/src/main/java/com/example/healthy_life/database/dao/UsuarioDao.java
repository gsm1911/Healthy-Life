package com.example.healthy_life.database.dao;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;

import androidx.core.content.ContextCompat;

import com.example.healthy_life.LoginActivity;
import com.example.healthy_life.R;
import com.example.healthy_life.database.DBOpenHelper;
import com.example.healthy_life.database.model.UsuarioModel;

public class UsuarioDao extends AbstractDao {


    private String [] colunas = new String[]{
            UsuarioModel.COLUNA_ID,
            UsuarioModel.COLUNA_EMAIL,
            UsuarioModel.COLUNA_SENHA
    };
    public UsuarioDao(Context context){
     helper = new DBOpenHelper(context);
    }

    public boolean select(final UsuarioModel usuarioModel){


        try{
            Open();
            Cursor cursor = db.query(UsuarioModel.TABLE_NAME, colunas, UsuarioModel.COLUNA_EMAIL + " = ? AND "
                    + UsuarioModel.COLUNA_SENHA + " = ?", new String[]{usuarioModel.getEmail(), usuarioModel.getSenha()}, null, null, null);
            cursor.moveToFirst();
            return cursor.getCount() > 0;
        }
        finally {
            Close();
        }

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
