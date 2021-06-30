package com.sandyara.aula20

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

//Mesma coisa que o object :...
class EnderecoResponseCallback : Callback<Endereco> {
    override fun onResponse(call: Call<Endereco>, response: Response<Endereco>) {
        TODO("Not yet implemented")
    }

    override fun onFailure(call: Call<Endereco>, t: Throwable) {
        TODO("Not yet implemented")
    }
}