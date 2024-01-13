package com.example.listadetarefasapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.listadetarefasapp.adapter.TarefaAdapter
import com.example.listadetarefasapp.database.TarefaDAO
import com.example.listadetarefasapp.databinding.ActivityMainBinding
import com.example.listadetarefasapp.model.Tarefa

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private  var listaTarefas = emptyList<Tarefa>()
    private var tarefaAdapter : TarefaAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        binding.fabAdicionar.setOnClickListener {
            val intent =  Intent(this,AdicionarTarefaActivity::class.java)
            startActivity(intent)
        }

        //RecyclerView
        tarefaAdapter = TarefaAdapter()

        binding.rvTarefas.adapter = tarefaAdapter
        binding.rvTarefas.layoutManager =LinearLayoutManager(this)

    }

    private fun atualizarListaTarefas(){

        val tarefaDAO = TarefaDAO(this)
        listaTarefas = tarefaDAO.listar()
        tarefaAdapter?.adicionarLista(listaTarefas)

    }

    override fun onStart() {
        super.onStart()
        atualizarListaTarefas()



    }

}