package com.sandyara.aula21.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sandyara.aula21.data.model.Character
import com.sandyara.aula21.data.repository.MarvelRepository
import com.sandyara.aula21.data.repository.Network
import com.sandyara.aula21.domain.FetchCharactersUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainActivityViewModel : ViewModel() {

    //QUEM VÊ É A VIEWMODEL
    private val _charactersLiveData = MutableLiveData<List<Character>>()
    //QUEM VÊ É A ACTIVITY
    val charactersLiveData : LiveData<List<Character>> = _charactersLiveData

    //private val _deletedCharactersLiveData =  MutableLiveData<List<Character>>()

    private val _onCharacterDelete = MutableLiveData<Boolean>()
    private val fetchCharactersUseCase = FetchCharactersUseCase()

    fun getCharacters(){
        fetchCharactersUseCase.execute()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnError {
                    //Faça algo se der erro na REQUEST <3
                }
                .subscribe{
                    _charactersLiveData.value = it.data.results
                }
                .dispose()
    }

    fun addCharacter(){

    }
//
//    fun deleteCharacter(id: Int){
//        fetchCharactersUseCase.execute(id)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .doOnComplete {
//                    getCharacters()
//                }
//                .subscribe{
//                    _charactersLiveData.value = it.data.results
//                }
//    }
}