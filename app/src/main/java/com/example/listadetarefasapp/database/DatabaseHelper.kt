package com.example.listadetarefasapp.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class DatabaseHelper(context : Context): SQLiteOpenHelper(
        context , NOME_BANCO_DADOS , null , 1
) {

    companion object{
        const val NOME_BANCO_DADOS = "ListaTarefas.db"
        const val  VERSAO = 1
        const val  NOME_TABELA_TAREFAS = "tarefas"
        const val  ID_TAREFA = "id_tarefas"
        const val  ID_DESCRICAO = "descricao"
        const val  DATA_CADASTRO = "data_cadastro"
    }

    override fun onCreate(db: SQLiteDatabase?) {

        val sql = "CREATE TABLE IF NOT EXISTS $NOME_TABELA_TAREFAS (" +
                "$ID_TAREFA INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                "$ID_DESCRICAO VARCHAR (70)," +
                "$DATA_CADASTRO DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP" +
                ");"

        try {

            db?.execSQL(sql)
            Log.i("info_db", "Sucesso ao criar tarefa ")
        }catch (  e:Exception){
            e.printStackTrace()
            Log.i("info_db", "Error ao criar tarefa ")
        }
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {

    }


}