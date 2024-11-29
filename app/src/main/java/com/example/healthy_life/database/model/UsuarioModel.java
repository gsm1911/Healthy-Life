package com.example.healthy_life.database.model;

public class UsuarioModel {
    public static String TABLE_NAME = "tb_usuarios";
    public static String
            COLUNA_ID = "_id",
            COLUNA_NOME = "nome",
            COLUNA_EMAIL = "email",
            COLUNA_SENHA = "senha";
    private long id;
    private String nome, email, senha;

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public static String
    CREATE_TABLE = "CREATE TABLE" + TABLE_NAME
            +"( "
            + COLUNA_ID + " INTERGER PRIMARY KEY AUTOINCREMENTE,"
            + COLUNA_NOME + " TEXT NOT NULL,"
            + COLUNA_EMAIL + " TEXT NOT NULL,"
            + COLUNA_SENHA + " TEXT NOT NULL"
            + " );";

    public static String
    DROP_TABLE = "DROP TABLE IF EXISTS " +TABLE_NAME;


}
