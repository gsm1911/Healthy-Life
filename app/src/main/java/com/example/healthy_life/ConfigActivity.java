package com.example.healthy_life;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import com.example.healthy_life.database.dao.UsuarioDao;
import com.example.healthy_life.database.model.UsuarioModel;

public class ConfigActivity extends Activity {
    private Button btnDelete;

    private Button btnAtualizarSenha;
    private EditText editSenhaAntiga;
    private EditText editSenhaNova;

    private UsuarioDao usuarioDao;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_config);

        btnAtualizarSenha = findViewById(R.id.btnAtualizarSenha);
        btnAtualizarSenha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (editSenhaAntiga.getText().toString().isEmpty()){
                    alertDialogShow( "Campo obrigatório");

                }
                else if (editSenhaNova.getText().toString().isEmpty()){
                    alertDialogShow( "Campo obrigatório");
                }
                else {

                    UsuarioModel usuarioModel = new UsuarioModel();
                    usuarioModel.setSenha(editSenhaNova.getText().toString());
                    usuarioDao = new UsuarioDao(ConfigActivity.this);
                    if(usuarioDao.select(usuarioModel)){
                        startActivity(new Intent(ConfigActivity.this, HomeActivity.class));
                    }
                    else{
                        alertDialogShow( "Usuario ou senha invalidos");

                    }

                }

            }
        });

    }
    private void alertDialogShow(final String mensagem){

        AlertDialog.Builder alert = new AlertDialog.Builder(ConfigActivity.this);
        alert.setTitle("Erro");
        alert.setIcon(ContextCompat.getDrawable(ConfigActivity.this, R.drawable.bg_edit_botton));
        alert.setMessage(mensagem);
        alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        alert.create().show();

    }
}

