package com.template.aula10tarefas.presentation

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.template.aula10tarefas.R
import com.template.aula10tarefas.db.AppDatabase
import com.template.aula10tarefas.model.Tarefa
import com.template.aula10tarefas.presentation.adapter.TarefaAdapter
import com.template.aula10tarefas.presentation.adapter.TarefaAdapterListener
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity(), TarefaAdapterListener {

    lateinit var tarefaAdapter: TarefaAdapter
    lateinit var edtTarefa: EditText
    lateinit var btnIncluir: ImageButton
    lateinit var preferenciasTarefa: SharedPreferences
    lateinit var rv: RecyclerView
    lateinit var viewModel: MainActivityViewModel

    var db: AppDatabase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = MainActivityViewModel(application = application)

        // #Preferencias
        // Criando o arquivo de preferĂȘncias
        preferenciasTarefa = getSharedPreferences("tarefaPreferences", Context.MODE_PRIVATE)

        rv = findViewById<RecyclerView>(R.id.rvTarefas)

        btnIncluir = findViewById(R.id.btnIncluir)
        edtTarefa = findViewById(R.id.edtTarefa)

        btnIncluir.setOnClickListener() {
            if (edtTarefa.text.toString().isNotEmpty()) {
                adicionarTarefa(edtTarefa.text.toString())
                edtTarefa.text.clear()

                // Apagar a preferĂȘncia gravada anteriormente
                val editor = preferenciasTarefa.edit()
                editor.remove("NOME")
                editor.commit()
            } else {
                edtTarefa.error = "Insira um texto vĂĄlido!"
            }
        }

        setupTarefasObserver()
    }

    fun adicionarTarefa(nomeTarefa: String) {
            viewModel.addTarefa(Tarefa(nome=nomeTarefa))
    }

    fun recuperarLista(){
        viewModel.getTarefas()
    }

    // #Preferencias
    override fun onPause() {
        super.onPause()

        if (edtTarefa.text.toString().isNotEmpty()){

            // Cria e ediĂ§ĂŁo na preferĂȘncia
            val editor = preferenciasTarefa.edit()

            // Escreve um uma preferĂȘncia
            editor.putString("NOME", edtTarefa.text.toString())

            // Salva a preferĂȘncia
            editor.commit()
        }
    }

    // #Preferencias
    override fun onResume() {
        super.onResume()

        // Recupera (lĂȘ) uma preferĂȘncia e utiliza ela populando um Edit Text
        edtTarefa.setText(preferenciasTarefa.getString("NOME", null))
    }

    override fun onStart() {
        super.onStart()

        recuperarLista()
    }

    override fun excluirTarefa(tarefa: Tarefa) {
        viewModel.deleteTarefa(tarefa)
    }

    fun setupTarefasObserver(){
        viewModel.tarefasObserver.observe(this){
            if (this@MainActivity::tarefaAdapter.isInitialized) {
                tarefaAdapter.refreshListTarefa(it)
            }
            else{
                it?.let{
                    tarefaAdapter = TarefaAdapter(it, this@MainActivity)

                    // Vincula o Adapter na Recycler View
                    rv.adapter = tarefaAdapter

                    // Exibe os itens em uma coluna Ășnica no padrĂŁo vertical
                    rv.layoutManager = LinearLayoutManager(this@MainActivity)
                }
            }
        }
    }
}
