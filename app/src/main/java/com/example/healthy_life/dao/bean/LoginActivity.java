package com.example.healthy_life.dao.bean;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.Nullable;
import com.example.healthy_life.R;

public class LoginActivity extends Activity {

    private EditText editEmailAcesso;
    private EditText editSenhaAcesso;
    private Button btnLogin;
    private Button btnCriarConta;

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
}
