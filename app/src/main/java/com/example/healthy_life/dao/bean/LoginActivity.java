package com.example.healthy_life.dao.bean;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.healthy_life.R;

public class LoginActivity extends AppCompatActivity {

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

         btnCriarConta = findViewById(R.id.btnCriarConta);


    }
}
