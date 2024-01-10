package com.example.listadetarefasapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.listadetarefasapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        binding.fabAdicionar.setOnClickListener {
            val intent =  Intent(this,AdicionarTarefaActivity::class.java)
            startActivity(intent)
        }


    }
}