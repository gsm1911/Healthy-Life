package com.example.healthy_life;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;
import androidx.annotation.Nullable;

public class RegistroActivity extends Activity {
    private EditText editNomeRegistro;
    private EditText editEmailRegistro;
    private EditText editConfirmarEmail;
    private EditText editSenhaRegistro;
    private EditText editSenhaConfirma;
    private Button btnCriarConta;

    private Button btnVoltarParaLogin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_register);

        editEmailRegistro = findViewById(R.id.editEmailRegistro);
        editNomeRegistro = findViewById((R.id.editNomeRegistro));
        editSenhaRegistro = findViewById(R.id.editSenhaRegistro);
        editSenhaConfirma = findViewById(R.id.editSenhaConfirma);

        btnCriarConta = findViewById(R.id.btnCriarConta);
        btnCriarConta.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(editEmailRegistro.getText().toString().isEmpty()){
                    mensagemErroApresentar("O E-mail não pode estar vazio.");
                } else if(editSenhaRegistro.getText().toString().isEmpty()){
                    mensagemErroApresentar("A senha não pode estar vazia.");
                } else if (!editSenhaConfirma.getText().toString().equals(editConfirmarEmail.getText().toString())){
                    mensagemErroApresentar("As senhas não coincide.");
                }
            }

            private void mensagemErroApresentar(String s) {
                Toast.makeText(RegistroActivity.this, s, Toast.LENGTH_SHORT).show();
            }
        });

        btnVoltarParaLogin = findViewById(R.id.btnVoltarParaLogin);
        btnVoltarParaLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(RegistroActivity.this, LoginActivity.class);
                startActivity(it);
            }
        });


    }
}
