package com.sandyara.aula20

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

//2. CRIAÇÃO DE CHAMADAS/SERVIÇOS
//Realizar contrato entre Retrofit <> Aplicação
interface CEPService {

    //Path parameter (parametro de caminho)
    //É um parametro na URL
    @GET("{cepInserido}/json/")
    fun buscarCEP(@Path("cepInserido") cep: String) : Call<Endereco>

    //fun atualizarCEP()

    //fun deletarCEP()
}