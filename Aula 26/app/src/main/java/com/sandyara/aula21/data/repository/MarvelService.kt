package com.sandyara.aula21.data.repository

import com.sandyara.aula21.data.model.Response
import io.reactivex.Observable
import retrofit2.http.GET

interface MarvelService {
    @GET("characters")
    fun allCharacters(): Observable<Response>
}