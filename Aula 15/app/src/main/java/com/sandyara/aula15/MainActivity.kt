package com.sandyara.aula15

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvContatos : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvContatos = findViewById(R.id.rvContatos)

        //DATASET
        val lista = mutableListOf<Contato>(
            Contato("Rachel", "Moça da Calopsita"),
            Contato("Monique", "Moça do fone rosa")
        )

        //rvContatos.adapter
        //rvContatos.layoutManager
    }
}