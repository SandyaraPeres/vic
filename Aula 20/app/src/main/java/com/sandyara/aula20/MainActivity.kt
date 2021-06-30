package com.sandyara.aula20

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var txtCep: TextView
    private lateinit var loading: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        txtCep = findViewById(R.id.txtCep)
        loading = findViewById(R.id.loading)

        val valorCep = "05317020"
        getUserZipcode(valorCep)
    }

    private fun getUserZipcode(cepInserido: String){
        //1. Configurar base do Retrofit
        val retrofitClient = Network.configRetrofit("https://viacep.com.br/ws/")

        //2. Criar serviço a ser utilizado (conjunto de chamadas)
        //Quem implementa essa interface, é o Retrofit internamente
        //https://viacep.com.br/ws/ + "..."
        val servico = retrofitClient.create(CEPService::class.java)

        //Dos servicos que o Retrofit implementou, qual a requisição que será feita
        val requisicao = servico.buscarCEP(cepInserido)

        requisicao.enqueue(
            object: Callback<Endereco> {
                override fun onResponse(call: Call<Endereco>, response: Response<Endereco>) {
                    loading.visibility = View.GONE
                    val enderecoUsuario = response.body()
                    enderecoUsuario?.let{
                        txtCep.text = it.exibirEnderecoCompleto()
                    }
                }

                override fun onFailure(call: Call<Endereco>, t: Throwable) {
                    loading.visibility = View.GONE

                    t.message?.let { Log.e("RetrofitError", it) }
                    Toast.makeText(this@MainActivity,
                        "Houve um erro na sua solicitação.",
                        Toast.LENGTH_SHORT).show()
                }
            }
        )
    }
}