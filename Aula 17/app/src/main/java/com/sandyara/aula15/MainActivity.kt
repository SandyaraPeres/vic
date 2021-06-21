package com.sandyara.aula15

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager

class MainActivity : AppCompatActivity(), ItemListener {

    private lateinit var rvContatos : RecyclerView
    private lateinit var contatosAdapter: ContatosAdapter
    private val lista = mutableListOf<Contato>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvContatos = findViewById(R.id.rvContatos)

        //DATASET
        lista.add(
            Contato("Rachel", "Moça da Calopsita, Moça da Calopsita, Moça da Calopsita"),
        )

        contatosAdapter = ContatosAdapter(listener = this, dataSet = lista)

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

    override fun setOnDeleteListener() {
        Toast.makeText(this, "Item deletado", Toast.LENGTH_LONG).show()
    }

    override fun setAdd() {
        TODO("Not yet implemented")
    }
}