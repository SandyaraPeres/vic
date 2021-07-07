package com.sandyara.aula21.data.repository

import com.sandyara.aula21.data.model.Response
import io.reactivex.Observable

class MarvelRepository {
    fun fetchCharactersList() : Observable<Response> {
        return Network.getService().allCharacters()
    }

    fun fetchCharactersListLocally(){
        //return Network.getDatabase().get
    }
}