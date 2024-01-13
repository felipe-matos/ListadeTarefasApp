package com.example.listadetarefasapp.database

import android.content.ContentValues
import android.content.Context
import android.util.Log
import com.example.listadetarefasapp.model.Tarefa

class TarefaDAO(context : Context) : ITarefaDAO {

    private val escrita = DatabaseHelper(context).writableDatabase
    private val leitura = DatabaseHelper(context).readableDatabase
    override fun salvar(tarefa: Tarefa): Boolean {

        val conteudos = ContentValues()
        conteudos.put("${DatabaseHelper.ID_DESCRICAO}",tarefa.descricao)

        try {

            escrita.insert(
                DatabaseHelper.NOME_TABELA_TAREFAS,
                null,
                conteudos
            )
            Log.i("info_db", "Sucesso ao criar tarefa ")
        }catch (  e:Exception){
            e.printStackTrace()
            Log.i("info_db", "Error ao criar tarefa ")
            return false
        }
        return true
    }

    override fun atualizar(tarefa: Tarefa): Boolean {
        TODO("Not yet implemented")
    }

    override fun remover(idTarefa: Int): Boolean {
        TODO("Not yet implemented")
    }

    override fun listar(): List<Tarefa> {
        TODO("Not yet implemented")
    }
}