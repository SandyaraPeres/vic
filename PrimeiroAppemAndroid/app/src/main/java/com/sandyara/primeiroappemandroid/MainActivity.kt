package com.sandyara.primeiroappemandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var textoGlobal : TextView
    //    val textoGlobal by lazy {
    //        findViewById<TextView>(R.id.texto)
    //    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //String -> Cadeias de caracteres
        //Int -> Numeros inteiros ex. 0, 1, 2
        //Double -> 1234.56
        //Float -> 987.45
        //Char -> 'a'
        //Boolean -> true/false

        //INICIALIZAÇÃO
        //lateinit var alunas
        //by lazy

        textoGlobal = findViewById(R.id.texto)

        //textoGlobal = findViewById<TextView>(R.id.texto)
        //texto.text = "Oi, este é o meu primeiro app!"

        //var -> são mutáveis e permitem seu conteúdo ser editável.
        var nome : String = "Sandy"
        nome = "Dani"
        //nome = 5
        nome = "Séphora"

        //val -> são imutáveis. Equivalente "final"
        val professora = "Sandy"
        //professora = "Dani"

        val numeroQualquer = 21
        val numeroConvertido = numeroQualquer.toString()

        textoGlobal.text = construirMensagem(nome)
        //textoGlobal.text = "Boas vindas, $nome"

    }

    //equivalente ao "void", não há retorno, no Java.
    //    fun exibirTexto(nomeParametro: String){
    //        //val texto = findViewById<TextView>(R.id.texto)
    //        textoGlobal.text = "Boas vindas, $nomeParametro! :)"
    //    }

    //função que há retorno
    fun construirMensagem(nomeParametro : String) : String = "Boas vindas, $nomeParametro"

    //    fun construirMensagem(nomeParametro : String) : String {
    //        return "Boas vindas, $nomeParametro"
    //    }

}