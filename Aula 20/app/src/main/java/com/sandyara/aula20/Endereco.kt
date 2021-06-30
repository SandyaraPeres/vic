package com.sandyara.aula20

import com.google.gson.annotations.SerializedName

data class Endereco(
    val cep: String,
    val logradouro: String,
    val bairro: String,
    @SerializedName("localidade")
    val cidade: String,
    @SerializedName("uf")
    val estado: String,
    val favorito: Boolean = true
){
    fun exibirEnderecoCompleto() : String = "Endereço: $logradouro $cidade $estado"
}