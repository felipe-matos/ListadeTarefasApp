package com.example.listadetarefasapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.listadetarefasapp.databinding.ActivityAdicionarTarefaBinding
import com.example.listadetarefasapp.databinding.ActivityMainBinding

class AdicionarTarefaActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityAdicionarTarefaBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

    }
}