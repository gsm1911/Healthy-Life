package com.example.healthy_life.database.model;

public class UsuarioModel {
    public static String TABBLE_NAME = "tb_usuarios";
    public static String
            COLUNA_ID = "_id",
            COLUNA_NOME = "nome",
            COLUNA_EMAIL = "email",
            COLUNA_SENHA = "senha";

    public static String
    CREATE_TABLE = "CREATE TABLE" + TABBLE_NAME
            +"( "
            + COLUNA_ID + " INTERGER PRIMARY KEY AUTOINCREMENTE,"
            + COLUNA_NOME + " TEXT NOT NULL,"
            + COLUNA_EMAIL + " TEXT NOT NULL,"
            + COLUNA_SENHA + " TEXT NOT NULL"
            + " );";

    public static String
    DROP_TABLE = "DROP TABLE IF EXISTS " +TABBLE_NAME;


}
