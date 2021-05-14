package com.sandyara.calculoidade

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var campoDeTexto : EditText? = null
    lateinit var resultado: TextView
    lateinit var calcular: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        campoDeTexto = findViewById(R.id.edtIdade)
        resultado = findViewById(R.id.txtResultado)
        calcular = findViewById(R.id.btnCalcular)

        calcular.setOnClickListener {
            //Tudo a ser executado, será somente quando o usuário tocar no botão
            // ? = voce é nulo?
            val idadeInserida = campoDeTexto?.text.toString()
            //if(idadeInserida.isNotEmpty())
            val idadeEmNumero = idadeInserida.toIntOrNull()

            when(idadeEmNumero){
                null -> campoDeTexto?.error = "Essa idade não é válida!"
                16, 17, in 70..120 -> resultado.text = "Você pode votar, não é obrigatório"
                in 18..69 -> resultado.text = "Você é obrigade a votar."
                else -> {
                    resultado.text = "Você ainda não pode votar. Pense bem!"
                }
            }

            // ? = voce é nulo?
//            if(idadeEmNumero != null){
//                if(idadeEmNumero >= 16){
//                    if(idadeEmNumero >= 18){
//                        //OBRIGADE a votar
//                        resultado.text = "Você é obrigade a votar."
//                    } else {
//                        resultado.text = "Você pode votar, não é obrigatório"
//                    }
//                } else {
//                    resultado.text = "Você ainda não pode votar. Pense bem!"
//                }
//            } else {
//                campoDeTexto?.error = "Por favor, insira sua idade!"
//            }

//            idadeEmNumero?.let{
//                if(idadeEmNumero >= 16){
//                    if(idadeEmNumero >= 18){
//                        //OBRIGADE a votar
//                        resultado.text = "Você é obrigade a votar."
//                    } else {
//                        resultado.text = "Você pode votar, não é obrigatório"
//                    }
//                } else {
//                    resultado.text = "Você ainda não pode votar. Pense bem!"
//                }
//            }

//            val mes = 2
//
//            var mesEscritoLegal = when(mes){
//                1 -> "Janeiro"
//                2 -> "Fevereiro"
//                else -> {
//                    "Mes inválido"
//                }
//            }

        }

    }
}