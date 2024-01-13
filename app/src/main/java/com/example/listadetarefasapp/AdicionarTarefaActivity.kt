package com.example.listadetarefasapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.listadetarefasapp.database.TarefaDAO
import com.example.listadetarefasapp.databinding.ActivityAdicionarTarefaBinding
import com.example.listadetarefasapp.databinding.ActivityMainBinding
import com.example.listadetarefasapp.model.Tarefa

class AdicionarTarefaActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityAdicionarTarefaBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        binding.btnSalvar.setOnClickListener {

           if(binding.editTarefa.text.isNotEmpty()){

               val descricao = binding.editTarefa.text.toString()
               val tarefa = Tarefa(
                   -1,
                   descricao,
                   dataCadastro = "Default"
               )

               val tarefaDAO = TarefaDAO(this)
               if(tarefaDAO.salvar(tarefa)){
                   Toast.makeText(this,
                       "Tarefa cadastrada com sucesso",
                       Toast.LENGTH_SHORT)
                       .show()
                        finish()

               }

           }else{
               Toast.makeText(this,
                   "Preencha um tarefa",
                   Toast.LENGTH_SHORT)
                   .show()
           }

           }


    }

    private fun salvar() {

    }
}