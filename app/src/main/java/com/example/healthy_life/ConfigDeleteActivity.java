package com.example.healthy_life;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.healthy_life.database.dao.UsuarioDao;
import com.example.healthy_life.database.model.UsuarioModel;

public class ConfigDeleteActivity extends Activity {
    private Button btnDeletarConta;
    private EditText editTextIdDoUsuario;
    private UsuarioDao usuarioDao;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_config_delete);

        editTextIdDoUsuario = findViewById(R.id.editTextIdDoUsuario);
        btnDeletarConta = findViewById(R.id.btnDeletarConta);

        btnDeletarConta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    usuarioDao.Open();
                    long id = Long.parseLong(editTextIdDoUsuario.getText().toString());
                    boolean deleted = usuarioDao.deletarUsuario(id);
                    if (deleted) {
                        Toast.makeText(ConfigDeleteActivity.this, "Usuário deletado!", Toast.LENGTH_SHORT).show();

                        Intent it = new Intent(ConfigDeleteActivity.this, LoginActivity.class);
                        startActivity(it);

                    } else {
                        Toast.makeText(ConfigDeleteActivity.this, "Erro ao deletar usuário.", Toast.LENGTH_SHORT).show();
                    }
                    usuarioDao.Close();
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(ConfigDeleteActivity.this, "Erro ao deletar usuário.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

