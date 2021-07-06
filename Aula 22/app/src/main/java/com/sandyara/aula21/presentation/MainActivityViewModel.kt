package com.sandyara.aula21.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sandyara.aula21.data.model.Character
import com.sandyara.aula21.data.repository.Network
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainActivityViewModel : ViewModel() {

    private lateinit var charactersLiveData: MutableLiveData<List<Character>>

    fun getCharacters() : MutableLiveData<List<Character>> {
        Network.getService().allCharacters()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnError {
                    //Log.e()
                }
                .subscribe()
        return charactersLiveData
    }
}