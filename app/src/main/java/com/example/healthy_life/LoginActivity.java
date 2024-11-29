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

public class LoginActivity extends Activity {

    private EditText editEmailAcesso;
    private EditText editSenhaAcesso;
    private Button btnLogin;
    private Button btnCriarConta;

    private UsuarioDao usuarioDao;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.fragment_login);

         editEmailAcesso = findViewById(R.id.editEmailAcesso);

         editSenhaAcesso = findViewById(R.id.editSenhaAcesso);

         btnLogin = findViewById(R.id.btnLogin);
         btnLogin.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

                 if (editEmailAcesso.getText().toString().isEmpty()){
                     alertDialogShow( "Campo obrigatório");

                 }
                 else if (editSenhaAcesso.getText().toString().isEmpty()){
                     alertDialogShow( "Campo obrigatório");
                 }
                 else {

                     UsuarioModel usuarioModel = new UsuarioModel();
                     usuarioModel.setEmail(editEmailAcesso.getText().toString());
                     usuarioModel.setSenha(editSenhaAcesso.getText().toString());
                     usuarioDao = new UsuarioDao(LoginActivity.this);
                     if(usuarioDao.select(usuarioModel)){
                         startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                     }
                     else{
                         alertDialogShow( "Usuario ou senha invalidos");

                     }

                 }

             }
         });

         btnCriarConta = findViewById(R.id.btnCriarConta);
         btnCriarConta.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent it = new Intent(LoginActivity.this, RegistroActivity.class);
                 startActivity(it);
             }
         });

    }
    private void alertDialogShow(final String mensagem){

        AlertDialog.Builder alert = new AlertDialog.Builder(LoginActivity.this);
        alert.setTitle("Erro");
        alert.setIcon(ContextCompat.getDrawable(LoginActivity.this, R.drawable.bg_edit_botton));
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
