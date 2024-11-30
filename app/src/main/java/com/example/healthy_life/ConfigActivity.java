package com.example.healthy_life;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import com.example.healthy_life.database.dao.UsuarioDao;
import com.example.healthy_life.database.model.UsuarioModel;

public class ConfigActivity extends Activity {
    public static String emailUsuario;
    public static String senhaUsuario;
    private Button btnDelete;

    private Button btnAtualizarSenha;
    private EditText editSenhaAntiga;
    private EditText editSenhaNova;

    private UsuarioDao usuarioDao;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_config);

        UsuarioModel usuarioModel = new UsuarioModel();
        usuarioModel.setEmail(emailUsuario);
        usuarioModel.setSenha(senhaUsuario);

        btnDelete = findViewById(R.id.btnDelete);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(ConfigActivity.this, ConfigDeleteActivity.class);
                startActivity(it);
            }
        });

        editSenhaAntiga = findViewById(R.id.editSenhaAntiga);
        editSenhaNova = findViewById(R.id.editSenhaNova);
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
                else if(!editSenhaAntiga.getText().toString().equals(senhaUsuario)){
                    alertDialogShow("Senha incorreta.");
                }
                else if(editSenhaNova.getText().toString().equals(senhaUsuario)){
                    alertDialogShow("A senha nova não pode ser a mesma que a velha.");
                }
                else {

                    usuarioDao = new UsuarioDao(ConfigActivity.this);
                    if(usuarioDao.atualizarSenha(usuarioModel, editSenhaNova.getText().toString())){
                        senhaUsuario = editSenhaNova.getText().toString();
                        Toast.makeText(ConfigActivity.this, "Senha alterada.", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(ConfigActivity.this, LoginActivity.class));
                    }
                    else{
                        alertDialogShow( "Falha ao alterar senha.");
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

