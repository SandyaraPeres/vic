package com.sandyara.aula15

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager

class MainActivity : AppCompatActivity() {

    private lateinit var rvContatos : RecyclerView
    private lateinit var contatosAdapter: ContatosAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvContatos = findViewById(R.id.rvContatos)

        //DATASET
        val lista = mutableListOf<Contato>(
            Contato("Rachel", "Moça da Calopsita, Moça da Calopsita, Moça da Calopsita"),
            Contato("Monique", "Moça do fone rosa"),
            Contato("Iolanda", "Moça da bateria em casa, Moça da bateria em casa, Moça da bateria em casa"),
            Contato("Samyra Rocha", "Moça da uva congelada"),
            Contato("Luiza", "Moça do algoritmo")
        )

        contatosAdapter = ContatosAdapter(context = this, dataSet = lista)

        rvContatos.adapter = contatosAdapter

        //1. LinearLayoutManager = lista unidimensional (única coluna) que pdoe ser horizontal ou vertical (padrão)
        //VERTICAL
        //rvContatos.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        // HORIZONTAL
        // rvContatos.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        //2. GridLayoutManager = lista multidimensional - com várias colunas
        //rvContatos.layoutManager = GridLayoutManager(this, 2)
        //3. StaggeredGridLayoutManager = lista multidimensional - com várias colunas que varia o tamanho de sua largura ou altura
        rvContatos.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

    }

    fun filtrar(){
        //contatosAdapter.atualizarLista()
    }
}