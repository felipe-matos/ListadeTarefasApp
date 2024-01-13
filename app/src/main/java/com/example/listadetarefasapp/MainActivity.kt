package com.example.listadetarefasapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.listadetarefasapp.database.TarefaDAO
import com.example.listadetarefasapp.databinding.ActivityMainBinding
import com.example.listadetarefasapp.model.Tarefa

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private  var listaTarefas = emptyList<Tarefa>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        binding.fabAdicionar.setOnClickListener {
            val intent =  Intent(this,AdicionarTarefaActivity::class.java)
            startActivity(intent)
        }

    }

    override fun onStart() {
        super.onStart()

        val tarefaDAO = TarefaDAO(this)
        listaTarefas = tarefaDAO.listar()

        listaTarefas.forEach{tarefa ->
            Log.i("info_db", "${tarefa.descricao}\n")
        }


    }

}