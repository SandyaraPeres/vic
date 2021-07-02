package com.sandyara.aula21

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {

    private lateinit var charactersAdapter: CharactersAdapter
    private lateinit var rvCharacters: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvCharacters = findViewById(R.id.rvCharacters)
        charactersAdapter = CharactersAdapter()
        rvCharacters.adapter = charactersAdapter
        rvCharacters.layoutManager = LinearLayoutManager(this)

        //val aaa = 1
        //aaa.convertToString()

        getCharacters()
    }

    fun getCharacters() {
        Network.getService().allCharacters()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnError {
                //Log.e()
            }
            .subscribe { resposta ->
                charactersAdapter.dataset.addAll(resposta.data.results)
                charactersAdapter.notifyDataSetChanged()
            }

    }
}