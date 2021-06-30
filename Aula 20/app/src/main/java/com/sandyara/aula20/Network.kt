package com.sandyara.aula20

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Network {

    private const val KEY = ""

    fun configRetrofit(base: String) : Retrofit{
        //https://viacep.com.br/ws/11060002/json/
        //https://viacep.com.br/ws/11333111/json/
        //https://viacep.com.br/ws/xpto/json/
        //1. CONFIGURACAO DO RETROFIT
        return Retrofit.Builder()
            .baseUrl(base)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}