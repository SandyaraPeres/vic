package com.sandyara.aula21.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sandyara.aula21.data.repository.Network
import com.sandyara.aula21.R
import com.sandyara.aula21.data.model.Character
import com.sandyara.aula21.presentation.adapter.CharactersAdapter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {

    private lateinit var charactersAdapter: CharactersAdapter
    private lateinit var rvCharacters: RecyclerView
    private val viewModel = MainActivityViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvCharacters = findViewById(R.id.rvCharacters)
        charactersAdapter = CharactersAdapter()
        rvCharacters.adapter = charactersAdapter
        rvCharacters.layoutManager = LinearLayoutManager(this)

        //val aaa = 1
        //aaa.convertToString()
//        rvCharacters.setOnClickListener {
//            viewModel.getCharacters()
//        }

        viewModel.getCharacters()
        setupObserveCharactersList()
    }

//    fun onItemDeleted(){
//        viewModel.deleteCharacter()
//    }

    fun setupObserveCharactersList() {
        viewModel.charactersLiveData.observe(this,
                { resposta ->
                    resposta?.let {
                        charactersAdapter.dataset.addAll(it)
                        charactersAdapter.notifyDataSetChanged()
                    }
                }
        )
    }

    fun setupMensagemUsuario(): String{
        return "Teste! :)"
    }

}