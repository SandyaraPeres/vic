package com.sandyara.aula21

import io.reactivex.Observable
import retrofit2.http.GET

interface MarvelService {
    @GET("characters")
    fun allCharacters(): Observable<Response>
}