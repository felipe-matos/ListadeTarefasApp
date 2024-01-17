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
        conteudos.put("${DatabaseHelper.ID_DESCRICAO}", tarefa.descricao)

        try {

            escrita.insert(
                DatabaseHelper.NOME_TABELA_TAREFAS,
                null,
                conteudos
            )
            Log.i("info_db", "Sucesso ao criar tarefa ")
        } catch (e: Exception) {
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

        val args = arrayOf(idTarefa.toString())

        try {
            escrita.delete(
                DatabaseHelper.NOME_TABELA_TAREFAS,
                "${DatabaseHelper.ID_TAREFA} = ?",
                args
            )
            Log.i("info_db", "Sucesso ao remover tarefa ")
        } catch (e: Exception) {
            e.printStackTrace()
            Log.i("info_db", "Error ao remover tarefa ")
            return false
        }
        return true
    }


    override fun listar(): List<Tarefa> {

        val listaTarefas = mutableListOf<Tarefa>()

        val sql = "SELECT ${DatabaseHelper.ID_TAREFA},${DatabaseHelper.ID_DESCRICAO}," +
                " strftime( '%d /%m /%Y  %H:%M', ${DatabaseHelper.DATA_CADASTRO}) ${DatabaseHelper.DATA_CADASTRO}" +
                " FROM ${DatabaseHelper.NOME_TABELA_TAREFAS};"

        val cursor = leitura.rawQuery(sql, null)

        val indiceId = cursor.getColumnIndex(DatabaseHelper.ID_TAREFA)
        val indiceDescricao = cursor.getColumnIndex(DatabaseHelper.ID_DESCRICAO)
        val indiceData = cursor.getColumnIndex(DatabaseHelper.DATA_CADASTRO)

        while (cursor.moveToNext()) {

            val idTarefa = cursor.getInt(indiceId)
            val descricao = cursor.getString(indiceDescricao)
            val data = cursor.getString(indiceData)


            listaTarefas.add(
                Tarefa(idTarefa, descricao, data)
            )


        }

        return listaTarefas
    }
}